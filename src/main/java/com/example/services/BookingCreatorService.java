package com.example.services;

import com.example.data.DetailsData;
import com.example.models.*;
import com.example.data.Database;

import java.time.LocalDate;
import java.util.function.Function;

public class BookingCreatorService {
    private InputService inputService;
    private ClientService clientService;
    private SummaryPrinter summaryPrinter;
    private PriceCalculator priceCalculator;

    public BookingCreatorService(InputService inputService, ClientService clientService, SummaryPrinter summaryPrinter, PriceCalculator priceCalculator) {
        this.inputService = inputService;
        this.clientService = clientService;
        this.summaryPrinter = summaryPrinter;
        this.priceCalculator = priceCalculator;
    }

    public void createBooking(Accommodation accommodation, Object selection) {
        if (isStayBooking(accommodation, selection)) {
            processStayBooking((Stay) accommodation, (Room) selection);
            return;
        }
        processDayPassOrThrow(accommodation, selection);
    }

    private Boolean isStayBooking(Accommodation accommodation, Object selection) {
        return accommodation instanceof Stay && selection instanceof Room;
    }

    private Boolean isDayPassBooking(Accommodation accommodation, Object selection) {
        return accommodation instanceof DayPass && selection instanceof Service;
    }

    private void processDayPassOrThrow(Accommodation accommodation, Object selection) {
        if (isDayPassBooking(accommodation, selection)) {
            processDayPassBooking((DayPass) accommodation, (Service) selection);
            return;
        }
        throwInvalidBooking();
    }

    private void throwInvalidBooking() {
        throw new IllegalArgumentException("Tipo de alojamiento o selección no soportados");
    }


    private void processStayBooking(Stay stay, Room room) {
        processBooking(stay, this::collectStayDetails, details -> priceCalculator.calculateStayPrice(room.getPrice(), ((DetailsStay) details).getRoomsQuantity(), details.getAdultsQuantity() + details.getChildrenQuantity()), room.getType());
    }

    private void processDayPassBooking(DayPass dayPass, Service service) {
        processBooking(dayPass, this::collectDayPassDetails, details -> priceCalculator.calculateDayPassPrice(dayPass.getPersonPrice(), details.getAdultsQuantity() + details.getChildrenQuantity()), service.getName());
    }

    private DetailsStay collectStayDetails(Stay stay) {
        LocalDate startDate = inputService.promptDate("Ingrese la fecha de inicio (DD/MM/YYYY):");
        LocalDate endDate = inputService.promptDate("Ingrese la fecha de fin (DD/MM/YYYY):");
        Integer adults = inputService.promptInt("Ingrese la cantidad de adultos:");
        Integer children = inputService.promptInt("Ingrese la cantidad de niños:");
        Integer rooms = inputService.promptInt("Ingrese la cantidad de habitaciones:");

        DetailsData detailsData = new DetailsData(startDate, children, adults, stay.getCity());

        return new DetailsStay(detailsData, endDate, rooms, stay.getType());
    }

    private Details collectDayPassDetails(DayPass dayPass) {
        LocalDate date = inputService.promptDate("Ingrese la fecha del día de sol (DD/MM/YYYY):");
        Integer adults = inputService.promptInt("Ingrese la cantidad de adultos:");
        Integer children = inputService.promptInt("Ingrese la cantidad de niños:");

        DetailsData detailsData = new DetailsData(date, children, adults, dayPass.getCity());

        return new Details(detailsData);
    }


    private void confirmAndCreate(Accommodation accommodation, Details details, Float totalPrice, Integer totalPeople, String selectionName) {
        if (confirmReservation(totalPrice)) {
            Client client = createAndPrintClient();
            saveBooking(accommodation, details, client);
            printSuccessMessage();
        } else {
            printCancellationMessage();
        }
    }

    private Boolean confirmReservation(Float totalPrice) {
        summaryPrinter.printTotalPrice(totalPrice);
        summaryPrinter.printConfirmationPrompt();
        return inputService.promptString("").equalsIgnoreCase("S");
    }

    private Client createAndPrintClient() {
        Client client = clientService.createClient();
        summaryPrinter.printClientDetails(client);
        return client;
    }

    private void saveBooking(Accommodation accommodation, Details details, Client client) {
        Booking booking = new Booking(accommodation, client, details);
        Database.getBookings().add(booking);
    }

    private void printSuccessMessage() {
        System.out.println("¡Reserva creada exitosamente!");
    }

    private void printCancellationMessage() {
        System.out.println("Reserva cancelada.");
    }

    private <T extends Accommodation> void processBooking(T accommodation, Function<T, Details> collectDetails, Function<Details, Float> calculateTotalPrice, String selectionName) {
        Details details = collectDetails.apply(accommodation);
        summaryPrinter.printSummary("Resumen de la reserva:", details, accommodation.getName(), selectionName);
        Float totalPrice = calculateTotalPrice.apply(details);
        confirmAndCreate(accommodation, details, totalPrice, details.getAdultsQuantity() + details.getChildrenQuantity(), selectionName);
    }

}
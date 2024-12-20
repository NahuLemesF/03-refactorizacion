package com.example.services;

import com.example.data.Database;
import com.example.models.DayPass;
import com.example.models.Service;
import com.example.services.interfaces.IValidatorService;

import java.util.List;
import java.util.Scanner;

public class DayPassService extends BaseReservationService {

    public DayPassService(Scanner scanner, IValidatorService validatorService) {
        super(scanner, validatorService);
    }

    public void createDayPass() {
        String cityName = selectCity(Database.getDaypass());
        List<DayPass> dayPassesByCity = filterDayPassesByCity(cityName);
        DayPass selectedDayPass = selectDayPass(dayPassesByCity);
        Service selectedService = selectService(selectedDayPass);

        createBooking(selectedDayPass, selectedService);
    }

    private List<DayPass> filterDayPassesByCity(String city) {
        return Database.getDaypass().stream()
                .filter(dayPass -> dayPass.getCity().equalsIgnoreCase(city))
                .toList();
    }

    private DayPass selectDayPass(List<DayPass> dayPasses) {
        printOptions("Días de Sol disponibles:", dayPasses, dayPass -> String.format(
                "Nombre: %s\nDescripción: %s\nCalificación: %.1f\nPrecio por persona: %.2f",
                dayPass.getName(), dayPass.getDescription(), dayPass.getRate(), dayPass.getPersonPrice()));
        Integer dayPassIndex = readOption(dayPasses.size());
        return dayPasses.get(dayPassIndex - 1);
    }

    private Service selectService(DayPass dayPass) {
        List<Service> services = dayPass.getServices();
        printOptions("Servicios disponibles:", services, service -> String.format(
                "Nombre: %s\nDescripción: %s",
                service.getName(), service.getDescription()));
        Integer serviceIndex = readOption(services.size());
        return services.get(serviceIndex - 1);
    }

    private void createBooking(DayPass dayPass, Service service) {
        InputService inputService = new InputService(scanner, validatorService);
        BookingCreatorService bookingCreatorService = new BookingCreatorService(
                inputService,
                new ClientService(inputService),
                new SummaryPrinter(),
                new PriceCalculator()
        );
        bookingCreatorService.createBooking(dayPass, service);
    }
}

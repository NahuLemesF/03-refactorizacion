package com.example.services;

import com.example.data.Database;
import com.example.models.*;

import java.util.List;
import java.util.Scanner;

public class DayPassService extends BaseReservationService {
    public DayPassService(Scanner scanner) {
        super(scanner);
    }

    public void createDayPass() {
        String cityName = selectCity();
        List<DayPass> dayPassesByCity = filterDayPassesByCity(cityName);
        DayPass selectedDayPass = selectDayPass(dayPassesByCity);
        Service selectedService = selectService(selectedDayPass);

        BookingCreatorService bookingCreatorService = new BookingCreatorService(scanner);
        bookingCreatorService.createBooking(selectedDayPass, selectedService);
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
        int dayPassIndex = readOption(dayPasses.size());
        return dayPasses.get(dayPassIndex - 1);
    }

    private Service selectService(Accommodation accommodation) {
        List<Service> services = accommodation.getServices();
        printOptions("Servicios disponibles:", services, service -> String.format(
                "Nombre: %s\nDescripción: %s",
                service.getName(), service.getDescription()));
        int serviceIndex = readOption(services.size());
        return services.get(serviceIndex - 1);
    }

    private <T> void printOptions(String header, List<T> items, java.util.function.Function<T, String> formatter) {
        System.out.println(header);
        for (int i = 0; i < items.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, formatter.apply(items.get(i)));
        }
    }
}

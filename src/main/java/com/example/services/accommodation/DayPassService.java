package com.example.services.accommodation;

import com.example.models.DayPass;
import com.example.models.Service;
import com.example.repositories.AccommodationRepository;
import com.example.services.booking.BookingService;
import com.example.services.interfaces.IValidatorService;

import java.util.ArrayList;
import java.util.List;

public class DayPassService extends BaseReservationService {
    public static List<DayPass> dayPassList = new ArrayList<>();

    public DayPassService(IValidatorService validatorService) {
        super(validatorService);
    }

    public void createDayPass(String city, BookingService bookingService) {
        dayPassList = getDayPassesByCity(city);

        if (dayPassList.isEmpty()) {
            System.out.println("No hay Días de Sol disponibles en esta ciudad.");
            return;
        }

        DayPass selectedDayPass = selectFromList(
                "Seleccione un Día de Sol:",
                dayPassList,
                "Seleccione un Día de Sol (número):"
        );

        Service selectedService = selectFromList(
                "Seleccione un servicio:",
                selectedDayPass.getServices(),
                "Seleccione un servicio (número):"
        );

        bookingService.createBooking(selectedDayPass, selectedService);
    }


    private List<DayPass> getDayPassesByCity(String city) {
        return AccommodationRepository.getInstance().getAccomodations().stream()
                .filter(accommodation -> accommodation instanceof DayPass)
                .map(accommodation -> (DayPass) accommodation)
                .filter(dayPass -> dayPass.getCity().equalsIgnoreCase(city))
                .toList();
    }
}

package com.example.services.accommodation;

import com.example.models.Accommodation;
import com.example.models.Room;
import com.example.models.Service;
import com.example.repositories.AccommodationRepository;
import com.example.services.interfaces.IValidatorService;

import java.util.List;

public abstract class BaseReservationService {
    protected final IValidatorService validatorService;

    public BaseReservationService(IValidatorService validatorService) {
        this.validatorService = validatorService;
    }

    protected String selectCity() {
        return selectFromList(
                "Ciudades disponibles:",
                AccommodationRepository.getInstance().getAccomodations().stream()
                        .map(Accommodation::getCity)
                        .distinct()
                        .toList(),
                "Seleccione una ciudad:"
        );
    }

    protected <T> T selectFromList(String header, List<T> items, String prompt) {
        System.out.println(header);
        for (int i = 0; i < items.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, formatItem(items.get(i)));
        }
        int index = validatorService.readInt(prompt) - 1;
        return items.get(index);
    }

    private String formatItem(Object item) {
        if (item instanceof Room room) {
            return String.format("%s (Tipo: %s, Precio: $%.2f)", room.getName(), room.getType(), room.getPrice());
        }
        if (item instanceof Service service) {
            return String.format("%s (Precio: $%.2f)", service.getName(), service.getPrice());
        }
        return item.toString();
    }
}

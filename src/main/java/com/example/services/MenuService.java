package com.example.services;

import com.example.services.interfaces.IMenuService;
import com.example.services.interfaces.IValidatorService;

import java.util.Arrays;
import java.util.List;

public class MenuService implements IMenuService {
    private final IValidatorService validatorService;

    public MenuService(IValidatorService validatorService) {
        this.validatorService = validatorService;
    }


    public Integer showMenu() {
        System.out.println(
                "¡Bienvenido a HotelApp! \n" +
                        " Por favor, elija una opción: \n" +
                        " 1. Buscar alojamientos \n" +
                        " 2. Actualizar una reserva \n" +
                        " 3. Cancelar una reserva \n" +
                        " 4. Salir");

        Integer option = validatorService.readInt("Por favor, elija una opción:");

        List<Integer> validOptions = Arrays.asList(1, 2, 3, 4);

        if (!validOptions.contains(option)) {
            System.out.println("La opción ingresada no es válida. Por favor, elija una opción válida.");
            return showMenu();
        }

        return option;
    }
}

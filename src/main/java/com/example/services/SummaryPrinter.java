package com.example.services;

import com.example.models.Client;
import com.example.models.Details;

public class SummaryPrinter {

    public void printSummary(String header, Details details, String accommodationName, String selectionName) {
        System.out.printf(
            "%s%nCiudad: %s%nAlojamiento: %s%nSelección: %s%nNiños: %d, Adultos: %d%n",
            header,
            details.getCity(),
            accommodationName,
            selectionName,
            details.getChildrenQuantity(),
            details.getAdultsQuantity()
        );
    }

    public void printClientDetails(Client client) {
        System.out.printf(
            "¡Gracias! Su reserva ha sido confirmada.%nCliente: %s %s%nFecha de nacimiento: %s%nTeléfono: %s%nNacionalidad: %s%nCorreo: %s%nHora de llegada: %s%n",
            client.getFirstName(),
            client.getLastName(),
            client.getBirthDate(),
            client.getPhoneNumber(),
            client.getNationality(),
            client.getEmail(),
            client.getArrivalTime()
        );
    }

    public void printTotalPrice(float totalPrice) {
        System.out.printf("Precio total: $%.2f%n", totalPrice);
    }

    public void printConfirmationPrompt() {
        System.out.println("¿Desea confirmar su reserva? (S/N)");
    }
}

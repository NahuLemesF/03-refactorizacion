package com.example.services.interfaces;

import java.time.LocalDate;
import java.time.LocalTime;

public interface IValidatorService {
    String readString(String prompt);
    Integer readInt(String prompt);
    Float readFloat(String prompt);
    LocalDate readLocalDate(String prompt);
    LocalTime readLocalTime(String prompt);
    void clearBuffer();
}
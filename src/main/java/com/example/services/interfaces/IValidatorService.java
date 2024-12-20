package com.example.services.interfaces;

import java.time.LocalDate;
import java.time.LocalTime;

public interface IValidatorService {
    String readString(String prompt);
    Integer readInt(String prompt);
    LocalDate readLocalDate(String prompt);
}
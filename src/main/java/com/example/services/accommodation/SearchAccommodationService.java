package com.example.services.accommodation;

import com.example.models.Accommodation;
import com.example.models.Stay;
import com.example.repositories.AccommodationRepository;

import java.util.List;
import java.util.stream.Collectors;

public class SearchAccommodationService {
    private final AccommodationRepository accommodationRepository;

    public SearchAccommodationService(AccommodationRepository accommodationRepository) {
        this.accommodationRepository = accommodationRepository;
    }

    public List<String> getCities() {
        return accommodationRepository.getAccomodations().stream()
                .map(Accommodation::getCity)
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Stay> getStaysByCity(String city) {
        return accommodationRepository.getAccomodations().stream()
                .filter(accommodation -> accommodation instanceof Stay)
                .map(accommodation -> (Stay) accommodation)
                .filter(stay -> stay.getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }
}

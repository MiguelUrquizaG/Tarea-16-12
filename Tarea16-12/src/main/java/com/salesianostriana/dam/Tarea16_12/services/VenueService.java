package com.salesianostriana.dam.Tarea16_12.services;

import com.salesianostriana.dam.Tarea16_12.models.Event;
import com.salesianostriana.dam.Tarea16_12.models.Venue;
import com.salesianostriana.dam.Tarea16_12.repository.VenueRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class VenueService {
    private final VenueRepository venueRepository;

    public Venue getById(Long id){
        return venueRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    /*public Set<Event>listEventsVenueCity(Long idVenue,String cityName){

    }*/

}

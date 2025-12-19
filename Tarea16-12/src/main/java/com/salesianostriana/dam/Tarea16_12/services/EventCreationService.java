package com.salesianostriana.dam.Tarea16_12.services;

import com.salesianostriana.dam.Tarea16_12.models.Event;
import com.salesianostriana.dam.Tarea16_12.models.EventStatus;
import com.salesianostriana.dam.Tarea16_12.models.Organizer;
import com.salesianostriana.dam.Tarea16_12.models.Venue;
import com.salesianostriana.dam.Tarea16_12.repository.EventRepository;
import com.salesianostriana.dam.Tarea16_12.repository.OrganizerRepository;
import com.salesianostriana.dam.Tarea16_12.repository.VenueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
@RequiredArgsConstructor
public class EventCreationService {
    private final EventRepository eventRepository;
    private final OrganizerRepository  organizerRepository;
    private final VenueRepository venueRepository;


    public Event create(String name, EventStatus eventStatus, Long idVenue, Long idOrganizer, LocalDate startAt, LocalDate endAt, LocalTime startTime, LocalTime endTime){
        Organizer organizer =organizerRepository.findById(idOrganizer).orElseThrow(() -> new RuntimeException("No existe ese organizer"));
        Venue venue = venueRepository.findById(idVenue).orElseThrow(() -> new RuntimeException("No existe el Venue"));

        if(!venue.checkEventSameDay(startAt,endAt)){
            throw new RuntimeException("No se puede tener un evento solapado con otro");
        }

        if(Event.checkHour(startTime,endTime)){
            throw new RuntimeException("Las horas no son válidas");
        }

        return  Event.builder()
                .name(name)
                .venue(venue)
                .organizer(organizer)
                .startedAt(startAt)
                .endAt(endAt)
                .eventStatus(eventStatus)
                .build();
    }

}

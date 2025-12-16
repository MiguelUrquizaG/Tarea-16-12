package com.salesianostriana.dam.Tarea16_12.services;

import com.salesianostriana.dam.Tarea16_12.models.*;
import com.salesianostriana.dam.Tarea16_12.repository.EventRepository;
import com.salesianostriana.dam.Tarea16_12.repository.OrganizerRepository;
import com.salesianostriana.dam.Tarea16_12.repository.VenueRepository;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final OrganizerRepository organizerRepository;
    private final VenueRepository venueRepository;

    public Event create(String name,Long idVenue,Long idOrganizer){
        Organizer organizer =organizerRepository.getReferenceById(idOrganizer);
        Venue venue = venueRepository.getReferenceById(idVenue);
        return  Event.builder()
                .name(name)
                .venue(venue)
                .organizer(organizer)
                .build();
    }

    public Event getEventById(Long id){
        return eventRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Set<Ticket> listTicketsFromShow(Long id){
        Event event = getEventById(id);
        return event.getTicketSet();
    }

}

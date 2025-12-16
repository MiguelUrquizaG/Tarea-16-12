package com.salesianostriana.dam.Tarea16_12.services;

import com.salesianostriana.dam.Tarea16_12.models.Ticket;
import com.salesianostriana.dam.Tarea16_12.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;



}

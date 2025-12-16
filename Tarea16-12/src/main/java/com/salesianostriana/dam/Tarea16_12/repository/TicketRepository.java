package com.salesianostriana.dam.Tarea16_12.repository;

import com.salesianostriana.dam.Tarea16_12.models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
}

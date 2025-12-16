package com.salesianostriana.dam.Tarea16_12.repository;

import com.salesianostriana.dam.Tarea16_12.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Long> {
}

package com.salesianostriana.dam.Tarea16_12.services;

import com.salesianostriana.dam.Tarea16_12.repository.AttendeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AttendeeService {

    private final AttendeeRepository attendeeRepository;


}

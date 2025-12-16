package com.salesianostriana.dam.Tarea16_12.services;

import com.salesianostriana.dam.Tarea16_12.repository.StaffAssignmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StaffAssignmentService {
    private final StaffAssignmentRepository staffAssignmentRepository;
}

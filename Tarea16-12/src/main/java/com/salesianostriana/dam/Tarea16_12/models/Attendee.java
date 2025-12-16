package com.salesianostriana.dam.Tarea16_12.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Attendee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String lastName;
    private int age;

    @OneToMany(mappedBy = "attendee")
    @Builder.Default
    private Set<StaffAssignment> staffAssignment = new HashSet<>();

}

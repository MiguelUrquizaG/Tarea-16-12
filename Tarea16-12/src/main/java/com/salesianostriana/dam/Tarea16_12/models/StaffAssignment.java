package com.salesianostriana.dam.Tarea16_12.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StaffAssignment {

    @EmbeddedId
    private StaffAssignmentPK staffAssignmentPK = new StaffAssignmentPK();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("attendee_id")
    @JoinColumn(name="attendee_id")
    Attendee attendee;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("event_id")
    @JoinColumn(name = "event_id")
    Event event;

    private LocalTime shiftStart;
    private LocalTime shiftEnd;
    private boolean paid;

    @Enumerated(EnumType.STRING)
    private Role role;
}

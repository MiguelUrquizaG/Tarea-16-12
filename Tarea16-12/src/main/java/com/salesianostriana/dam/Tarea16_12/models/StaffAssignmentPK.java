package com.salesianostriana.dam.Tarea16_12.models;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Embeddable
public class StaffAssignmentPK   {

    private Long attendee_id;
    private Long event_id;

}

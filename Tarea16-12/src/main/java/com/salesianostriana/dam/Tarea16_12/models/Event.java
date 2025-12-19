package com.salesianostriana.dam.Tarea16_12.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Organizer organizer;

    @ManyToOne(fetch = FetchType.LAZY)
    private Venue venue;

    @OneToMany(fetch = FetchType.LAZY)
    @Builder.Default
    private Set<Ticket>ticketSet = new HashSet<>();

    @OneToMany(mappedBy = "event")
    @Builder.Default
    private Set<StaffAssignment> staffAssignmentList=new HashSet<>();

    @Enumerated(EnumType.STRING)
    private EventStatus eventStatus;

    private LocalDate startedAt;
    private LocalTime startTime;
    private LocalDate endAt;
    private LocalTime endTime;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Event event = (Event) o;
        return getId() != null && Objects.equals(getId(), event.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }

    public static boolean checkHour(LocalTime startTime, LocalTime endTime){
        boolean isValid=true;

        if(startTime.isBefore(LocalTime.now())|| endTime.isBefore(LocalTime.now())){
            isValid = false;
        }

        return isValid;
    }
/*
    public void checkCancelled(EventStatus eventStatus){
        if(eventStatus.)
    }
    */
 
}

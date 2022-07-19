package tn.esprit.wellbeingwork.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author amoujbani on 7/19/2022
 * @project WellBeingWork
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idReservation;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Date reservationDate;

    private int numberOfReservations;

    @ManyToOne
    private User userParticipant;

    @ManyToOne
    private Offer offer;
}

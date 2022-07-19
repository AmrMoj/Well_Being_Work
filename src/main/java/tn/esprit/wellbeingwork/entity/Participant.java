package tn.esprit.wellbeingwork.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author amoujbani on 7/19/2022
 * @project WellBeingWork
 */
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Participant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idParticipant;

    @ManyToOne
    private User userParticipant;

    @ManyToOne
    private Event event;
}

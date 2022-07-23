package tn.esprit.wellbeingwork.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idParticipant")
public class Participant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idParticipant;

    @ManyToOne
    private User userParticipant;

    @ManyToOne
    private Event event;
}

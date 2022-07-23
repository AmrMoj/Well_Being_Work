package tn.esprit.wellbeingwork.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@Setter
@Getter
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idPollResult")
public class PollResult implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idPollResult;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Date creationDate;

    @ManyToOne
    private PollOption pollOption;

    @ManyToOne
    private User userChoice;
}

package tn.esprit.wellbeingwork.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author amoujbani on 7/19/2022
 * @project WellBeingWork
 */
@Entity
@NoArgsConstructor
@Setter
@Getter
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idOption")
public class PollOption implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idOption;

    private String pollOption;

    @ManyToOne
    private PollSubject pollSubject;

    @OneToMany(mappedBy = "pollOption")
    private List<PollResult> pollResults;


}

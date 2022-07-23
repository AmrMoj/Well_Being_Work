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
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idReact")
public class React implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idReact;

    //value= 0 dislike value=1 like
    private boolean likeDislike;

    @ManyToOne
    private User userReact;

    @ManyToOne
    private Event event;

    @ManyToOne
    private Post post;
}

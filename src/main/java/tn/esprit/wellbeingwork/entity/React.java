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
public class React implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idReact;

    //value= 0 dislike value=1 like
    private boolean likedislike;

    @ManyToOne
    private User userReact;

    @ManyToOne
    private Event event;

    @ManyToOne
    private Post post;
}

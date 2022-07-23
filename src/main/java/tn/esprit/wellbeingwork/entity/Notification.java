package tn.esprit.wellbeingwork.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idNotification")
public class Notification implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idNotification;

    private Date notificationDate;

    @ManyToOne
    private User userNotification;

    @ManyToOne
    private Post postNotification;

    @ManyToOne
    private Event eventNotification;
}

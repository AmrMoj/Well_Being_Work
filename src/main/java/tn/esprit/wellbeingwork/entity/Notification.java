package tn.esprit.wellbeingwork.entity;

import javafx.geometry.Pos;
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

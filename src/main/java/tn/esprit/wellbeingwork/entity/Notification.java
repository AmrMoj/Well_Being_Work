package tn.esprit.wellbeingwork.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Date notificationDate;

    @ManyToOne
    private User userNotification;

    @ManyToOne
    private Post postNotification;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Event eventNotification;

    @ManyToMany(mappedBy = "notifications", fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @Fetch(value = FetchMode.SUBSELECT)
    List<User> usersList =new ArrayList<>();

    private String notificationMessage;
}

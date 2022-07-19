package tn.esprit.wellbeingwork.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author amoujbani on 7/17/2022
 * @project WellBeingWork
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Event implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idEvent;

    private String eventName, description, location;
    private Date startDate, endDate;

    @Enumerated(EnumType.STRING)
    private EventCategory eventCategory;

    @ManyToOne
    private User userEventCreator;

    @OneToMany(mappedBy = "event")
    private List<EventRate> eventRates;

    @OneToMany(mappedBy = "event")
    private List<Participant> participantList;

    @OneToMany(mappedBy = "event")
    private List<React> reacts;

    @OneToMany(mappedBy = "event")
    private List<Comment> comments;

    @OneToMany(mappedBy = "eventNotification")
    private List<Notification> notifications;
 }

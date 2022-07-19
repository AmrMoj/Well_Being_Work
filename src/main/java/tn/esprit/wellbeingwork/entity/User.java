package tn.esprit.wellbeingwork.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
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
@AllArgsConstructor
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idUser;

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String password;
    private String address;
    private User hierarchicalManager;

    @Email
    @NotEmpty
    private String email;

    private boolean isAdministrator;
    private boolean isConfirmed;
    private Date birthdate;
    private int raterCount;
    private float rate;
    private Date workStartDate;

    @ColumnDefault("false")
    private boolean isArchived;

    @Enumerated(EnumType.STRING)
    private Position positionName;

    @Enumerated(EnumType.STRING)
    private Level level;

    @OneToMany(mappedBy = "userEventCreator")
    @JsonIgnore
    private List<Event> eventList;

    @OneToMany(mappedBy = "userEventRater")
    private List<EventRate> eventRates;

    @OneToMany(mappedBy = "userParticipant")
    private List<Participant> participantList;

    @OneToMany(mappedBy = "userReact")
    private List<React> reacts;

    @OneToMany(mappedBy = "userComment")
    private List<Comment> comments;

    @OneToMany(mappedBy = "userPostCreator")
    private List<Post> posts;

    @OneToMany(mappedBy = "userNotification")
    private List<Notification> notifications;

    @OneToMany(mappedBy = "pollCreator")
    private List<PollSubject> pollSubjects;

    @OneToMany(mappedBy = "userChoice")
    private List<PollResult> pollResults;

    @OneToMany(mappedBy = "userSender")
    private List<Message> messageSenders;

    @OneToMany(mappedBy = "userReceiver")
    private List<Message> messageReceivers;

    @OneToMany(mappedBy = "feedbackOwner")
    private List<Feedback> feedbackOwners;

    @OneToMany(mappedBy = "feedbackCreator")
    private List<Feedback> feedbackCreators;

    @OneToMany(mappedBy = "userParticipant")
    private List<Reservation> reservations;

    @OneToMany(mappedBy = "userPartner")
    private List<Partner> partners;

}

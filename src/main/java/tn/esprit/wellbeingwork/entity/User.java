package tn.esprit.wellbeingwork.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
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
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idUser")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idUser;

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String password;
    private String address;

    @OneToOne
    private User hierarchicalManager;

    @Email
    @NotEmpty
    private String email;
    @ManyToMany(fetch = FetchType.EAGER)
	private Collection<Role> roles = new ArrayList<Role>();
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
    private List<Event> eventList = new java.util.ArrayList<>();

    @OneToMany(mappedBy = "userEventRater")
    private List<EventRate> eventRates;

    @OneToMany(mappedBy = "userParticipant", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Participant> participantList;

    @OneToMany(mappedBy = "userReact")
    private List<React> reacts;

    @OneToMany(mappedBy = "userComment")
    private List<Comment> comments;

    @OneToMany(mappedBy = "userPostCreator")
    private List<Post> posts;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "collaborator_id", referencedColumnName = "id")
    private Collaborator collaborator;

    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "event_categories",
            joinColumns = @JoinColumn(name = "idUser"),
            inverseJoinColumns = @JoinColumn(name = "idEventCatego"))
    List<EventCatego> eventCategos;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JsonIgnore
    @JoinTable(
            name = "user_notification",
            joinColumns = @JoinColumn(name = "idUser"),
            inverseJoinColumns = @JoinColumn(name = "idNotification"))
    List<Notification> notifications;

    @Override
    public boolean equals(Object obj) {

        if (null == obj) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof User)) {
            return false;
        }

        User that = (User) obj;

        return -1 != this.getIdUser() && this.getIdUser()==(that.getIdUser());
    }

}

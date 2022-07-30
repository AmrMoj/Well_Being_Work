package tn.esprit.wellbeingwork.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
@AllArgsConstructor
@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="idEvent")
public class Event implements Serializable, Comparable <Event>{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idEvent;

    private String eventName;
    private String description;
    private String location;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date startDate;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date endDate;

    @Enumerated(EnumType.STRING)
    private EventCategory eventCategory;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User userEventCreator;

    @OneToMany(mappedBy = "event")
    private List<EventRate> eventRates;

    @OneToMany(mappedBy = "event", fetch =FetchType.EAGER )
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Participant> participantList;

    @OneToMany(mappedBy = "event")
    private List<React> reacts;

    @OneToMany(mappedBy = "event")
    private List<Comment> comments;

    @OneToMany(mappedBy = "eventNotification")
    private List<Notification> notifications;

    @ManyToOne()
    private EventCatego eventCatego;


    @Override
    public int compareTo(Event o) {
       return getStartDate().compareTo(o.getStartDate());
    }
}

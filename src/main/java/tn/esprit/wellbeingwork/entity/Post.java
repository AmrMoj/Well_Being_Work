package tn.esprit.wellbeingwork.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

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
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idPost")
public class Post implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idPost;

    private String postContent;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Date creationDate;

    @ManyToOne
    private User userPostCreator;

    @OneToMany(mappedBy = "post")
    private List<React> reacts;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    @OneToMany(mappedBy = "postNotification")
    private List<Notification> notifications;
}

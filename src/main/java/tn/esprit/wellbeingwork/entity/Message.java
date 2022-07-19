package tn.esprit.wellbeingwork.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author amoujbani on 7/17/2022
 * @project WellBeingWork
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idMessage;

    private String message;
    private boolean status;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Date creationDate;

    @ManyToOne
    private User userSender;

    @ManyToOne
    private User userReceiver;
}

package tn.esprit.wellbeingwork.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
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
public class PollSubject implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idPoll;

    private String subjectDescription;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Date creationDate;

    @ManyToOne
    private User pollCreator;

    @OneToMany(mappedBy = "pollSubject")
    private List<PollOption> pollOptions;
}

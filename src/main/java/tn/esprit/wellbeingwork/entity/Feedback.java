package tn.esprit.wellbeingwork.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idFeedback")
public class Feedback implements Serializable {
  enum feedbackType {
  NEGATIVE,
  NEUTRAL,
  POSITIVE
}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idFeedback;

    private String feedback;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Date creationDate;

    @ManyToOne
    private User feedbackOwner;

    @ManyToOne
    private User feedbackCreator;
    
    private feedbackType feedbackType;
}

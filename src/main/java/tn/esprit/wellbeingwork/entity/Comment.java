package tn.esprit.wellbeingwork.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author amoujbani on 7/19/2022
 * @project WellBeingWork
 */

@Entity
@NoArgsConstructor
@Getter
@Setter
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idComment")
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idComment;

    private String commentContent;

    @ManyToOne
    private User userComment;

    @ManyToOne
    private Event event;

    @ManyToOne
    private Post post;

    @ManyToOne
    @JoinColumn(name = "SUB_COMMENT_ID")
    private Comment commentParent;

    @OneToMany(mappedBy = "commentParent")
    private List<Comment> CommentChildren;
}

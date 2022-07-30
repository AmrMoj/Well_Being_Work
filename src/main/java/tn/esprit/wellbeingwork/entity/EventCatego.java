package tn.esprit.wellbeingwork.entity;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idEventCatego")
public class EventCatego {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idEventCatego;

    private String category;

    @OneToMany(mappedBy = "eventCatego")
    @JsonIgnore
    private List<Event> eventVector;

    @ManyToMany(mappedBy = "eventCategos", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    List<User> users;



}

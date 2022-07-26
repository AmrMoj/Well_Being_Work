package tn.esprit.wellbeingwork.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Collaborator {
    @Id
    @GeneratedValue(strategy = AUTO)
    public Long id;

    @OneToOne(mappedBy = "collaborator")
    private User user;
}

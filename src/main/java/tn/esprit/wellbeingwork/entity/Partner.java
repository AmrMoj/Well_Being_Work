package tn.esprit.wellbeingwork.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author amoujbani on 7/19/2022
 * @project WellBeingWork
 */
@Entity
@NoArgsConstructor
@Getter
@Setter
public class Partner implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idPartner;

    private String partnerName;
    private String address;

    @ManyToOne
    private User userPartner;


}

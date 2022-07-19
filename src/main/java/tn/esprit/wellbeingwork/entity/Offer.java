package tn.esprit.wellbeingwork.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@Getter
@Setter
public class Offer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idOffer;


    private String offerDescription;
    private Date offerStartDate;
    private Date offerEndDate;

    @OneToMany (mappedBy = "offer")
    private List<Reservation> reservations;



}

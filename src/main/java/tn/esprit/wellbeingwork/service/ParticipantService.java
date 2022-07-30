package tn.esprit.wellbeingwork.service;

import tn.esprit.wellbeingwork.entity.Participant;
import tn.esprit.wellbeingwork.entity.User;

import java.util.List;

public interface ParticipantService {

    public Participant addParticipant(Participant participant);
    List<User> findUserWithMatchingAddress (Long idEvent, String address);
    public void remindUsersOfEvent();
    public void userWhoHaventParticipatedInEvent();


}

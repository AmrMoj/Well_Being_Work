package tn.esprit.wellbeingwork.service;

import tn.esprit.wellbeingwork.entity.Reservation;

import java.util.List;

public interface ReservationService {
    List<Reservation> getAllReservations();

    Reservation addReservation(Reservation reservation);

    void deleteReservation(Long id);

    Reservation updateReservation(Reservation reservation);

    Reservation getReservation(Long id);

    List<Reservation> getCollaboratorReservation();
}

package tn.esprit.wellbeingwork.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.wellbeingwork.entity.Reservation;
import tn.esprit.wellbeingwork.service.ReservationService;

import java.util.List;


@RestController
@RequestMapping("/api/v1/reservations")
@Api(tags = "Reservation management")
@AllArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @ApiOperation(value="Add new reservation")
    @PostMapping("add-reservation")
    public Reservation addReservation(@RequestBody Reservation reservation){
        return reservationService.addReservation(reservation);
    }

    @ApiOperation(value = "Get all reservations")
    @GetMapping("get-all-reservations")
    public List<Reservation> retrieveAllReservations(){
        return reservationService.getAllReservations();
    }

    @ApiOperation(value = "Get a reservation")
    @GetMapping("get-reservation/{reservationId}")
    public Reservation getReservation(@PathVariable("reservationId") long id){
        return reservationService.getReservation(id);
    }
    @ApiOperation(value = "Get a reservation by user")
    @GetMapping("get-reservation-by-user}")
    public List<Reservation>  getReservationByUser(){
        return reservationService.getCollaboratorReservation();
    }

    @ApiOperation(value = "Delete a reservation")
    @DeleteMapping("delete-reservation/{reservationId}")
    public void deleteReservation(@PathVariable("reservationId") long id){
        reservationService.deleteReservation(id);
    }

    @ApiOperation(value = "Update a reservation")
    @PutMapping("update-reservation")
    public Reservation updateReservation(@RequestBody Reservation reservation){
        return reservationService.updateReservation(reservation);
    }
}
package tn.esprit.wellbeingwork.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.wellbeingwork.entity.Participant;
import tn.esprit.wellbeingwork.service.ParticipantService;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("Participant")
@Api(tags = "Participant management")
public class ParticipantController {

    @Autowired
    ParticipantService participantService;

    @ApiOperation(value="Add participant")
    @PostMapping("addParticipant")
    public ResponseEntity addParticipant (
            @RequestBody Participant participant){

        return new ResponseEntity(participantService.addParticipant(participant),
                HttpStatus.ACCEPTED);
    }

    @ApiOperation(value="Get users with matching address")
    @GetMapping("getUserWithMatchingAddress/{id-event}/{address}")
    public ResponseEntity findUserWithMatchingAddress (@PathParam("id-event") Long idEvent,
                                                       @PathParam("address") String address)
    {
        return new ResponseEntity(participantService.findUserWithMatchingAddress(idEvent, address),
                HttpStatus.ACCEPTED);

    }
}

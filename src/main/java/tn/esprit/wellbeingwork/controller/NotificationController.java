package tn.esprit.wellbeingwork.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.wellbeingwork.entity.Notification;
import tn.esprit.wellbeingwork.service.NotificationService;

@RestController
@RequestMapping("Notification")
@Api(tags = "Notification management")
public class NotificationController {

    @Autowired
    NotificationService notificationService;

    @ApiOperation(value="Add notification")
    @PostMapping("addNotification")
    public ResponseEntity addNotification (
            @RequestBody Notification notification){

        return new ResponseEntity(notificationService.addNotification(notification),
                HttpStatus.ACCEPTED);
    }

    @ApiOperation(value="Get notifications")
    @GetMapping("getNotifications")
    public ResponseEntity getNofications (){

        return new ResponseEntity(notificationService.getNotifications(),
                HttpStatus.ACCEPTED);
    }
}

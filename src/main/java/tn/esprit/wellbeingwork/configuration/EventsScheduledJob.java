package tn.esprit.wellbeingwork.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import tn.esprit.wellbeingwork.service.ParticipantService;

@Configuration
@Slf4j
@EnableAsync
public class EventsScheduledJob {

    @Autowired
    ParticipantService participantService;

    @Async
    @Scheduled(fixedRate = 86400)
    public void EventReminder() {
        log.info("Executing event reminder job");
        participantService.remindUsersOfEvent();
    }
    /*@Async
    @Scheduled(fixedRate = 86400)
    public void UserSurvey(){
        log.info("Executing survey job ");
        participantService.userWhoHaventParticipatedInEvent();
    }*/
}

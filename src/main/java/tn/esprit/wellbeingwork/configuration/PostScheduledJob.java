package tn.esprit.wellbeingwork.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import tn.esprit.wellbeingwork.service.PostService;

import java.io.IOException;
import java.text.ParseException;

@Configuration
public class PostScheduledJob {

    @Autowired
    PostService postService;

    //@Scheduled(fixedDelay = 86400000)
    @Scheduled(fixedDelay = 120000)
    public void jobScheduled() throws IOException, ParseException {
        System.out.printf("launch adding actualities batch job");
        postService.addActualites();
    }
}

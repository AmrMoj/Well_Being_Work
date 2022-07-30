package tn.esprit.wellbeingwork.service.implementation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import tn.esprit.wellbeingwork.entity.Event;
import tn.esprit.wellbeingwork.entity.Participant;
import tn.esprit.wellbeingwork.entity.User;
import tn.esprit.wellbeingwork.repository.EventRepository;
import tn.esprit.wellbeingwork.repository.ParticipantRepository;
import tn.esprit.wellbeingwork.repository.UserRepository;
import tn.esprit.wellbeingwork.service.EventService;
import tn.esprit.wellbeingwork.service.ParticipantService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
@Slf4j
public class ParticipantServiceImpl implements ParticipantService {

    @Autowired
    ParticipantRepository participantRepository;

    @Autowired
    EventRepository eventRepository;

    @Autowired
    EventService eventService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    public JavaMailSender emailSender;

    private Date eventDate;

    List<User> users= new ArrayList<>();
    List<Participant> participants=new ArrayList<>();
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String latestEventDateF;
    String userLatestEventDateF;

    private Date yesterday() {
        final Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, +1);
        return cal.getTime();
    }

    @Override
    public Participant addParticipant(Participant participant) {
        return participantRepository.save(participant);
    }

    @Override
    public List<User> findUserWithMatchingAddress(Long idEvent, String address) {
        Event event = eventRepository.findById(idEvent).get();
        return participantRepository.findUserWithMatchingAddress(event, address);
    }

    @Override
    public void remindUsersOfEvent() {

        List<Event> eventList = eventService.getEvents();
        //List<Participant> participants=new ArrayList<>();
        //List<User> users=new ArrayList<>();
        log.info("Tomorrow's date: "+dateFormat.format(yesterday()));
        eventList.forEach(
                event -> {
                    eventDate = event.getStartDate();
                    if (Objects.equals(dateFormat.format(eventDate), dateFormat.format(yesterday()))) {
                        participants.addAll(event.getParticipantList());
                        for (Participant p: participants) {
                            users.add(p.getUserParticipant());

                        }
                        sendEmails(users,event);
                    }

                }
        );


    }

    @Override
    public void userWhoHaventParticipatedInEvent() {
        users=userRepository.findAll();

        for (User u: users){
            participants= u.getParticipantList();
            Event lastEventParticipated;
            List<Event> events=new ArrayList<>();
            for (Participant p: participants) {
                events.add(p.getEvent());
            }
            if (events.size()!=0) {
                Collections.sort(events);
                lastEventParticipated = events.get(events.size() - 1);
                try {
                    latestEventDateF= dateFormat.format(eventRepository.getEventsByLastStartDate().getStartDate());
                    userLatestEventDateF=dateFormat.format(lastEventParticipated.getStartDate());
                    Date startDate=lastEventParticipated.getStartDate();
                    Date lastEvDate= eventRepository.getEventsByLastStartDate().getStartDate();
                    LocalDate date1 =LocalDate.parse(latestEventDateF,dtf);
                    LocalDate date2 =LocalDate.parse(userLatestEventDateF,dtf);
                    long daysBetween = ChronoUnit.DAYS.between(date2, date1);
                    if (daysBetween> 30 && eventRepository.getCountEventsBetweenTwoDate(startDate,lastEvDate)>0){
                        log.info("Sending email to user: "+u.getIdUser());
                        sendEmailToUser(u);
                    }

                }catch (Exception exception){
                    log.info(exception.getMessage());
                }


            }

        }
    }

    private void sendEmails(List<User> users, Event event) {
        for (User user : users) {
            SimpleMailMessage message = new SimpleMailMessage();
            log.info("Sending email to: " + user.getEmail());
            message.setTo(user.getEmail());
            message.setSubject("Event reminder");
            message.setText("Hi " + user.getFirstName() + ",\n" +
                    "\n" +
                    "This is a reminder for tomorrow's event: " + event.getEventName() + "\n" +
                    "wich will take place at " + event.getLocation() + ".\n" +
                    "Enjoy it !\n" +
                    "\n" +
                    "Regards,");
            this.emailSender.send(message);
        }
    }

        private void sendEmailToUser(User user) {

                SimpleMailMessage message = new SimpleMailMessage();
                log.info("Sending email to: "+user.getEmail());
                message.setTo(user.getEmail());
                message.setSubject("Events survey");
                message.setText("Hi "+user.getFirstName()+ ",\n" +
                        "\n" +
                        "We noticed that you haven't participated in an event a while now.\n" +
                        "We are sending you this email to check if you have any work related" +
                        "issue preventing you from participating\n" +
                        "\n" +
                        "If you would like to update your favourite categories, use this link: \n" +
                        "http://localhost:8081/WellBeingWork/FavCat/addFavCat\n" +
                        "\n"+
                        "Please note that this email is to help us improve our events and colleagues well being.\n" +
                        "\n" +
                        "Regards,");
                this.emailSender.send(message);
            }


    }


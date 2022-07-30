package tn.esprit.wellbeingwork.repository;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.wellbeingwork.entity.Event;

import java.util.Date;

/**
 * @author amoujbani on 7/19/2022
 * @project WellBeingWork
 */
@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    @Query(value = "select * from Event order by start_date DESC LIMIT 1"
    , nativeQuery = true)
    Event getEventsByLastStartDate();

    @Query(value = "SELECT count(*) from event where start_date BETWEEN :firstDate and :secondDate"
    , nativeQuery = true)
    int getCountEventsBetweenTwoDate(@Param("firstDate") @JsonFormat(pattern = "dd/MM/yyyy") Date firstDate, @Param("secondDate") @JsonFormat(pattern = "dd/MM/yyyy") Date secondDate);
}

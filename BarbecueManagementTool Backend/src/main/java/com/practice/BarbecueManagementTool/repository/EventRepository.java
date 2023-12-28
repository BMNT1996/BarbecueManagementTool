package com.practice.BarbecueManagementTool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.practice.BarbecueManagementTool.models.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {
	List<Event> findAll();

	@Query(value = "SELECT * FROM events e WHERE e.event_id = ?1 ", nativeQuery = true)
	Event findEventById(Integer id);

	@Query(value = "SELECT * FROM events e WHERE e.event_code = ?1 ", nativeQuery = true)
	List<Event> findEventByCode(String code);

	@Modifying
	@Query(value = "DELETE FROM events e WHERE e.event_id = :#{#event.eventId}", nativeQuery = true)
	@Transactional
	void deleteEvent(Event event);

	@Modifying
	@Query(value = "INSERT INTO event_user_ownership VALUES(?1,?2)", nativeQuery = true)
	@Transactional
	void addEventUserOwnership(Integer eventId, Integer userId);

	@Modifying
	@Query(value = "UPDATE events SET name=:#{#event.name}, event_code=:#{#event.eventCode}, date=:#{#event.date} where event_id = :#{#event.eventId}", nativeQuery = true)
	@Transactional
	void updateEvent(@Param("event") Event event);

}
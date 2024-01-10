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
	Event findEventByCode(String code);

	@Query(value = "SELECT eeuj.event_id, eeuj.name, eeuj.date, eeuj.event_code, eeuj.user_id, u.username, eeuj.accepted FROM (SELECT e.event_id, e.date, e.event_code, e.name, euj.accepted, euj.user_id FROM events e INNER JOIN event_user_junction euj ON e.event_id=euj.event_id) eeuj INNER JOIN users u ON eeuj.user_id=u.user_id WHERE u.username=?1 ", nativeQuery = true)
	List<Object> getEventsByUsername(String username);

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
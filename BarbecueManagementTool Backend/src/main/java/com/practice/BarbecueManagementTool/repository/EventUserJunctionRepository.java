package com.practice.BarbecueManagementTool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.practice.BarbecueManagementTool.models.EventUserJunction;
import com.practice.BarbecueManagementTool.models.EventUserJunctionId;

/**
 * Repository for Event/User junction
 * 
 * @author Bruno Teles
 * @version 0.1
 * @since 2024-01-12
 */
@Repository
public interface EventUserJunctionRepository extends JpaRepository<EventUserJunction, EventUserJunctionId> {

	@Query(value = "SELECT * FROM event_user_junction euj WHERE euj.event_id = ?1 AND euj.user_id = ?2", nativeQuery = true)
	List<EventUserJunction> getEventUserJunctionByEventIdAndUserId(Integer eventId, Integer userId);

	@Modifying
	@Query(value = "INSERT INTO event_user_junction VALUES(?3,?1,?4,?2)", nativeQuery = true)
	@Transactional
	void addEventUserJunction(Integer eventId, Integer userId, Boolean accepted, Boolean isOwnwer);

	@Modifying
	@Query(value = "UPDATE event_user_junction SET accepted = :#{#accepted} WHERE event_id = :#{#eventId} AND user_id = :#{#userId}", nativeQuery = true)
	@Transactional
	void updateEventUserJunction(@Param("eventId") Integer eventId, @Param("userId") Integer userId,
			@Param("accepted") Boolean accepted);

	@Modifying
	@Query(value = "DELETE FROM event_user_junction euj WHERE euj.event_id = :#{#eventId} AND euj.user_id = :#{#userId}", nativeQuery = true)
	@Transactional
	void deleteEventUserJunctionByEventIdAndUserId(@Param("eventId") Integer eventId, @Param("userId") Integer userId);

	@Modifying
	@Query(value = "DELETE FROM event_user_junction euj WHERE euj.event_id = :#{#id}", nativeQuery = true)
	@Transactional
	void deleteEventUserJunctionByEventId(Integer id);
	
	@Query(value = "SELECT * FROM event_user_junction euj WHERE euj.event_id = ?1", nativeQuery = true)
	List<EventUserJunction> getEventUserJunctionByEventId(Integer eventId);
}

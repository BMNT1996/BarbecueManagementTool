package com.practice.BarbecueManagementTool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.practice.BarbecueManagementTool.models.DivisionType;
import com.practice.BarbecueManagementTool.models.EventProductJunction;
import com.practice.BarbecueManagementTool.models.EventProductJunctionId;

public interface EventProductJunctionRepository extends JpaRepository<EventProductJunction, EventProductJunctionId> {

	@Query(value = "SELECT * FROM event_product_junction epj WHERE epj.event_id = ?1 AND epj.product_id = ?2", nativeQuery = true)
	List<EventProductJunction> getEventProductJunctionByEventIdAndUserId(Integer eventId, Integer productId);

	@Modifying
	@Query(value = "INSERT INTO event_product_junction VALUES(?5,?1,?4,?2,?3)", nativeQuery = true)
	@Transactional
	void addEventProductJunction(Integer eventId, Integer productId, Double quantity, Double price,
			DivisionType divisionType);

	@Modifying
	@Query(value = "UPDATE event_product_junction SET quantity = :#{#quantity}, price = :#{#price}, division_type = :#{#divisionType} WHERE event_id = :#{#eventId} AND product_id = :#{#productId}", nativeQuery = true)
	@Transactional
	void updateEventProductJunction(@Param("eventId") Integer eventId, @Param("productId") Integer productId,
			@Param("quantity") Double quantity, @Param("price") Double price,
			@Param("divisionType") DivisionType divisionType);

	@Modifying
	@Query(value = "DELETE FROM event_product_junction WHERE event_id = :#{#eventId} AND product_id = :#{#productId}", nativeQuery = true)
	@Transactional
	void deleteEventProductJunctionByEventIdAndUserId(@Param("eventId") Integer eventId, @Param("productId") Integer productId);

	@Query(value = "SELECT * FROM event_product_junction epj WHERE epj.event_id = ?1", nativeQuery = true)
	List<EventProductJunction> getEventProductJunctionByEvent(Integer eventId);

}

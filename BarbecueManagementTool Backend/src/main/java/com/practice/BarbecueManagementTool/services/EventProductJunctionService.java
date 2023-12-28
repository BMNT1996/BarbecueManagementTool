package com.practice.BarbecueManagementTool.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.BarbecueManagementTool.models.EventProductJunction;
import com.practice.BarbecueManagementTool.models.EventProductJunctionId;
import com.practice.BarbecueManagementTool.models.request.AddEventProductServiceRequest;
import com.practice.BarbecueManagementTool.models.request.DeleteEventProductServiceRequest;
import com.practice.BarbecueManagementTool.models.request.UpdateEventProductServiceRequest;
import com.practice.BarbecueManagementTool.models.response.AddEventProductServiceResponse;
import com.practice.BarbecueManagementTool.models.response.DeleteEventProductServiceResponse;
import com.practice.BarbecueManagementTool.models.response.UpdateEventProductServiceResponse;
import com.practice.BarbecueManagementTool.repository.EventProductJunctionRepository;

@Service
public class EventProductJunctionService {

	@Autowired
	private EventProductJunctionRepository eventProductJunctionRepository;

	public AddEventProductServiceResponse AddEventProduct(AddEventProductServiceRequest request) {
		try {
			eventProductJunctionRepository.addEventProductJunction(request.getEvent().getEventId(),
					request.getProduct().getProductId(), request.getQuantity(), request.getPrice(),
					request.getDivisionType());
			List<EventProductJunction> dbProductsJunction = eventProductJunctionRepository
					.getEventProductJunctionByEventIdAndUserId(request.getEvent().getEventId(),
							request.getProduct().getProductId());
			return new AddEventProductServiceResponse(dbProductsJunction.isEmpty() ? null : dbProductsJunction.get(0));
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public UpdateEventProductServiceResponse UpdateEventProduct(UpdateEventProductServiceRequest request) {
		try {
			EventProductJunctionId eventProductId = request.getEventProductJunction().getEventProductJunctionId();
			eventProductJunctionRepository.updateEventProductJunction(eventProductId.getEvent().getEventId(),
					eventProductId.getProduct().getProductId(), request.getEventProductJunction().getQuantity(),
					request.getEventProductJunction().getPrice(), request.getEventProductJunction().getDivisionType());
			List<EventProductJunction> dbEventProduct = eventProductJunctionRepository
					.getEventProductJunctionByEventIdAndUserId(eventProductId.getEvent().getEventId(),
							eventProductId.getProduct().getProductId());
			return new UpdateEventProductServiceResponse(dbEventProduct.isEmpty() ? null : dbEventProduct.get(0));
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public DeleteEventProductServiceResponse DeleteEventProduct(DeleteEventProductServiceRequest request) {
		try {
			EventProductJunctionId eventProduct = request.getEventProductJunction().getEventProductJunctionId();
			eventProductJunctionRepository.deleteEventProductJunctionByEventIdAndUserId(
					eventProduct.getEvent().getEventId(), eventProduct.getProduct().getProductId());
			return new DeleteEventProductServiceResponse(request.getEventProductJunction());
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}

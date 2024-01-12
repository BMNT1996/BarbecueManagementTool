package com.practice.BarbecueManagementTool.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.BarbecueManagementTool.models.EventUserJunction;
import com.practice.BarbecueManagementTool.models.EventUserJunctionId;
import com.practice.BarbecueManagementTool.models.request.AddParticipantServiceRequest;
import com.practice.BarbecueManagementTool.models.request.DeleteParticipantServiceRequest;
import com.practice.BarbecueManagementTool.models.request.UpdateParticipantServiceRequest;
import com.practice.BarbecueManagementTool.models.response.AddParticipantServiceResponse;
import com.practice.BarbecueManagementTool.models.response.DeleteParticipantServiceResponse;
import com.practice.BarbecueManagementTool.models.response.UpdateParticipantServiceResponse;
import com.practice.BarbecueManagementTool.repository.EventUserJunctionRepository;

/**
 * Service class for Event/User junction
 * 
 * @author Bruno Teles
 * @version 0.1
 * @since 2024-01-12
 */
@Service
public class EventUserJunctionService {

	@Autowired
	private EventUserJunctionRepository eventUserJunctionRepository;

	public AddParticipantServiceResponse addParticipant(AddParticipantServiceRequest request) {
		try {
			eventUserJunctionRepository.addEventUserJunction(request.getEventId(),
					request.getUserId(), request.getAccepted(), false);
			List<EventUserJunction> dbParticipations = eventUserJunctionRepository
					.getEventUserJunctionByEventIdAndUserId(request.getEventId(),
							request.getUserId());
			return new AddParticipantServiceResponse(dbParticipations.isEmpty() ? null : dbParticipations.get(0));
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public UpdateParticipantServiceResponse updateParticipant(UpdateParticipantServiceRequest request) {
		try {
			eventUserJunctionRepository.updateEventUserJunction(
					request.getEventUserJunction().getEventUserJunctionId().getEvent().getEventId(),
					request.getEventUserJunction().getEventUserJunctionId().getUser().getUserId(),
					request.getEventUserJunction().getAccepted());
			EventUserJunctionId participationId = request.getEventUserJunction().getEventUserJunctionId();
			List<EventUserJunction> dbParticipations = eventUserJunctionRepository
					.getEventUserJunctionByEventIdAndUserId(participationId.getEvent().getEventId(),
							participationId.getUser().getUserId());
			return new UpdateParticipantServiceResponse(dbParticipations.isEmpty() ? null : dbParticipations.get(0));
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public DeleteParticipantServiceResponse deleteParticipant(DeleteParticipantServiceRequest request) {
		try {
			EventUserJunctionId participationId = request.getEventUserJunction().getEventUserJunctionId();
			eventUserJunctionRepository.deleteEventUserJunctionByEventIdAndUserId(
					participationId.getEvent().getEventId(), participationId.getUser().getUserId());
			return new DeleteParticipantServiceResponse(request.getEventUserJunction());
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}

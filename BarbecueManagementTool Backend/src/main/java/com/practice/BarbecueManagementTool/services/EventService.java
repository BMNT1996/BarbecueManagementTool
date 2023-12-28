package com.practice.BarbecueManagementTool.services;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.BarbecueManagementTool.models.Event;
import com.practice.BarbecueManagementTool.models.request.CreateEventServiceRequest;
import com.practice.BarbecueManagementTool.models.request.DeleteEventServiceRequest;
import com.practice.BarbecueManagementTool.models.request.UpdateEventServiceRequest;
import com.practice.BarbecueManagementTool.models.response.CreateEventServiceResponse;
import com.practice.BarbecueManagementTool.models.response.DeleteEventServiceResponse;
import com.practice.BarbecueManagementTool.models.response.GetAllEventsServiceResponse;
import com.practice.BarbecueManagementTool.models.response.UpdateEventServiceResponse;
import com.practice.BarbecueManagementTool.repository.EventRepository;
import com.practice.BarbecueManagementTool.repository.EventUserJunctionRepository;

@Service
public class EventService {

	@Autowired
	private EventRepository eventRepository;

	@Autowired
	private EventUserJunctionRepository eventUserJunctionRepository;

	public GetAllEventsServiceResponse GetAllEvents() {
		try {
			return new GetAllEventsServiceResponse(eventRepository.findAll());
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	public CreateEventServiceResponse CreateEvent(CreateEventServiceRequest request) {
		try {
			int nTry = 0;
			String code = "";
			while (nTry < 5) {
				code = RandomStringUtils.randomAlphanumeric(5);
				if (eventRepository.findEventByCode(code).isEmpty()) {
					break;
				} else {
					if (nTry == 4) {
						throw new Exception("Generate code has reach the maximum number of tries");
					}
				}
				nTry++;
			}
			Event newEvent = eventRepository.save(new Event(null, request.getName(), code, request.getDate()));
			eventUserJunctionRepository.addEventUserJunction(newEvent.getEventId(), request.getOwnerId(), true, true);
			return new CreateEventServiceResponse(newEvent);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public UpdateEventServiceResponse UpdateEvent(UpdateEventServiceRequest request) {
		try {
			eventRepository.updateEvent(request.getEvent());
			return new UpdateEventServiceResponse(request.getEvent());
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public DeleteEventServiceResponse DeleteEvent(DeleteEventServiceRequest request) {
		try {
			eventUserJunctionRepository.deleteEventUserJunctionByEventId(request.getEvent().getEventId());
			eventRepository.deleteEvent(request.getEvent());
			return new DeleteEventServiceResponse(request.getEvent());
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

}

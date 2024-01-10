package com.practice.BarbecueManagementTool.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.BarbecueManagementTool.models.Event;
import com.practice.BarbecueManagementTool.models.EventInformation;
import com.practice.BarbecueManagementTool.models.EventProductJunction;
import com.practice.BarbecueManagementTool.models.request.CreateEventServiceRequest;
import com.practice.BarbecueManagementTool.models.request.DeleteEventServiceRequest;
import com.practice.BarbecueManagementTool.models.request.GetDashboardInformationServiceRequest;
import com.practice.BarbecueManagementTool.models.request.GetEventByCodeServiceRequest;
import com.practice.BarbecueManagementTool.models.request.UpdateEventServiceRequest;
import com.practice.BarbecueManagementTool.models.response.CreateEventServiceResponse;
import com.practice.BarbecueManagementTool.models.response.DeleteEventServiceResponse;
import com.practice.BarbecueManagementTool.models.response.GetAllEventsServiceResponse;
import com.practice.BarbecueManagementTool.models.response.GetDashboardInformationServiceResponse;
import com.practice.BarbecueManagementTool.models.response.GetEventByCodeServiceResponse;
import com.practice.BarbecueManagementTool.models.response.UpdateEventServiceResponse;
import com.practice.BarbecueManagementTool.repository.EventProductJunctionRepository;
import com.practice.BarbecueManagementTool.repository.EventRepository;
import com.practice.BarbecueManagementTool.repository.EventUserJunctionRepository;

@Service
public class EventService {

	@Autowired
	private EventRepository eventRepository;

	@Autowired
	private EventUserJunctionRepository eventUserJunctionRepository;

	@Autowired
	private EventProductJunctionRepository eventProductJunctionRepository;

	public GetAllEventsServiceResponse getAllEvents() {
		try {
			return new GetAllEventsServiceResponse(eventRepository.findAll());
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	public CreateEventServiceResponse createEvent(CreateEventServiceRequest request) {
		try {
			int nTry = 0;
			String code = "";
			while (nTry < 5) {
				code = RandomStringUtils.randomAlphanumeric(5);
				System.out.println(eventRepository.findEventByCode(code));
				if (eventRepository.findEventByCode(code) == null) {
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

	public UpdateEventServiceResponse updateEvent(UpdateEventServiceRequest request) {
		try {
			eventRepository.updateEvent(request.getEvent());
			return new UpdateEventServiceResponse(request.getEvent());
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public DeleteEventServiceResponse deleteEvent(DeleteEventServiceRequest request) {
		try {
			eventUserJunctionRepository.deleteEventUserJunctionByEventId(request.getEvent().getEventId());
			eventRepository.deleteEvent(request.getEvent());
			return new DeleteEventServiceResponse(request.getEvent());
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public GetDashboardInformationServiceResponse getDashboardInformation(
			GetDashboardInformationServiceRequest request) {
		try {
			String username = request.getUsername();
			List<Object> events = eventRepository.getEventsByUsername(username);
			if (events.isEmpty())
				return new GetDashboardInformationServiceResponse();
			else {
				GetDashboardInformationServiceResponse response = new GetDashboardInformationServiceResponse();
				events.forEach(event -> {
					Object[] eventValues = (Object[]) event;
					for(Object o : eventValues) {
						System.out.println(o.toString());
					}
					if ((boolean) eventValues[6]) {
						response.setNumberOfEvents(response.getNumberOfEvents() + 1);
						List<EventProductJunction> products = eventProductJunctionRepository
								.getEventProductJunctionByEvent(Integer.parseInt(eventValues[0].toString()));
						Map<String, Double> eventExpenses = calculateProductExpensiveAndQuantity(products);
						response.addEvent(new EventInformation(Integer.parseInt(eventValues[0].toString()),
								eventValues[1].toString(), eventValues[2].toString(), eventValues[3].toString(), eventExpenses.get("Expenses"),
								"Unknow"));
						response.setTotalExpenses(response.getTotalExpenses() + eventExpenses.get("Expenses"));
						response.setProductsRequested(eventExpenses.get("Quantity"));
					} else {
						response.addEventPending(new EventInformation(Integer.parseInt(eventValues[0].toString()),
								eventValues[1].toString(), eventValues[2].toString(), eventValues[3].toString(), 0.0,
								"Unknow"));
					}
				});
				return response;
			}
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public GetEventByCodeServiceResponse GetEventByCode(GetEventByCodeServiceRequest request) {
		try {
			Event event = eventRepository.findEventByCode(request.getCode());
			return new GetEventByCodeServiceResponse(event);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	private Map<String, Double> calculateProductExpensiveAndQuantity(List<EventProductJunction> products) {
		Double totalExpenses = 0.0;
		Double totalQuantity = 0.0;
		Map<String, Double> response = new HashMap<String, Double>();
		for (EventProductJunction product : products) {
			totalExpenses += product.getPrice() * product.getQuantity();
			totalQuantity += product.getQuantity();
		}
		response.put("Expenses", totalExpenses);
		response.put("Quantity", totalQuantity);
		return response;
	}
}

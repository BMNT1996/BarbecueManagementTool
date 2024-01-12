package com.practice.BarbecueManagementTool.models.request;

/**
 * Request model for GetEventPeopleAndProductsByEvent Service
 * 
 * @author Bruno Teles
 * @version 0.1
 * @since 2024-01-12
 */
public class GetEventPeopleAndProductsByEventCodeServiceRequest {

	private String code;

	public GetEventPeopleAndProductsByEventCodeServiceRequest() {
		super();
	}

	public GetEventPeopleAndProductsByEventCodeServiceRequest(String code) {
		super();
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}

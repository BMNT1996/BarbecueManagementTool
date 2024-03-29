package com.practice.BarbecueManagementTool.models.request;

/**
 * Request model for GetEventByCode Service
 * 
 * @author Bruno Teles
 * @version 0.1
 * @since 2024-01-12
 */
public class GetEventByCodeServiceRequest {

	private String code;

	public GetEventByCodeServiceRequest() {
		super();
	}

	public GetEventByCodeServiceRequest(String code) {
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

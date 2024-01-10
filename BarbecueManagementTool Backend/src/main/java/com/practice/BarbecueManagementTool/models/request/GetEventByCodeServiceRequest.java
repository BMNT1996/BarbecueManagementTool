package com.practice.BarbecueManagementTool.models.request;

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

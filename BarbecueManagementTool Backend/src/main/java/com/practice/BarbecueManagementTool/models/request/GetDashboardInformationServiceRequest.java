package com.practice.BarbecueManagementTool.models.request;

public class GetDashboardInformationServiceRequest {

	private String username;

	public GetDashboardInformationServiceRequest() {
		super();
	}

	public GetDashboardInformationServiceRequest(String username) {
		super();
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}

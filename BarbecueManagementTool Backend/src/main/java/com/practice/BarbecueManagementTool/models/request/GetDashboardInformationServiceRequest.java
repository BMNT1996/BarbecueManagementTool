package com.practice.BarbecueManagementTool.models.request;

/**
 * Request model for GetDashboardInformation Service
 * 
 * @author Bruno Teles
 * @version 0.1
 * @since 2024-01-12
 */
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

package com.practice.BarbecueManagementTool.models;

public class EventInformation {
	private Integer id;
	private String name;
	private String date;
	private String code;
	private Double expenses;
	private String status;

	public EventInformation() {
		super();
	}

	public EventInformation(Integer id, String name, String date, String code, Double expenses, String status) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.code = code;
		this.expenses = expenses;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Double getExpenses() {
		return expenses;
	}

	public void setExpenses(Double expenses) {
		this.expenses = expenses;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

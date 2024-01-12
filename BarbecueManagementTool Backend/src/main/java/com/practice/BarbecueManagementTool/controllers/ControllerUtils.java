package com.practice.BarbecueManagementTool.controllers;

import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class ControllerUtils {
	
	/**
	 * Method to convert an object into a Json String
	 * 
	 * @param obj Object to be converted
	 * @return Object as a Json String
	 */
	public static String objectToJsonString(Object obj) {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		try {
			return objectMapper.registerModule(new JavaTimeModule()).writerWithDefaultPrettyPrinter()
			.writeValueAsString(obj).toString();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "";
		}
		
	}
}

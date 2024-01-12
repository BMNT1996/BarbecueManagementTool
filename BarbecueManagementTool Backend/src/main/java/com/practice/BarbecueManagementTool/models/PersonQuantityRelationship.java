package com.practice.BarbecueManagementTool.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Class with the person/quantity relationship (For future implementation)
 * 
 * @author Bruno Teles
 * @version 0.1
 * @since 2024-01-12
 */
@Entity
@Table(name = "person_quantity_relationship")
public class PersonQuantityRelationship {

	@EmbeddedId
	private PersonQuantityRelationshipId personQuantityRelationshipId;

	private Double quantity;

	/**
	 * Constructor without attributes
	 */
	public PersonQuantityRelationship() {
		super();
	}

	/**
	 * Constructor with attributes
	 * 
	 * @param personQuantityRelationshipId Id
	 * @param quantity Quantity requested
	 */
	public PersonQuantityRelationship(PersonQuantityRelationshipId personQuantityRelationshipId, Double quantity) {
		super();
		this.personQuantityRelationshipId = personQuantityRelationshipId;
		this.quantity = quantity;
	}

	public PersonQuantityRelationshipId getPersonQuantityRelationshipId() {
		return personQuantityRelationshipId;
	}

	public void setPersonQuantityRelationshipId(PersonQuantityRelationshipId personQuantityRelationshipId) {
		this.personQuantityRelationshipId = personQuantityRelationshipId;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

}

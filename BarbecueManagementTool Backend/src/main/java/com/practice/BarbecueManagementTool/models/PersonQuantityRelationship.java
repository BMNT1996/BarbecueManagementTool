package com.practice.BarbecueManagementTool.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "person_quantity_relationship")
public class PersonQuantityRelationship {

	@EmbeddedId
	private PersonQuantityRelationshipId personQuantityRelationshipId;

	private Double quantity;

	public PersonQuantityRelationship() {
		super();
	}

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

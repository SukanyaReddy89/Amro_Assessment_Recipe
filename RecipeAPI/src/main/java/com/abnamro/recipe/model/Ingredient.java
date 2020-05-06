package com.abnamro.recipe.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "INGREDIENTS")
@Entity
public class Ingredient {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	float quantityInGrams;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getQuantityInGrams() {
		return quantityInGrams;
	}
	public void setQuantityInGrams(float quantityInGrams) {
		this.quantityInGrams = quantityInGrams;
	}
}

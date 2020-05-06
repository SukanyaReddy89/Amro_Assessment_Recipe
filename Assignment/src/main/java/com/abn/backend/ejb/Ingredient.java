package com.abn.backend.ejb;

import java.io.Serializable;

public class Ingredient implements Serializable{
	
	private static final long serialVersionUID = -7923676181782236498L;
	
	String name;
	float quantityInGrams;
	
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

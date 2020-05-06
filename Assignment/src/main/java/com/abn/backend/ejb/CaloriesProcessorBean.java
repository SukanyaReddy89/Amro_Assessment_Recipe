package com.abn.backend.ejb;

import java.util.List;

import javax.ejb.Stateless;

@Stateless(name = "CaloriesProcessor")
public class CaloriesProcessorBean implements CaloriesProcessor{
	 
	  public float computeCalories(List<Ingredient> ingredients) {
	        return CalorieProcessorUtil.calculateTotalCalories(ingredients);
	    }
}

package com.abn.backend.ejb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalorieProcessorUtil {
	private static Map calorieMap;
	static {
		calorieMap = new HashMap<String,Float>();
		calorieMap.put("salt", new Float(10));
		calorieMap.put("pepper", new Float(20));
		calorieMap.put("rice", new Float(100));
		calorieMap.put("wheat", new Float(200));
		calorieMap.put("chips", new Float(500));
		calorieMap.put("potatoes", new Float(200));
		calorieMap.put("carrot", new Float(10));
	}

	/**
	 * @author sukann
	 * Static method that calculates Total number of calories depending upon the ingredients selected
	 * @param ingredients
	 * @return calculated number of calories
	 */
	public static float calculateTotalCalories(List<Ingredient> ingredients){
		float totalCalories = 0;
		float calPerGram = 0;
		for(Ingredient ingredient: ingredients){
			if(calorieMap.get(ingredient.getName()) != null){
				calPerGram = ((Float)calorieMap.get(ingredient.getName())).floatValue(); 
			}
			totalCalories = totalCalories + calPerGram*ingredient.getQuantityInGrams();
		}
		System.out.println("totalCalories==================="+totalCalories);
		return totalCalories;
	}
}

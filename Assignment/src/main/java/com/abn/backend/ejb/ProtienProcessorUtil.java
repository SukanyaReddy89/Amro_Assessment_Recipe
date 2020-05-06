package com.abn.backend.ejb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProtienProcessorUtil {
	private static Map protienMap;
	static {
		protienMap = new HashMap<String,Float>();
		protienMap.put("salt", new Float(10));
		protienMap.put("pepper", new Float(20));
		protienMap.put("rice", new Float(100));
		protienMap.put("wheat", new Float(200));
		protienMap.put("chips", new Float(500));
		protienMap.put("potatoes", new Float(200));
		protienMap.put("carrot", new Float(10));
	}
/**
 * Static method to calculate the total number of proteins from the ingredients received
 * @author sukann
 * @param ingredients
 * @return total proteins
 */
	public static float calculateTotalProtiens(List<Ingredient> ingredients){
		float totalProtiens = 0;
		float protienPerGram = 0;
		for(Ingredient ingredient: ingredients){
			if(protienMap.get(ingredient.getName()) != null){
				protienPerGram = ((Float)protienMap.get(ingredient.getName())).floatValue(); 
			}
			totalProtiens = totalProtiens + protienPerGram*ingredient.getQuantityInGrams();
		}
		System.out.println("totalProtiens==================="+totalProtiens);
		return totalProtiens;
	}
}

package com.abnamro.recipe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.abn.backend.ejb.CaloriesProcessor;
import com.abn.backend.ejb.ProtiensProcessor;
import com.abnamro.recipe.model.Ingredient;

@Component
public class RecipeServiceInvoker {
		
	private CaloriesProcessor caloriesProcessor;
	private ProtiensProcessor protiensProcessor;
	
	@Autowired
	public RecipeServiceInvoker(CaloriesProcessor caloriesProcessor, ProtiensProcessor protiensProcessor){
		this.caloriesProcessor = caloriesProcessor;
		this.protiensProcessor = protiensProcessor;
	}

	public float getCalorieCountForRecipe(List<Ingredient> ingredients) {
		
		return caloriesProcessor.computeCalories(getIngredientList(ingredients));
	}

	public float getProtienCountForRecipe(List<Ingredient> ingredients) {
		
		return protiensProcessor.computeProtiens(getIngredientList(ingredients));
	}
	
	private List<com.abn.backend.ejb.Ingredient> getIngredientList(List<Ingredient> ingredients){
		List<com.abn.backend.ejb.Ingredient> ingredientList = new ArrayList<com.abn.backend.ejb.Ingredient>();
		for (Ingredient ingred : ingredients) {
			com.abn.backend.ejb.Ingredient ingredient = new com.abn.backend.ejb.Ingredient();
			ingredient.setName(ingred.getName());
			ingredient.setQuantityInGrams(ingred.getQuantityInGrams());
			ingredientList.add(ingredient);
		}
		return ingredientList;
	}
}

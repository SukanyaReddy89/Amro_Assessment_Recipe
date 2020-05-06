package com.abnamro.recipe.repo;

import org.springframework.data.repository.CrudRepository;

import com.abnamro.recipe.model.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long>{

}

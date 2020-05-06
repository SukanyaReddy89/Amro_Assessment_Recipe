package com.abnamro.recipe.api;


import com.abnamro.recipe.model.Recipe;
import com.abnamro.recipe.repo.RecipeRepository;
import com.abnamro.recipe.service.RecipeServiceInvoker;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@javax.annotation.Generated(value = "com.abnamro.recipe.codegen.languages.SpringCodegen", date = "2020-05-03T11:05:49.409Z")

@Controller

/*
 * 
 * Class that performs all CRUD operations
 */
public class RecipeApiController implements RecipeApi {

    private static final Logger log = LoggerFactory.getLogger(RecipeApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    private RecipeServiceInvoker recipeServiceInvoker;
    
    
    RecipeRepository repository;

    @org.springframework.beans.factory.annotation.Autowired
    public RecipeApiController(ObjectMapper objectMapper, HttpServletRequest request, RecipeServiceInvoker recipeServiceInvoker,
    							RecipeRepository repository) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.recipeServiceInvoker = recipeServiceInvoker;
        this.repository = repository;
    }
	/**
	 * Method to add new Recipe
	 */
    public ResponseEntity<Void> addRecipe(@ApiParam(value = "recipe to be added" ,required=true )  @Valid @RequestBody Recipe recipe) {
    	recipe.setCalories(recipeServiceInvoker.getCalorieCountForRecipe(recipe.getIngredients()));
    	recipe.setProtiens(recipeServiceInvoker.getProtienCountForRecipe(recipe.getIngredients()));
    	repository.save(recipe);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    
    /**
     * Method to add delete a Recipe
     */
    
    public ResponseEntity<Void> deleteRecipe(@ApiParam(value = "recipe id to delete",required=true) @PathVariable("recipeId") long recipeId) {
    	repository.deleteById(recipeId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    /**
     * Method to get a Recipe list
     */
    public ResponseEntity<List<Recipe>> getAllRecipes() {
    	 final List<Recipe> recipes = new ArrayList<>();
         repository.findAll().forEach(recipe -> recipes.add(recipe));
      	 return new ResponseEntity<List<Recipe>>(recipes, HttpStatus.OK);
    }

    /**
     * Method to get a Recipe by recipeId
     */

    public ResponseEntity<Recipe> getRecipeById(@ApiParam(value = "ID of recipe to return",required=true) @PathVariable("recipeId") long recipeId) {
    	  Optional<Recipe> recipe = repository.findById(new Long(recipeId));
    	  if(recipe.isPresent()){
    		  return new ResponseEntity<Recipe>(recipe.get(), HttpStatus.OK);
    	  }
    	  else{
    		  return new ResponseEntity<Recipe>(HttpStatus.NOT_FOUND);
    	  }	  
    }

    /**
     * Method to update a Recipe by recipeId
     */

    public ResponseEntity<Void> updateRecipe(@ApiParam(value = "",required=true) @PathVariable("recipeId") long recipeId,@ApiParam(value = "recipe to be updated" ,required=true )  @Valid @RequestBody Recipe recipe) {
    	recipe.setCalories(recipeServiceInvoker.getCalorieCountForRecipe(recipe.getIngredients()));
    	recipe.setProtiens(recipeServiceInvoker.getProtienCountForRecipe(recipe.getIngredients()));
    	repository.save(recipe);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}

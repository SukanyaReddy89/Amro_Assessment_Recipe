package com.abnamro.recipe.api;

import io.swagger.annotations.*;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.abnamro.recipe.model.Recipe;

import java.util.List;

import javax.validation.Valid;
@javax.annotation.Generated(value = "com.abnamro.recipe.codegen.languages.SpringCodegen", date = "2020-05-03T11:05:49.409Z")

@Api(value = "recipe", description = "the recipe API")
@RequestMapping(value = "/recipemanager")
public interface RecipeApi {

    @ApiOperation(value = "Add a new recipe", nickname = "addRecipe", notes = "Add a new recipe", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid input") })
    @RequestMapping(value = "/recipe",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
     ResponseEntity<Void> addRecipe(@ApiParam(value = "recipe to be added" ,required=true )  @Valid @RequestBody Recipe body);     


    @ApiOperation(value = "Deletes a recipe", nickname = "deleteRecipe", notes = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "recipe not found") })
    @RequestMapping(value = "/recipe/{recipeId}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteRecipe(@ApiParam(value = "recipe id to delete",required=true) @PathVariable("recipeId") long recipeId);
    


    @ApiOperation(value = "List all recipes", nickname = "getAllRecipes", notes = "Returns all  recipes", response = List.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = List.class),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Recipe not found") })
    @RequestMapping(value = "/recipe",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Recipe>> getAllRecipes(); 


    @ApiOperation(value = "Find recipe by ID", nickname = "getRecipeById", notes = "Returns a single recipe", response = Recipe.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Recipe.class),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Recipe not found") })
    @RequestMapping(value = "/recipe/{recipeId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Recipe> getRecipeById(@ApiParam(value = "ID of recipe to return",required=true) @PathVariable("recipeId") long recipeId);


    @ApiOperation(value = "Update an existing recipe", nickname = "updateRecipe", notes = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "Recipe not found") })
    @RequestMapping(value = "/recipe/{recipeId}",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateRecipe(@ApiParam(value = "",required=true) @PathVariable("recipeId") long recipeId,@ApiParam(value = "recipe to be updated" ,required=true )  @Valid @RequestBody Recipe body);

}

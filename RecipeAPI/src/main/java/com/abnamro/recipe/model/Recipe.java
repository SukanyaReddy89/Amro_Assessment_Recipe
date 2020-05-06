package com.abnamro.recipe.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * Recipe
 */
@Validated

@Table(name = "Recipe")
@Entity
public class Recipe   {
  @JsonProperty("id")
  @Id
  @GeneratedValue
  private long id;
  
  @JsonProperty("name")
  private String name = null;

  

@JsonProperty("creationTime")
  private String creationTime = null;

  @JsonProperty("lastUpdated")
  private String lastUpdated = null;

  @JsonProperty("vegetarian")
  private Boolean vegetarian = true;

  @JsonProperty("numberOfPeopleItServes")
  private Long numberOfPeopleItServes = null;

  @JsonProperty("ingredients")
  @Valid
  @OneToMany( targetEntity=Ingredient.class, cascade=CascadeType.ALL)
  private List<Ingredient> ingredients = null;

  @JsonProperty("instructions")
  private String instructions = null;

  @JsonProperty("calories")
  private float calories;

  @JsonProperty("protiens")
  private float protiens;

  public Recipe id(long id) {
    this.id = id;
    return this;
  }

  
  @ApiModelProperty(value = "")
  public String getName() {
   return name;
  }

   public void setName(String name) {
	 this.name = name;
   }
	  
  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")


  public long getId() {
    return id;
  }

  public void setId(long id) {
	  this.id = id;
  }

  public Recipe creationTime(String creationTime) {
    this.creationTime = creationTime;
    return this;
  }

  /**
   * Get creationTime
   * @return creationTime
  **/
  @ApiModelProperty(value = "")

  @Valid

  public String getCreationTime() {
    return creationTime;
  }

  public void setCreationTime(String creationTime) {
    this.creationTime = creationTime;
  }

  public Recipe lastUpdated(String lastUpdated) {
    this.lastUpdated = lastUpdated;
    return this;
  }

  /**
   * Get lastUpdated
   * @return lastUpdated
  **/
  @ApiModelProperty(value = "")

  @Valid

  public String getLastUpdated() {
    return lastUpdated;
  }

  public void setLastUpdated(String lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

  public Recipe vegetarian(Boolean vegetarian) {
    this.vegetarian = vegetarian;
    return this;
  }

  /**
   * Get vegetarian
   * @return vegetarian
  **/
  @ApiModelProperty(value = "")


  public Boolean isVegetarian() {
    return vegetarian;
  }

  public void setVegetarian(Boolean vegetarian) {
    this.vegetarian = vegetarian;
  }

  public Recipe numberOfPeopleItServes(Long numberOfPeopleItServes) {
    this.numberOfPeopleItServes = numberOfPeopleItServes;
    return this;
  }

  /**
   * Get numberOfPeopleItServes
   * @return numberOfPeopleItServes
  **/
  @ApiModelProperty(value = "")


  public Long getNumberOfPeopleItServes() {
    return numberOfPeopleItServes;
  }

  public void setNumberOfPeopleItServes(Long numberOfPeopleItServes) {
    this.numberOfPeopleItServes = numberOfPeopleItServes;
  }

  public Recipe ingredients(List<Ingredient> ingredients) {
    this.ingredients = ingredients;
    return this;
  }

  public Recipe addIngredientsItem(Ingredient ingredientsItem) {
    if (this.ingredients == null) {
      this.ingredients = new ArrayList<Ingredient>();
    }
    this.ingredients.add(ingredientsItem);
    return this;
  }

  /**
   * Get ingredients
   * @return ingredients
  **/
  @ApiModelProperty(value = "")


  public List<Ingredient> getIngredients() {
    return ingredients;
  }

  public void setIngredients(List<Ingredient> ingredients) {
    this.ingredients = ingredients;
  }

  public Recipe instructions(String instructions) {
    this.instructions = instructions;
    return this;
  }

  /**
   * Get instructions
   * @return instructions
  **/
  @ApiModelProperty(value = "")


  public String getInstructions() {
    return instructions;
  }

  public void setInstructions(String instructions) {
    this.instructions = instructions;
  }

  public Recipe calories(float calories) {
    this.calories = calories;
    return this;
  }

 
  @ApiModelProperty(value = "")


  public float getCalories() {
    return calories;
  }

  public void setCalories(float calories) {
    this.calories = calories;
  }

  public Recipe protiens(float protiens) {
    this.protiens = protiens;
    return this;
  }

 
  @ApiModelProperty(value = "")


  public float getProtiens() {
    return protiens;
  }

  public void setProtiens(float protiens) {
    this.protiens = protiens;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Recipe recipe = (Recipe) o;
    return Objects.equals(this.id, recipe.id) &&
        Objects.equals(this.creationTime, recipe.creationTime) &&
        Objects.equals(this.lastUpdated, recipe.lastUpdated) &&
        Objects.equals(this.vegetarian, recipe.vegetarian) &&
        Objects.equals(this.numberOfPeopleItServes, recipe.numberOfPeopleItServes) &&
        Objects.equals(this.ingredients, recipe.ingredients) &&
        Objects.equals(this.instructions, recipe.instructions) &&
        Objects.equals(this.calories, recipe.calories) &&
        Objects.equals(this.protiens, recipe.protiens);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, creationTime, lastUpdated, vegetarian, numberOfPeopleItServes, ingredients, instructions, calories, protiens);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Recipe {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    creationTime: ").append(toIndentedString(creationTime)).append("\n");
    sb.append("    lastUpdated: ").append(toIndentedString(lastUpdated)).append("\n");
    sb.append("    vegetarian: ").append(toIndentedString(vegetarian)).append("\n");
    sb.append("    numberOfPeopleItServes: ").append(toIndentedString(numberOfPeopleItServes)).append("\n");
    sb.append("    ingredients: ").append(toIndentedString(ingredients)).append("\n");
    sb.append("    instructions: ").append(toIndentedString(instructions)).append("\n");
    sb.append("    calories: ").append(toIndentedString(calories)).append("\n");
    sb.append("    protiens: ").append(toIndentedString(protiens)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}


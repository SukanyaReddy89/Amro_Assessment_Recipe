# Amro_Assessment_Recipe

#### An application to show all recipes and the actions to create, Read(retrieve), update and delete a recipe

#### Allows users to create their own recipes, mention their ingredients, calculate amount of calories and proteins of that desired recipe.

# Architecture

    The application has a 3-layer architecture
    
  ## Web-layer
     
       Rest APIs are implemented using Spring Boot. Here the resource is Recipe and all CRUD end points are defined and implemented here.
    
     # URL to test the application on postman 

       http://localhost:8080/recipemanager/recipe
       1. Create:
       
       POST is used to insert data.
       
       For example: 
       
       POST : http://localhost:8080/recipemanager/recipe

Headers:

Accept:application/json

Content-Type:application/json

Body:

{
        "name": "Recipe-1",
        
        "creationTime": "05-05-2020",
        
        "lastUpdated": "05-05-2020",
        
        "vegetarian": true,
        
        "numberOfPeopleItServes": 30,
        
        "ingredients": [
        
            {
            
                "name": "carrot",
                
                "quantityInGrams": 1000
                
            },
            
            {
            
                "name": "chips",
                
                "quantityInGrams": 2000
                
            }
            
        ],
        
        "instructions": "Boil all and serve"
        
    }
    
     Result : 200 ok if successful  
     
              400 bad request;if not created
              
   2. READ
   
   GET method is used to read all the recipes availble.
   
   There are two ways to get:
   
   1. User can fetch only desired recipe by mentioning only the recipe ID
   
   2. User can fetch all recipes available.
   
   GET :     http://localhost:8080/recipemanager/recipe/4
   
   GET(ALL): http://localhost:8080/recipemanager/recipe
   
   Result:
   
   404 not found; 200ok if recipe(s) found.

   3. UPDATE
   
   Update method is used to update a particular recipe
   
   PUT: PUT method is used to update an existing recipe.
   
   PUT: http://localhost:8080/recipemanager/recipe/1
   
   For example:
   
   BODY:
   
    {
    
        "name": "Recipe-1",
        
        "creationTime": "05-05-2020",
        
        "lastUpdated": "05-05-2020",
        
        "vegetarian": true,
        
        "numberOfPeopleItServes": 10,
        
        "ingredients": [
        
            {
                "name": "potatoes",
                "quantityInGrams": 1000
            },
            {
                "name": "carrot",
                "quantityInGrams": 2000
            }
        ],
        "instructions": "Do this, Do that"
    }
    
    Result: 404 if id is not there ; 200 ok
  4. DELETE
  
  Delete method is used to delete an existing recipe.
  
  For example:
  DELETE: http://localhost:8080/recipemanager/recipe/1
  Reslt: 404 if id is not there; 200 ok
  
  This tries to delete a recipe with recipeId 1.
  
  ## Database layer
  
   Have used H2 database with JPA.
   
   H2 database is an embedded database. It is fast, light weight and open source. All data present in H2 database is lost once the application server is restarted. Since it is a small application, i have chosen H2 database.
   
   ## Service Layer
   
      In this layer, EJB 3 session beans are used. Used Remote and stateless session beans.
      It contains all the POJO classes and Util classes to return some results.
      
 # API Documentation
 
 http://localhost:8080/swagger-ui.html  - refer this link for all api documentation.
 
 ## Running the Application
 
 1. Service Layer -- mvn commands
 
 # to start the server: 
    cd C:\Users\sukann\Assignment  (project folder location)
    mvn clean install 
    mvn clean package cargo:run -Pwildfly-standalone

# in another cmd console, to deploy the EJBs

   cd C:\Users\sukann\Assignment
   mvn wildfly:deploy -Pwildfly-runtime

#in another cmd console, to run REST api

   cd C:\Users\sukann\RecipeAPI
   mvn clean install
   mvn spring-boot:run  
   
# Unit testcases
  refer mail(excel sheet) for manual testcase scenarios

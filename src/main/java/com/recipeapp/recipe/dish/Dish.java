package com.recipeapp.recipe.dish;

import javax.validation.constraints.Size;

public class Dish {
    
    private Integer dishid ;
    @Size(min = 5)
    private String description ;
    @Size(min = 5)
    private Integer preparation_time ;
    @Size(min = 2)
    private String ingredients ; 
    @Size(min = 2)
    private String instructions ;

  

    public Dish() {
    }



    public Integer getDishid() {
        return dishid;
    }



    @Override
    public String toString() {
        return "Dish [description=" + description + ", dishid=" + dishid + ", ingredients=" + ingredients
                + ", instructions=" + instructions + ", preparation_time=" + preparation_time + "]";
    }



    public void setDishid(Integer dishid) {
        this.dishid = dishid;
    }



    public String getDescription() {
        return description;
    }



    public void setDescription(String description) {
        this.description = description;
    }



    public Integer getPreparation_time() {
        return preparation_time;
    }



    public void setPreparation_time(Integer preparation_time) {
        this.preparation_time = preparation_time;
    }



    public String getIngredients() {
        return ingredients;
    }



    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }



    public String getInstructions() {
        return instructions;
    }



    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }



    public Dish(Integer dishid, String description, Integer preparation_time, String ingredients, String instructions) {
        this.dishid = dishid;
        this.description = description;
        this.preparation_time = preparation_time;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }



    public Dish(String format) {
    }

 


}

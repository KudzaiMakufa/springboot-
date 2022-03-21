package com.recipeapp.recipe.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Size(min = 5)
    private String Description;
    @Size(min = 5)
    private Integer preparation_time ;
    @Size(min = 2)
    private String ingredients;
    @Size(min = 2)
    private String instructions ;

  

    public Dish() {
    }



    public Integer getId() {
        return id;
    }



    @Override
    public String toString() {
        return "Dish [description=" + Description + ", dishid=" + id + ", ingredients=" + ingredients
                + ", instructions=" + instructions + ", preparation_time=" + preparation_time + "]";
    }



    public void setId(Integer dishid) {
        this.id = dishid;
    }



    public String getDescription() {
        return Description;
    }



    public void setDescription(String description) {
        this.Description = description;
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



    public Dish(Integer id, String description, Integer preparation_time, String ingredients, String instructions) {
        this.id = id;
        this.Description = description;
        this.preparation_time = preparation_time;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }



    public Dish(String format) {
    }




}

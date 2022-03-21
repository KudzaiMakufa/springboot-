package com.recipeapp.recipe.repository;

import com.recipeapp.recipe.models.Dish;
import org.springframework.data.repository.CrudRepository;

public interface DishRepository extends CrudRepository<Dish, Integer> {

//    Iterable<Dish> findDishByDescriptionContains(String description);

}



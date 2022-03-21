package com.recipeapp.recipe.services;

import com.recipeapp.recipe.models.Dish;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.Optional;

public interface DishService {

    Optional<Dish> GetOneDish(@PathVariable int id) ;
    ResponseEntity<Object> saveDish(@Valid @RequestBody Dish dish) ;
    void deleteResource(@PathVariable int id) ;
    Iterable<Dish> getAllResources() ;
}

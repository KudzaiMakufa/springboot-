package com.recipeapp.recipe.endpoint;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import com.recipeapp.recipe.models.Dish;
import com.recipeapp.recipe.repository.DishRepository;

import com.recipeapp.recipe.services.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class RecipeEndpoint {


    private final DishService dishService;


    @Autowired
    public RecipeEndpoint(DishService dishService) {
        this.dishService = dishService;

    }


    @GetMapping(path="/dishes")
    public @ResponseBody
    Iterable<Dish> getAllResources() {
        return dishService.getAllResources() ;
    }

    @GetMapping("/dishes/{id}")
    public Optional<Dish> getOneResource(@PathVariable int id){
         return dishService.GetOneDish(id) ;
    }

    @PostMapping("/dishes")
    public ResponseEntity<Object> saveResource(@Valid @RequestBody Dish dish){

        return dishService.saveDish(dish) ;

    }

    @DeleteMapping("/dishes/{id}")
    public void deleteResource(@PathVariable int id){
        dishService.deleteResource(id);

    }

    
}
  
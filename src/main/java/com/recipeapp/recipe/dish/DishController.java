package com.recipeapp.recipe.dish;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import com.recipeapp.recipe.exceptions.UserNotFoundException;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class DishController {
    @Autowired
    private DishRepository dishrepository ;

    @GetMapping("/dishes")
    public List<Dish> GetAllDishes(){
        return  dishrepository.findAll() ; 
    }

    @GetMapping("/dishes/{id}")
    public Dish GetOneDish(@PathVariable int id){
        Dish dish  = dishrepository.findOne(id); 
        System.out.println(dish);
        if(dish == null){
            throw new UserNotFoundException("id "+id) ; 
        }
        return  dishrepository.findOne(id) ; 
    }

    @PostMapping("/dishes")
    public ResponseEntity<Object> saveDish(@Valid @RequestBody Dish dish){

        Dish dishsaved  =  dishrepository.save(dish) ; 

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{dishid}").build(dishsaved.getDishid()) ; 
        return  ResponseEntity.created(location).build() ; 
    }

    @DeleteMapping("/dishes/{id}")
    public Dish deleteDish(@PathVariable int id){
       Dish dish = dishrepository.deleteById(id) ; 
       if(dish == null){
        throw new UserNotFoundException("id "+id) ; 
       }
       return dish ; 
   
    }

}
  
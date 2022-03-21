package com.recipeapp.recipe.services;

import com.recipeapp.recipe.exceptions.ResourceNotFoundException;
import com.recipeapp.recipe.models.Dish;
import com.recipeapp.recipe.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Service
public class DishServiceImpl implements DishService {
    @Autowired
    private DishRepository dishrepository;

    @Override
    public Optional<Dish> GetOneDish(int id) {

        Optional<Dish> dish  = dishrepository.findById(id);
        System.out.println(dish);

        if(dish == null){
            throw new ResourceNotFoundException("id "+id) ;
        }
        return  dishrepository.findById(id) ;

    }

    @Override
    public ResponseEntity<Object> saveDish(Dish dish) {
        Dish dishsaved  =  dishrepository.save(dish) ;

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{dishid}").build(dishsaved.getId()) ;
        return  ResponseEntity.created(location).build() ;
    }

    @Override
    public void deleteResource(int id) {
        dishrepository.deleteById(id);
    }

    @Override
    public Iterable<Dish> getAllResources() {
        return dishrepository.findAll();
    }
}

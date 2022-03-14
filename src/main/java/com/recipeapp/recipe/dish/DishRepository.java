
package com.recipeapp.recipe.dish;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DishRepository {

    private static List<Dish> dishes  = new ArrayList<>() ; 
    private static Integer Dishcount = 3 ;
    static {
        dishes.add(new Dish(1, "Muboora with dovi", 30, "{dovi,salt,soda}", "mix")) ; 
        dishes.add(new Dish(2, "Nhopi", 30, "{Nhanga,salt,soda}", "mix")) ; 
        dishes.add(new Dish(3, "Muboora with tomaotes", 30, "{dovi,salt,soda}", "mix")) ; 
    }
    
    public List<Dish> findAll(){
        return dishes; 
    }
    public Dish save(Dish dish){
        if(dish.getDishid() == null){
            
            dish.setDishid(++Dishcount);
        }
        return dish; 
    }
    public Dish findOne(Integer id){

        for (Dish dish:dishes){
            if(dish.getDishid() == id){
                return dish ;
            }
        }
        return null ; 
        
       
    }

    public Dish deleteById(Integer id){
        Iterator<Dish> iterator = dishes.iterator() ; 
        while(iterator.hasNext()){
            Dish dish =  iterator.next() ; 
            if(dish.getDishid() == id){
                iterator.remove();
                return dish ; 
            }
        }
      
        return null ; 
        
       
    }
    
    
    
    
}

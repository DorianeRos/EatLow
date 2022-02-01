package com.Eatlow.repository;

import org.springframework.data.repository.CrudRepository;
import com.Eatlow.model.Ingredient;

public interface CrudIngredientRepo extends CrudRepository<Ingredient, Integer> {

}

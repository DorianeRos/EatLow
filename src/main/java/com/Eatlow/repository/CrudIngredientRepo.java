package com.Eatlow.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.Eatlow.model.Ingredient;

public interface CrudIngredientRepo extends CrudRepository<Ingredient, Integer> {
    @Query("SELECT ing FROM Ingredient ing WHERE :inputName = ing.name OR UPPER(ing.name) LIKE CONCAT('%',UPPER(:inputName),'%')")
    public Iterable<Ingredient> getIngredientSimilarName(String inputName);

    @Query("SELECT plat.ingredients FROM Plat AS plat WHERE plat.id = :platID")
    public Iterable<Ingredient> getIngredientByPlatID(int platID);
}

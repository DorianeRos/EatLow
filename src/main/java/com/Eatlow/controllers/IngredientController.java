package com.Eatlow.controllers;

import com.Eatlow.model.Ingredient;
import com.Eatlow.repository.CrudIngredientRepo;
import com.Eatlow.repository.CrudPlatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

// mvn spring-boot:run

/**
 *
 */
@RestController
@CrossOrigin
@RequestMapping("api/ingredients")
public class IngredientController {

    @Autowired
    CrudIngredientRepo gestionRepoIngredient;

    private void verifIngredient(Integer perID) throws Exception{
        if(gestionRepoIngredient.findById(perID).isEmpty()){
            throw new Exception("L'ingredient avec l'ID '" + perID + "' n'existe pas !");
        } /** Vérifie si l'Ingredient avec x ID existe en BDD - lance une erreur si == true */
    }

    @GetMapping("/all")
    public Iterable<Ingredient> getAllIngredients() throws Exception{  // Service Rest : localhost:8084/ingredients/all
        return gestionRepoIngredient.findAll(); /** return tout les Ingredients (en JSON) */
    }

    @GetMapping("{id}")
    public Optional<Ingredient> getOneIngredient (@PathVariable("id") Integer perID) throws Exception{  // Service Rest : localhost:8084/ingredients/$id
        verifIngredient(perID);
        return gestionRepoIngredient.findById(perID); /** return un Ingredient par son ID (en JSON) */
    }

    @GetMapping("/search/{name}")
    public Iterable<Ingredient> getSimilarIngredients (@PathVariable("name") String inputName) throws Exception{  // Service Rest : localhost:8084/ingredients/search/$name
        return gestionRepoIngredient.getIngredientSimilarName(inputName); /** return un/des Ingredient(s) par similarité du nom recherché (en JSON) */
    }

    @GetMapping("/plat/{id}")
    public Iterable<Ingredient> getIngredientByPlat (@PathVariable("id") Integer idPlat) throws Exception{  // Service Rest : localhost:8084/ingredients/plat/$id
        Iterable<Ingredient> ingredientsFromPlat = gestionRepoIngredient.getIngredientByPlatID(idPlat);
        return ingredientsFromPlat; /** return un/des Ingredient(s) par un Plat lié (en JSON) */
    }
}

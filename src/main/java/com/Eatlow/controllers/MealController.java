package com.Eatlow.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Eatlow.exeptions.ErrorsMeal;
import com.Eatlow.model.Plat;
import com.Eatlow.repository.CrudPlatRepo;

@RestController
@CrossOrigin
@RequestMapping("api/meals")
public class MealController {

	@Autowired
	private CrudPlatRepo cpr;

	
	/**
	 * Gestion de l'erreur
	 * 
	 * @param pid
	 * @throws ErrorsMeal
	 */

	private void verifMeal(Integer pid) throws ErrorsMeal {
		if (cpr.findById(pid).isEmpty()) {
			throw new ErrorsMeal("N° Plat : " + pid + "non trouvé ! ");
		}
	}

	/**
	 * Dans postman : api/meals
	 * @return la liste des plats
	 */

	@GetMapping
	public Iterable<Plat> getAllMeals() {
		return cpr.findAll();
	}

	/**
	 * Dans postman : api/meals/1 (ou autre ID)
	 * 
	 * @param pid
	 * @author Doriane 
	 * @return un plat trouvé par son ID
	 * @throws ErreurPlat
	 * 
	 */

	@GetMapping("/{id}")
	public Optional<Plat> getOneMeal(@PathVariable("id") Integer pid) throws ErrorsMeal {
		verifMeal(pid);
		return cpr.findById(pid);
	}
	
	/**
	 * Trouver tout les plats portant le même nom
	 * @author doriane
	 * 
	 */
	
	@GetMapping("searchMeals/{searchByName}")
	public Iterable<Plat> getSimilarMeals(@PathVariable("searchByName") String name) throws ErrorsMeal {
		return cpr.getSimilarMeals(name);
	}
		
	
	/**
	 * Trouver tout les plats associés à un ingredient
	 * @author doriane
	 */
	
	@GetMapping("ByIngredient/{searchById}")
	public Iterable<Plat> getMealsByIngredientId(@PathVariable("searchById") Integer id) throws ErrorsMeal {
		return cpr.getMealsByIngredientId(id);
	}
	
	
}

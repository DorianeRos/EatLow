package com.Eatlow.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.Eatlow.model.Plat;

public interface CrudPlatRepo extends CrudRepository<Plat, Integer> {
	@Query("SELECT p FROM Plat p WHERE :inputName = p.name OR UPPER(p.name) LIKE CONCAT('%', UPPER(:inputName), '%')")
	public Iterable<Plat> getSimilarMeals(String inputName);
			
	
	@Query("SELECT p FROM Plat AS p LEFT JOIN p.ingredients AS i WHERE i.id = :id")
	public Iterable<Plat> getMealsByIngredientId(int id);

	
}





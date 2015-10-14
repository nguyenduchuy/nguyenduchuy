package ua.service;

import java.util.List;

import ua.domain.IngredientAndAmound;

public interface IngredientService {

	void save(int recipeId, int amount, String ingredientName,
			String measuringSystemName) throws IllegalStateException;

	void update(int iaaId, int amount, String ingredientName,
			String measuringSystemName) throws IllegalStateException;
	
	void delete(int id);
	
	List<IngredientAndAmound> findAll();
	
	IngredientAndAmound findById(int id);
}

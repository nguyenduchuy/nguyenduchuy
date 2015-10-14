package ua.service;

import java.util.List;

import ua.domain.Recipe;

public interface RecipeService {

	int save(String countryName, String cookTime, String recipeName);
	void update(int id, String countryName, String cookTime, String recipeName);
	void delete(int id);
	Recipe findById(int id);
	List<Recipe> findAll();
	
}

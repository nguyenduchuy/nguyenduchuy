package ua.dao;

import ua.domain.Recipe;

public interface RecipeDao extends GeneralDao<Recipe, Integer>{

	Recipe findByNameAndCountryName(String recipeName, String countryName);
}

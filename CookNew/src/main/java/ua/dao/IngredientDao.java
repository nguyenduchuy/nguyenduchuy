package ua.dao;

import ua.domain.Ingredient;

public interface IngredientDao extends GeneralDao<Ingredient, Integer>{

	Ingredient findByName(String name);
}

package ua.dao;

import ua.domain.IngredientAndAmound;

public interface IngredientAndAmoundDao extends
		GeneralDao<IngredientAndAmound, Integer> {

	IngredientAndAmound findIfExist(String measuringSystemName,
			String ingredientName, int amount);
}

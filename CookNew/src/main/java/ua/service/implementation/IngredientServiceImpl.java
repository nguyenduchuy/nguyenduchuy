package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.dao.IngredientAndAmoundDao;
import ua.dao.IngredientDao;
import ua.dao.MeasuringSystemDao;
import ua.dao.RecipeDao;
import ua.domain.Ingredient;
import ua.domain.IngredientAndAmound;
import ua.domain.MeasuringSystem;
import ua.domain.Recipe;
import ua.service.IngredientService;

@Service
public class IngredientServiceImpl implements IngredientService {

	@Autowired
	private RecipeDao recipeDao;

	@Autowired
	private IngredientAndAmoundDao ingredientAndAmoundDao;

	@Autowired
	private IngredientDao ingredientDao;

	@Autowired
	private MeasuringSystemDao measuringSystemDao;

	public void save(int recipeId, int amount, String ingredientName,
			String measuringSystemName) throws IllegalStateException {
		Recipe recipe = recipeDao.findById(recipeId);
		if (recipe == null) {
			throw new IllegalStateException("Wrong recipe id");
		} else {
			IngredientAndAmound iaa = ingredientAndAmoundDao.findIfExist(
					measuringSystemName, ingredientName, amount);
			if (iaa != null) {
				recipe.getIngredientAndAmound().add(iaa);
				recipeDao.update(recipe);
				iaa.getRecipes().add(recipe);
				ingredientAndAmoundDao.update(iaa);
			} else {
				iaa = new IngredientAndAmound();
				Ingredient ingredient = ingredientDao
						.findByName(ingredientName);
				if (ingredient != null) {
					iaa.setIngredient(ingredient);
				} else {
					ingredient = new Ingredient();
					ingredient.setName(ingredientName);
					ingredientDao.save(ingredient);
					iaa.setIngredient(ingredient);
				}
				MeasuringSystem ms = measuringSystemDao
						.findByName(measuringSystemName);
				if (ms != null) {
					iaa.setMeasuringSystem(ms);
				} else {
					ms = new MeasuringSystem();
					ms.setName(measuringSystemName);
					measuringSystemDao.save(ms);
					iaa.setMeasuringSystem(ms);
				}
				iaa.setAmount(amount);
				ingredientAndAmoundDao.save(iaa);
				recipe.getIngredientAndAmound().add(iaa);
				recipeDao.update(recipe);
				iaa.getRecipes().add(recipe);
				ingredientAndAmoundDao.update(iaa);
			}
		}
	}

	public void update(int iaaId, int amount, String ingredientName,
			String measuringSystemName) throws IllegalStateException {
		IngredientAndAmound iaa = ingredientAndAmoundDao.findById(iaaId);
		if (iaa == null) {
			throw new IllegalArgumentException();
		} else {
			Ingredient ingredient = ingredientDao.findByName(ingredientName);
			if (ingredient != null) {
				iaa.setIngredient(ingredient);
			} else {
				ingredient = new Ingredient();
				ingredient.setName(ingredientName);
				ingredientDao.save(ingredient);
				iaa.setIngredient(ingredient);
			}
			MeasuringSystem ms = measuringSystemDao
					.findByName(measuringSystemName);
			if (ms != null) {
				iaa.setMeasuringSystem(ms);
			} else {
				ms = new MeasuringSystem();
				ms.setName(measuringSystemName);
				measuringSystemDao.save(ms);
				iaa.setMeasuringSystem(ms);
			}
			iaa.setAmount(amount);
			ingredientAndAmoundDao.update(iaa);
		}
	}

	public void delete(int id) {
		ingredientAndAmoundDao.delete(findById(id));
	}
	
	public List<IngredientAndAmound> findAll() {
		return ingredientAndAmoundDao.findAll();
	}

	public IngredientAndAmound findById(int id) {
		return ingredientAndAmoundDao.findById(id);
	}
}

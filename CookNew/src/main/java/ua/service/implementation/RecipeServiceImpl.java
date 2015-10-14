package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.dao.CountryDao;
import ua.dao.RecipeDao;
import ua.domain.Country;
import ua.domain.Recipe;
import ua.service.RecipeService;

@Service
public class RecipeServiceImpl implements RecipeService {

	@Autowired
	private RecipeDao recipeDao;

	@Autowired
	private CountryDao countryDao;
	
	@Transactional
	public int save(String countryName, String cookTime, String recipeName) {
		Country country = countryDao.findByName(countryName);
		if (country == null){
			country = new Country();
			country.setName(countryName);
			countryDao.save(country);
		}
		Recipe recipe = recipeDao.findByNameAndCountryName(recipeName,
				countryName);
		if (recipe != null) {
			return recipe.getId();
		} else {
			recipe = new Recipe();
			recipe.setName(recipeName);
			recipe.setCookTime(Integer.parseInt(cookTime));
			recipe.setCountry(country);
			recipeDao.save(recipe);
			return recipe.getId();
		}
	}
	
	public void update(int id, String countryName, String cookTime, String recipeName){
		Country country = countryDao.findByName(countryName);
		if (country == null){
			country = new Country();
			country.setName(countryName);
			countryDao.save(country);
		}
		Recipe recipe = recipeDao.findById(id);
		recipe.setCookTime(Integer.parseInt(cookTime));
		recipe.setCountry(country);
		recipe.setName(recipeName);
	}
	
	public void delete(int id){
		recipeDao.delete(findById(id));
	}
	
	public Recipe findById(int id){
		return recipeDao.findById(id);
	}
	
	public List<Recipe> findAll(){
		return recipeDao.findAll();
	}
}
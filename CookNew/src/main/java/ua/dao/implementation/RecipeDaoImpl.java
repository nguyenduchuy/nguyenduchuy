package ua.dao.implementation;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import ua.dao.RecipeDao;
import ua.domain.Recipe;

@Repository
public class RecipeDaoImpl extends GeneralDaoImpl<Recipe, Integer> implements
		RecipeDao {

	public RecipeDaoImpl() {
		super(Recipe.class);
	}

	public Recipe findByNameAndCountryName(String recipeName, String countryName) {
		try{
			return (Recipe) em.createQuery("select r from Recipe "
				+ "r where r.name = :recipe and r.country.name = :country")
				.setParameter("recipe", recipeName)
				.setParameter("country", countryName).getSingleResult();
		} catch(NoResultException e){
			return null;
		}
	}
}

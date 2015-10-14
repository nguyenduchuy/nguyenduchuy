package ua.dao.implementation;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import ua.dao.IngredientDao;
import ua.domain.Ingredient;

@Repository
public class IngredientDaoImpl extends GeneralDaoImpl<Ingredient, Integer>
		implements IngredientDao {

	public IngredientDaoImpl() {
		super(Ingredient.class);
	}

	public Ingredient findByName(String name) {
		try {
			return (Ingredient) em
					.createQuery(
							"select i from Ingredient i where i.name = :name")
					.setParameter("name", name).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}

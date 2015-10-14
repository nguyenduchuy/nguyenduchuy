package ua.dao.implementation;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.dao.IngredientAndAmoundDao;
import ua.domain.IngredientAndAmound;

@Repository
public class IngredientAndAmoundDaoImpl extends
		GeneralDaoImpl<IngredientAndAmound, Integer> implements
		IngredientAndAmoundDao {

	public IngredientAndAmoundDaoImpl() {
		super(IngredientAndAmound.class);
	}

	@Transactional
	public IngredientAndAmound findIfExist(String measuringSystemName,
			String ingredientName, int amount) {
		try{
			return (IngredientAndAmound) em
					.createQuery("select i from IngredientAndAmound i where i.amount = :amount and "
					+ "i.ingredient.name = :ingredientName and i.measuringSystem.name = :measuringSystemName")
					.setParameter("amount", amount)
					.setParameter("ingredientName", ingredientName)
					.setParameter("measuringSystemName", measuringSystemName)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}

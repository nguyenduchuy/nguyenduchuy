package ua.dao.implementation;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ua.dao.CountryDao;
import ua.domain.Country;

@Repository
public class CountryDaoImpl extends GeneralDaoImpl<Country, Integer> implements
		CountryDao {

	public CountryDaoImpl() {
		super(Country.class);
	}

	@Transactional
	public Country findByName(String name) {
		try {
			return (Country) em
					.createQuery("select c from Country c where c.name = :name")
					.setParameter("name", name).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}

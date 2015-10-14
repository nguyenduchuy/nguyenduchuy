package ua.dao;

import ua.domain.Country;

// Upload to github
public interface CountryDao extends GeneralDao<Country, Integer>{

	Country findByName(String name);
}

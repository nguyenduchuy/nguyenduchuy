package ua.dao;

import ua.domain.Country;


public interface CountryDao extends GeneralDao<Country, Integer>{

	Country findByName(String name);
}

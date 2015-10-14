package ua.dao;

import ua.domain.MeasuringSystem;

public interface MeasuringSystemDao extends GeneralDao<MeasuringSystem, Integer>{

	MeasuringSystem findByName(String name);
}

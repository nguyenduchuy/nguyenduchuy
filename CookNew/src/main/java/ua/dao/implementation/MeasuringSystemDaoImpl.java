package ua.dao.implementation;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import ua.dao.MeasuringSystemDao;
import ua.domain.MeasuringSystem;

@Repository
public class MeasuringSystemDaoImpl extends
		GeneralDaoImpl<MeasuringSystem, Integer> implements MeasuringSystemDao {

	public MeasuringSystemDaoImpl() {
		super(MeasuringSystem.class);
	}

	public MeasuringSystem findByName(String name) {
		try {
			return (MeasuringSystem) em
					.createQuery(
							"select m from MeasuringSystem m where m.name = :name")
					.setParameter("name", name).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
}
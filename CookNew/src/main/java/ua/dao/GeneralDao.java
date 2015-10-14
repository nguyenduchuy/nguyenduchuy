package ua.dao;

import java.util.List;

public interface GeneralDao <K, N extends Number>{

	K findById(N id);
	List<K> findAll();
	void save(K entity);
	void update(K entity);
	void delete(K entity);
}

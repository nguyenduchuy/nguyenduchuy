package ua.dao.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import ua.dao.GeneralDao;

public class GeneralDaoImpl<K, N extends Number> implements GeneralDao<K, N> {

	private Class<K> entityClass;

	public GeneralDaoImpl(Class<K> entityClass) {
		this.entityClass = entityClass;
	}

	@PersistenceContext(unitName = "Primary")
	EntityManager em;

	@SuppressWarnings("unchecked")
	@Transactional
	public K findById(N id) {
		return (K) em
				.createQuery(
						"select k from " + entityClass.getSimpleName()
								+ " k where k.id = :id").setParameter("id", id)
				.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<K> findAll() {
		return em.createQuery("from " + entityClass.getSimpleName())
				.getResultList();
	}

	@Transactional
	public void save(K entity) {
		em.persist(entity);
	}

	@Transactional
	public void update(K entity) {
		em.merge(entity);
	}

	@Transactional
	public void delete(K entity) {
		em.remove(entity);
	}
}

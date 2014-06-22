package com.ct.salmjareb.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ct.salmjareb.dao.GenericDAO;


@Repository
public abstract class GenericDAOImpl<T> implements GenericDAO<T> {

	@PersistenceContext
	EntityManager em;

	Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	
	private Class<T> type;

	public GenericDAOImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		type = (Class) pt.getActualTypeArguments()[0];
	}
	
	@Override
	public T add(T t) {
		em.persist(t);
		return t;
	}

	@Override
	public T update(T t) {
		return em.merge(t);
	}

	@Override
	public Boolean remove(Long id) {
		try{
			em.remove(this.findOne(id));
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public T findOne(Long id) {
		return em.find(this.type, id);
	}

	@Override
	public List<T> findAll(Integer start, Integer limit) {
		try{
			
			final StringBuffer queryString = new StringBuffer("SELECT o FROM ");
			queryString.append(type.getSimpleName()).append(" o ");
			Query query = em.createQuery(queryString.toString(), type);
			if(start != null){
				query.setFirstResult(start);
			}
			if(limit != null){
				query.setMaxResults(limit);
			}
			return query.getResultList();
		}catch(Exception e){
			e.printStackTrace();
			return Collections.emptyList();
		}
	}

	@Override
	public Long countAll() {
		try{
			final StringBuffer queryString = new StringBuffer("SELECT COUNT(o) FROM ");
			queryString.append(type.getSimpleName()).append(" o ");
			
			return em.createQuery(queryString.toString(), Long.class).getSingleResult();
		}catch(Exception e){
			e.printStackTrace();
			return 0L;
		}
	}

}

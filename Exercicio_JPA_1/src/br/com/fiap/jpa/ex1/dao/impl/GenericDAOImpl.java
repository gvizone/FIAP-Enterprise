package br.com.fiap.jpa.ex1.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.ex1.dao.GenericDAO;
import br.com.fiap.jpa.ex1.exception.CommitException;
import br.com.fiap.jpa.ex1.exception.KeyNotFoundException;

public class GenericDAOImpl<T, K> implements GenericDAO<T, K>{

	private EntityManager em;
	
	private Class<T> clazz;
	
	@SuppressWarnings("unchecked")
	public GenericDAOImpl(EntityManager em) {
		this.em = em;
		clazz =  (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Override
	public void inserir(T entidade) {
		em.persist(entidade);
		
	}

	@Override
	public void atualizar(T entidade) {
		em.merge(entidade);
		
	}

	@Override
	public T buscar(K codigo) {
		
		T entidade = em.find(clazz, codigo);
		return entidade;
	}

	@Override
	public void remover(K codigo) throws KeyNotFoundException {
		T entidade = buscar(codigo);
		if (codigo == null) {
			throw new KeyNotFoundException();
		}
		em.remove(entidade);
		
	}

	@Override
	public void commit() throws CommitException {
		
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e){
			if (em.getTransaction().isActive()) 
				em.getTransaction().rollback();
			e.printStackTrace();
			throw new CommitException("Erro ao gravar");
		}
	}

	
}

package br.com.fiap.nac.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.nac.dao.GenericDAO;
import br.com.fiap.nac.exception.DBException;
import br.com.fiap.nac.exception.IdNotFoundException;

public class GenericDAOImpl<T,K> implements GenericDAO<T, K>{

	protected EntityManager em;
	
	private Class<T> classe;
	
	@SuppressWarnings("unchecked")
	public GenericDAOImpl(EntityManager em) {
		this.em = em;
		classe = (Class<T>) ((ParameterizedType)getClass()
			.getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Override
	public void cadastrar(T entity) {
		em.persist(entity);
	}

	@Override
	public void alterar(T entity) {

	}

	@Override
	public void remover(K codigo) throws IdNotFoundException {

		
	}

	@Override
	public T pesquisar(K codigo) {
		return em.find(classe, codigo);
	}
	
	public void salvar() throws DBException{
		try {
			
		}catch(Exception e){
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			throw new DBException("Erro no commit", e);
		}
	}

	@Override
	public List<T> listar() {
		return em.createQuery("from " 
				+ classe.getName(), classe)
				.getResultList();
	}

}







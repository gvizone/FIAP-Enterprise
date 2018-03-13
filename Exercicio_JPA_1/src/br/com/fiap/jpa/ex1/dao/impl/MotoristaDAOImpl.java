package br.com.fiap.jpa.ex1.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.ex1.dao.MotoristaDAO;
import br.com.fiap.jpa.ex1.entity.Motorista;

public class MotoristaDAOImpl extends GenericDAOImpl<Motorista, Integer> implements MotoristaDAO{

	public MotoristaDAOImpl(EntityManager em) {
		super(em);
	}

	
		
	

	
}

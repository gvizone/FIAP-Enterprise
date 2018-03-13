package br.com.fiap.jpa.ex1.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.ex1.dao.CorridaDAO;
import br.com.fiap.jpa.ex1.entity.Corrida;

public class CorridaDAOImpl extends GenericDAOImpl<Corrida, Integer> implements CorridaDAO{

	public CorridaDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}

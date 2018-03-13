package br.com.fiap.jpa.ex1.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.ex1.dao.PassageiroDAO;
import br.com.fiap.jpa.ex1.entity.Passageiro;

public class PassageiroDAOImpl extends GenericDAOImpl<Passageiro, Integer> implements PassageiroDAO{

	public PassageiroDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}

package br.com.fiap.jpa.ex1.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.ex1.dao.VeiculoDAO;
import br.com.fiap.jpa.ex1.entity.Veiculo;

public class VeiculoDAOImpl extends GenericDAOImpl<Veiculo, Integer> implements VeiculoDAO{

	public VeiculoDAOImpl(EntityManager em) {
		super(em);
	}


	
}

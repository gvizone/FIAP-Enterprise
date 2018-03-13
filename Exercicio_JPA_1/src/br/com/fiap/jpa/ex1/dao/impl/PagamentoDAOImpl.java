package br.com.fiap.jpa.ex1.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.jpa.ex1.dao.PagamentoDAO;
import br.com.fiap.jpa.ex1.entity.Pagamento;

public class PagamentoDAOImpl extends GenericDAOImpl<Pagamento, Integer> implements PagamentoDAO{

	public PagamentoDAOImpl(EntityManager em) {
		super(em);
	}

	
}

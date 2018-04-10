package br.com.fiap.dao.impl;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.entity.Cliente;

public class ClienteDAOImpl extends GenericDAOImpl<Cliente,Integer> implements ClienteDAO{

	public ClienteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Cliente> pesquisarPorEstado(String estado) {
		return em.createQuery("from Cliente c where "
				+ "c.endereco.cidade.uf = :est",Cliente.class)
				.setParameter("est", estado)
				.getResultList();
	}

	@Override
	public List<Cliente> pesquisarPorDiasReserva(int dias) {
		return em.createQuery("select r.cliente from "
				+ "Reserva r where r.numeroDias = :D",Cliente.class)
				.setParameter("D", dias)
				.getResultList();
	}
	
	@Override
	public List<Cliente> buscar(String nome, String cidade){
		
		return em.createQuery("from Cliente c where c.nome like :n and e.endereco.cidade.nome like :C", Cliente.class)
				.setParameter("n", "%" + nome + "%")
				.setParameter("C", cidade)
				.getResultList();
				
	}

	@Override
	public List<Cliente> buscarPorEstados(List<String> estados) {
		return em.createQuery("from Cliente c where " + "c.endereco.cidade.uf in :e", Cliente.class)
				.setParameter("e", estados)
				.getResultList();
	}
}








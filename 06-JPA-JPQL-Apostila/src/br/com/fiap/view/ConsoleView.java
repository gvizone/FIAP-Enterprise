package br.com.fiap.view;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.CidadeDAO;
import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.impl.CidadeDAOImpl;
import br.com.fiap.entity.Cidade;

public class ConsoleView {

	public static void main(String[] args) {
	
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		CidadeDAO cidadeDAO = new CidadeDAOImpl(em);
		System.out.println("LISTAR CIDADES");
		List<Cidade> lista = cidadeDAO.listar();
		
		for (Cidade cidade : lista) {
			System.out.println(cidade.getNome() + " " + cidade.getUf());
		}
		
		System.out.println("BUSCA POR NOME");
		lista = cidadeDAO.buscaPorNome("Londrina");
		for (Cidade cidade : lista) {
			System.out.println(cidade.getNome() + " " + cidade.getUf());
		}
		
		em.close();
		fabrica.close();
		
	}

}




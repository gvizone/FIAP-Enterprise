package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.PessoaDAO;
import br.com.fiap.jpa.dao.impl.PessoaDAOImpl;
import br.com.fiap.jpa.entity.Pessoa;
import br.com.fiap.jpa.entity.PessoaFisica;
import br.com.fiap.jpa.entity.PessoaJuridica;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class HerancaTest {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		PessoaDAO dao = new PessoaDAOImpl(em);
		
		Pessoa pessoa = new Pessoa("Gabriel Vizone", "Jd. Paulista");
		PessoaFisica pf = new PessoaFisica("Gabriel Vizone", "Av. Paulista", "45598817829", 534377087);
		PessoaJuridica pj = new PessoaJuridica("FIAP", "Aclimação", 69746874, "FIAP - Faculda de Informatica e Administração Paulista");
				
		try {
			dao.inserir(pessoa);
			dao.inserir(pf);
			dao.inserir(pj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
		fabrica.close();
	}
}

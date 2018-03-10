package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.LivroDAO;
import br.com.fiap.jpa.dao.impl.LivroDAOImpl;
import br.com.fiap.jpa.entity.Livro;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.KeyNotFoundException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class Teste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		
		EntityManager em = fabrica.createEntityManager();
		
		LivroDAO livroDAO = new LivroDAOImpl(em);
		
		Livro livro = new Livro("Game of Thrones", "George R. R. Martin");
		
		//Cadastrar			
		livroDAO.inserir(livro);
		
		//Buscar		
		livroDAO.buscar(livro.getCodigo());
		
		//Atualizar
		livro.setAutor("George Martin");
		livroDAO.atualizar(livro);
		System.out.println(livroDAO.buscar(livro.getCodigo()).getAutor());
		
		//Remover
		try {
			livroDAO.remover(livroDAO.buscar(livro.getCodigo()).getCodigo());
		} catch (KeyNotFoundException e) {
			e.printStackTrace();
		}
		//Chamada
		try {
			livroDAO.commmit();
		} catch (CommitException e) {
			e.printStackTrace();
		}
		
		em.close();
		fabrica.close();
	}
}

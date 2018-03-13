package br.com.fiap.jpa.ex1.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.ex1.dao.MotoristaDAO;
import br.com.fiap.jpa.ex1.dao.impl.MotoristaDAOImpl;
import br.com.fiap.jpa.ex1.entity.Genero;
import br.com.fiap.jpa.ex1.entity.Motorista;
import br.com.fiap.jpa.ex1.singleton.EntityManagerFactorySingleton;

public class Teste {

	public static void main(String[] args) {

		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		
		EntityManager em = fabrica.createEntityManager();
		
		MotoristaDAO motoristaDAO = new MotoristaDAOImpl(em);
		
		Motorista motorista = new Motorista(4253546, "John Doe", new GregorianCalendar(12,  Calendar.APRIL, 1980), null, Genero.MASCULINO);
		
		motoristaDAO.inserir(motorista);

	}

}

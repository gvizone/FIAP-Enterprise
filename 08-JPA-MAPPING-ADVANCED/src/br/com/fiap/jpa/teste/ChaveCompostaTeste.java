package br.com.fiap.jpa.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.ConsultaDAO;
import br.com.fiap.jpa.dao.impl.ConsultaDAOImpl;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.mapping.advanced.entity.Consulta;
import br.com.fiap.jpa.mapping.advanced.entity.Medico;
import br.com.fiap.jpa.mapping.advanced.entity.Paciente;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class ChaveCompostaTeste {

	public static void main(String[] args) {
		
		Medico medico = new Medico(325423, "Jose das Neves", "Pediatra", 20000, 1356547);
		
		Paciente paciente = new Paciente("Joaozinho", new GregorianCalendar(21, Calendar.AUGUST, 2010));
		
		Consulta consulta = new Consulta(medico, paciente, Calendar.getInstance(), "SALA-06", false);
		
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		ConsultaDAO consultaDao = new ConsultaDAOImpl(em);
		
		try {
			consultaDao.inserir(consulta);
			consultaDao.commit();
		} catch (CommitException e) {
			e.printStackTrace();
		}
		
		em.close();
		fabrica.close();
	}
}

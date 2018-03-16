package br.com.fiap.jpa.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.jpa.dao.NotaFiscalDAO;
import br.com.fiap.jpa.dao.PedidoDAO;
import br.com.fiap.jpa.dao.impl.NotaFiscalDAOImpl;
import br.com.fiap.jpa.dao.impl.PedidoDAOImpl;
import br.com.fiap.jpa.entity.NotaFiscal;
import br.com.fiap.jpa.entity.Pedido;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.singleton.EntityManagerFactorySingleton;

public class RelTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		
		Pedido pedido = new Pedido(new GregorianCalendar(2018, Calendar.MARCH, 16), "BK");		
		PedidoDAO pedidoDAO = new PedidoDAOImpl(em);		
				
		NotaFiscal notaFiscal = new NotaFiscal(new GregorianCalendar(2018, Calendar.MARCH, 16), 17.90, pedidoDAO.buscar(pedido.getCodigo()));		
		NotaFiscalDAO notaDAO = new NotaFiscalDAOImpl(em);
		
		try {
			notaDAO.inserir(notaFiscal);		
			notaDAO.commit();
		} catch (CommitException e) {
			e.printStackTrace();
		}
		
		em.close();
		fabrica.close();
	}
}

package br.com.fiap.bo;

import javax.ejb.Stateless;

@Stateless
public interface ClienteBO {

	double calcularImpostoRenda(double rendimento);
}

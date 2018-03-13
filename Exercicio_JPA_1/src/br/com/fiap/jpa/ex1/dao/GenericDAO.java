package br.com.fiap.jpa.ex1.dao;

import br.com.fiap.jpa.ex1.exception.CommitException;
import br.com.fiap.jpa.ex1.exception.KeyNotFoundException;

public interface GenericDAO <T, K>{

	void inserir(T entidade);
	
	void atualizar(T entidade);
	
	T buscar(K codigo);
	
	void remover(K codigo) throws KeyNotFoundException;
	
	void commit() throws CommitException;
}

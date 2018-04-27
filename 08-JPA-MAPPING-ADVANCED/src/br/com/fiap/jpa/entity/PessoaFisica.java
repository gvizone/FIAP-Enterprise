package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PessoaFisica extends Pessoa{

	@Column(name="nr_cpf")
	private String cpf;
	
	@Column(name="nr_rg")
	private long rg;

	public PessoaFisica() {
		super();
	}

	public PessoaFisica(String nome, String endereco, String cpf, long rg) {
		super(nome, endereco);
		this.cpf = cpf;
		this.rg = rg;
	}	
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public long getRg() {
		return rg;
	}

	public void setRg(long rg) {
		this.rg = rg;
	}
	
	
	
}

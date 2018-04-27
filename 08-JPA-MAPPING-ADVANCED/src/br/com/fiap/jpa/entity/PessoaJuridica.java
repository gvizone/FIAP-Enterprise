package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class PessoaJuridica extends Pessoa{

	@Column(name="nr_cnpj")
	private long cnpj;
	
	@Column(name="ds_razao_social")
	private String razaoSocial;

	public PessoaJuridica(String nome, String endereco, long cnpj, String razaoSocial) {
		super(nome, endereco);
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
	}

	public long getCnpj() {
		return cnpj;
	}

	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}	
	
	
}

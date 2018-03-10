package br.com.fiap.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="T_ALUNO")
public class Aluno implements Serializable{

	@Id
	@Column(name="cd_aluno")
	private String rm;
	
	@Column(name="nm_aluno", nullable=false, length=150)
	private String nome;

	public Aluno() {
		super();
	}

	public Aluno(String rm, String nome) {
		this.rm = rm;
		this.nome = nome;
	}

	public String getRm() {
		return rm;
	}

	public void setRm(String rm) {
		this.rm = rm;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}

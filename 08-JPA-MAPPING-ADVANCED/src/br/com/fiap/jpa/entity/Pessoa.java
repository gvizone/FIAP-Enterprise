package br.com.fiap.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Inheritance(strategy=InheritanceType.JOINED)

@Entity
@Table(name="TBL_PESSOA")
@SequenceGenerator(name="pessoa", sequenceName="SQ_T_PESSOA",allocationSize=1)
public class Pessoa {

	@Id
	@GeneratedValue(generator="pessoa", strategy=GenerationType.SEQUENCE)
	@Column(name="cd_pessoa")
	private int codigo;

	@Column(name="nm_pessoa", nullable=false)
	private String nome;

	@Column(name="ds_endereco", nullable=false)
	private String endereco;

	public Pessoa() {
		
	}

	public Pessoa(String nome, String endereco) {
		this.nome = nome;
		this.endereco = endereco;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
}

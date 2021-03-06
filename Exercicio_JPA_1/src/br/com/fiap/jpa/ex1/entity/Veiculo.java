package br.com.fiap.jpa.ex1.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_VEICULO")
@SuppressWarnings("serial")
@SequenceGenerator(name="veiculo", sequenceName="SQ_T_VEICULO", allocationSize=1)
public class Veiculo implements Serializable{
	
	@Id
	@Column(name="cd_veiculo")
	@GeneratedValue(generator="veiculo", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="ds_placa", length=9, nullable=false)
	private String placa;
	
	@Column(name="ds_cor", length=20, nullable=false)
	private String cor;
	
	@Column(name="nr_ano")
	private int ano;

	public Veiculo() {
		super();
	}

	public Veiculo(String placa, String cor, int ano) {
		super();
		this.placa = placa;
		this.cor = cor;
		this.ano = ano;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}
	
	
	
	
	
}

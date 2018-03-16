package br.com.fiap.jpa.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_PEDIDO")
@SuppressWarnings("serial")
@SequenceGenerator(name="pedido", sequenceName="SQ_T_PEDIDO", allocationSize=1)
public class Pedido implements Serializable{

	@Id
	@Column(name="cd_pedido")
	@GeneratedValue(generator="pedido", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_pedido", nullable=false)
	private Calendar data;
	
	@Column(name="ds_pedido", nullable=false)
	private String descricao;

	@OneToOne(mappedBy="pedido")
	private NotaFiscal nota;
	
	public NotaFiscal getNota() {
		return nota;
	}

	public void setNota(NotaFiscal nota) {
		this.nota = nota;
	}

	public Pedido() {
		
	}

	public Pedido(Calendar data, String descricao) {
		this.data = data;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}

package com.senior.desafio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="produtos")
public class Produto {

	@Id
	@Column(name="id_produto")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idProduto;
	
	@Column(name="ds_produto")
	private String dsProduto;
	
	@Column(name="nr_valor_venda")
	private double nrValorVenda;
	
	@Column(name="nr_valor_compra")
	private double nrValorCompra;

	public long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(long idProduto) {
		this.idProduto = idProduto;
	}

	public String getDsProduto() {
		return dsProduto;
	}

	public void setDsProduto(String dsProduto) {
		this.dsProduto = dsProduto;
	}

	public double getNrValorVenda() {
		return nrValorVenda;
	}

	public void setNrValorVenda(double nrValorVenda) {
		this.nrValorVenda = nrValorVenda;
	}

	public double getNrValorCompra() {
		return nrValorCompra;
	}

	public void setNrValorCompra(double nrValorCompra) {
		this.nrValorCompra = nrValorCompra;
	}
	
	
	
}

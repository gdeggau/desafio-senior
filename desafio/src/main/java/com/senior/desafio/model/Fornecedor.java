package com.senior.desafio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fornecedores")
public class Fornecedor {
	
	@Id
	@Column(name="id_fornecedor")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idFornecedor;
	
	@Column(name="nm_fornecedor")
	private String nmFornecedor;
	
	@Column(name="ds_cnpj")
	private String dsCnpj;

	public long getIdFornecedor() {
		return idFornecedor;
	}

	public void setIdFornecedor(long idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	public String getNmFornecedor() {
		return nmFornecedor;
	}

	public void setNmFornecedor(String nmFornecedor) {
		this.nmFornecedor = nmFornecedor;
	}

	public String getDsCnpj() {
		return dsCnpj;
	}

	public void setDsCnpj(String dsCnpj) {
		this.dsCnpj = dsCnpj;
	}
	
}

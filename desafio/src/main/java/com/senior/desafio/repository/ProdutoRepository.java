package com.senior.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senior.desafio.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	Produto findByIdProduto(Long id);
}

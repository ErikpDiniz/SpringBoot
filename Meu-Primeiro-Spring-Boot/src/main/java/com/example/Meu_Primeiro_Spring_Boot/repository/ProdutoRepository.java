package com.example.Meu_Primeiro_Spring_Boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Meu_Primeiro_Spring_Boot.model.Produto;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

} 

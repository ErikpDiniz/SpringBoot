package com.example.Meu_Primeiro_Spring_Boot.Service;

import java.util.List;



import org.springframework.stereotype.Service;

import com.example.Meu_Primeiro_Spring_Boot.Exceptions.RecursoNaoEncontradoException;
import com.example.Meu_Primeiro_Spring_Boot.model.Produto;
import com.example.Meu_Primeiro_Spring_Boot.repository.ProdutoRepository;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> ListarProdutos() {
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id)
        .orElseThrow(() -> new RecursoNaoEncontradoException("Produto com ID "+id+" não encontrado!"));
    } 

    public Produto salvarProduto (Produto produto) {
        return produtoRepository.save(produto);
    }

    public void deletarProduto(long id) {

        if (!produtoRepository.existsById(id)){
            throw new RecursoNaoEncontradoException("Produto com ID "+id+" não encontrado!");
        }
        produtoRepository.deleteById(id);
    }

}

package br.edu.infnet.produto.service;

import br.edu.infnet.produto.model.Produto;
import br.edu.infnet.produto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Flux<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Flux<Produto> buscarPorNome(String nome) {
        return produtoRepository.findByNome(nome);
    }

    public Mono<Produto> adicionarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }
}
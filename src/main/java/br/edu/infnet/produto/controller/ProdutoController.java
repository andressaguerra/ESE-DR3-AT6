package br.edu.infnet.produto.controller;

import br.edu.infnet.produto.model.Produto;
import br.edu.infnet.produto.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = new ProdutoService();
    }

    @GetMapping
    public Flux<Produto> listarProdutos() {
        return produtoService.listarTodos();
    }

    @GetMapping("/nome/{nome}")
    public Flux<Produto> buscarPorNome(@PathVariable String nome) {
        return produtoService.buscarPorNome(nome);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Produto> adicionarProduto(@RequestBody Produto produto) {
        return produtoService.adicionarProduto(produto);
    }
}
package br.edu.infnet.produto.repository;

import br.edu.infnet.produto.model.Produto;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface ProdutoRepository extends ReactiveCrudRepository<Produto, Long> {
    Flux<Produto> findByNome(String nome);
}
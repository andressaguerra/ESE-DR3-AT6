package br.edu.infnet.produto.service;

import br.edu.infnet.produto.model.Produto;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ProdutoWebClient {

    private final WebClient webClient;

    public ProdutoWebClient(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8083/produtos").build();
    }

    public Flux<Produto> getAllProdutos() {
        return webClient.get()
                .retrieve()
                .bodyToFlux(Produto.class);
    }

    public Mono<Produto> getProdutoById(Long id) {
        return webClient.get()
                .uri("/{id}", id)
                .retrieve()
                .bodyToMono(Produto.class);
    }

    public Mono<Produto> saveProduto(Produto produto) {
        return webClient.post()
                .bodyValue(produto)
                .retrieve()
                .bodyToMono(Produto.class);
    }

    public Mono<Void> deleteProduto(Long id) {
        return webClient.delete()
                .uri("/{id}", id)
                .retrieve()
                .bodyToMono(Void.class);
    }
}

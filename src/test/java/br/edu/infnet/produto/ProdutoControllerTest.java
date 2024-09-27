package br.edu.infnet.produto;

import br.edu.infnet.produto.controller.ProdutoController;
import br.edu.infnet.produto.model.Produto;
import br.edu.infnet.produto.service.ProdutoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.*;

@WebFluxTest(ProdutoController.class)
public class ProdutoControllerTest {

    @Autowired
    private WebTestClient webClient;

    @MockBean
    private ProdutoService service;

    private Produto produto;

    @Autowired
    private WebTestClient webTestClient;
    @Autowired
    private ProdutoService produtoService;

    @BeforeEach
    void setUp() {
        produto = new Produto(1L, "Coca", 5.0);
    }

    @Test
    public void testFindAll() {
        doReturn(Flux.just(produto)).when(produtoService).listarTodos();
        webClient.get().uri("/produtos")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Produto.class)
                .hasSize(1)
                .contains(produto);

        verify(produtoService, times(1)).listarTodos();
    }
}

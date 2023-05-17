package se.iths.restwebshopclient;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class WebShopClient {

    WebClient client = WebClient.create("http://localhost:8080/rest");

    public List<Product> showProducts() {
        Flux<Product> f = client
                .get()
                .uri("/products")
                .retrieve()
                .bodyToFlux(Product.class);
        return (f.collectList().block());
    }

    public Product addProduct(Product product) {
        Mono<String> m = client
                .post()
                .uri("/addproduct")
                .bodyValue(product)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class);
        m.block();
        return product;
    }

    public void updateProduct(Long id, Product product) {
        Mono<String> m = client
                .put()
                .uri("/update/{id}", id)
                .bodyValue(product)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class);
        m.block();
    }

    public void deleteProduct(Long id) {
        Mono<String> m = client
                .delete()
                .uri("/delete/{id}", id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class);
        m.block();
    }

}

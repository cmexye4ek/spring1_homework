package ru.gb.spring.repositories;

import org.springframework.stereotype.Repository;
import ru.gb.spring.models.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> productList;

    @PostConstruct
    private void init() {
        this.productList = new ArrayList<>(Arrays.asList(
                new Product(1L, "pen", 2),
                new Product(2L, "apple", 10),
                new Product(3L, "book", 100),
                new Product(4L, "cat", 500),
                new Product(666L, "satan's favorite scarf", 666)
        ));
    }

    public Product getProductById(Long id) {
        return productList.stream().filter(s -> s.getId().equals(id)).findFirst().get();
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void addNewProduct (Product product) {
        productList.add(product);
    }
}

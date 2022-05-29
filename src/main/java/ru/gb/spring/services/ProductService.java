package ru.gb.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.spring.models.Product;
import ru.gb.spring.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    final private String listFormat = "%-5d %-25s %-5d" + System.lineSeparator();
    final private String headerFormat = "%-5s %-25s %-5s" + System.lineSeparator();
    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductById(Long id) {
        return productRepository.getProductById(id);
    }

    public List<Product> getProductList() {
        return productRepository.getProductList();
    }

    public void printProductList() {
        System.out.println("Product list: ");
        System.out.printf(headerFormat, "ID", "Title", "Cost");
        productRepository.getProductList().stream().forEach(s -> System.out.printf(listFormat, s.getId(), s.getTitle(), s.getCost()));
        System.out.println();
    }

    public void addNewProduct(Product product) {
        productRepository.addNewProduct(product);
    }

    public void increaseCostByOne(Product product) {
        productRepository.getProductList().stream().filter(s -> s.getId().equals(product.getId())).findFirst().get().setCost(product.getCost() + 1);
    }

    public void decreaseCostByOne(Product product) {
        productRepository.getProductList().stream().filter(s -> s.getId().equals(product.getId())).findFirst().get().setCost(product.getCost() - 1);
    }
}

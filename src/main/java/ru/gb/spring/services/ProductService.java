package ru.gb.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.spring.models.Product;
import ru.gb.spring.repositories.ProductDao;

import java.util.List;

@Service
public class ProductService {
    final private String listFormat = "%-5d %-25s %-5d" + System.lineSeparator();
    final private String headerFormat = "%-5s %-25s %-5s" + System.lineSeparator();
    private ProductDao productDao;

    @Autowired
    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public Product getProductById(Long id) {
        return productDao.getProductById(id);
    }

    public List<Product> getProductList() {
        return productDao.getAllProducts();
    }

    public void printProductList() {
        System.out.println("Product list: ");
        System.out.printf(headerFormat, "ID", "Title", "Cost");
        productDao.getAllProducts().stream().forEach(s -> System.out.printf(listFormat, s.getId(), s.getTitle(), s.getCost()));
        System.out.println();
    }

    public void addOrUpdateProduct(Product product) {
        productDao.addOrUpdateProduct(product);
    }

    public void increaseCostByOne(Product product) {
        product.setCost(product.getCost() + 1);
        productDao.addOrUpdateProduct(product);
    }

    public void decreaseCostByOne(Product product) {
        product.setCost(product.getCost() - 1);
        productDao.addOrUpdateProduct(product);
    }

    public void deleteProduct(Product product) {
        productDao.deleteProductById(product.getId());
    }

}

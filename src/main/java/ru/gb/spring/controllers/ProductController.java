package ru.gb.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.gb.spring.models.Product;
import ru.gb.spring.services.ProductService;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController (ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/list_all")
    @ResponseBody
    public List<Product> showProductsPage () {
        return productService.getProductList();
    }

    @PostMapping(value = "/add_new")
    @ResponseBody
    public void addNewProduct (@RequestBody Product product) {
        productService.addNewProduct(product);
    }
}

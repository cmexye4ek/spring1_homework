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

    //http://localhost:8189/app/productlistpage.html
    @GetMapping(value = "/list_all")
    @ResponseBody
    public List<Product> showProductsPage () {
        return productService.getProductList();
    }

    //http://localhost:8189/app/AddNewProduct.html
    @PostMapping(value = "/add_new")
    @ResponseBody
    public void addNewProduct (@RequestBody Product product) {
        productService.addOrUpdateProduct(product);
    }

    @PostMapping(value = "/increase_cost")
    @ResponseBody
    public void increaseCostByOne (@RequestBody Product product) {
        productService.increaseCostByOne(product);
    }

    @PostMapping(value = "/decrease_cost")
    @ResponseBody
    public void decreaseCostByOne (@RequestBody Product product) {
        productService.decreaseCostByOne(product);
    }

    @PostMapping(value = "/delete_product")
    @ResponseBody
    public void deleteProduct (@RequestBody Product product) {
        productService.deleteProduct(product);
    }
}

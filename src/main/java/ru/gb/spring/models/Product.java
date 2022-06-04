package ru.gb.spring.models;

import javax.persistence.*;

@Entity
@Table(name = "products")
@NamedQueries({
        @NamedQuery(name = "Product.getAll", query = "SELECT p FROM Product p ORDER BY p.id"),
        @NamedQuery(name = "Product.getById", query = "SELECT p FROM Product p WHERE p.id = :id"),
        @NamedQuery(name = "Product.deleteById", query = "DELETE FROM Product p WHERE p.id = :id"),
})

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "cost")
    private int cost;

    public Product(){}

    public Product(Long id, String title, int cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}

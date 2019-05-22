package com.example.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "manufacturer",
        fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Product> products;

    public Category(){}

    public Category(long parseLong, String string) {
        this.id = parseLong;
        this.name = string;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getDevices() {
        return products;
    }

    public void setDevices(List<Product> products) {
        this.products = products;
    }
}
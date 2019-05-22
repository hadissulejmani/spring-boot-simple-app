package com.example.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String name;
	String content;
	String url;
	Double price;

	@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "man_id")
    private Manufacturer manufacturer;

	@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cat_id")
    private Category category;

	@JsonIgnore
    @ManyToMany
    @JoinTable(name = "product_accessory",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "accessory"))
    private List<Accessory> accessories;


	public Product() {}
	
	public Product(Long id, String name, String content, String url, Double price, Category category, Manufacturer manufacturer) {
		super();
		this.id = id;
		this.name = name;
		this.content = content;
		this.url = url;
		this.price = price;
		this.category = category;
		this.manufacturer = manufacturer;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double p) {
		this.price = p;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}
}
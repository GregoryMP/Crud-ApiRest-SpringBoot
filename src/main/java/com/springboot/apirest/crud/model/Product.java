package com.springboot.apirest.crud.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_product;

	private String name;
	private float price;

	public Integer getId_product() {
		return id_product;
	}

	public void setId_product(Integer id_product) {
		this.id_product = id_product;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Product(Integer id_product, String name, float price) {
		super();
		this.id_product = id_product;
		this.name = name;
		this.price = price;
	}

	public Product(String name, float price) {
		super();
		this.name = name;
		this.price = price;
	}

	public Product() {
		super();
	}

}

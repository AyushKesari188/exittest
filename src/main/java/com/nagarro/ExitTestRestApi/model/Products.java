package com.nagarro.ExitTestRestApi.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Products {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "Name", nullable = false, unique = true)
	private String name;
	
	@Column(name = "brand", nullable = false)
	private String brand;
	
	@Column(name = "description", nullable = false, length = 1000)
	private String description;
	
	@Column(name = "code", nullable = false, unique = true)
	private String code;
	
	@Column(name = "image", columnDefinition = "LONGBLOB ")
	private byte[] image;
	
	@Column(name = "price", nullable = false)
	private double price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Products(int id, String name, String brand, String description, String code, byte[] image, double price) {
		super();
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.description = description;
		this.code = code;
		this.image = image;
		this.price = price;
	}

	public Products() {
		super();
	}

	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", brand=" + brand + ", description=" + description + ", code="
				+ code + ", image=" + Arrays.toString(image) + ", price=" + price + "]";
	}
	
	

}

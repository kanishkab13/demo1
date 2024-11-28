package com.cg.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

    @Entity
	@Table(name="Micro_prod")
	public class Product {
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		@Column(name="Prod_Id")
		private int id;
		@Column(name="Prod_Name")
		@NotBlank(message = "The name must not be null and must contain at least one non-whitespace character")
		private String name;
		@Column(name="Prod_Price")
		
		private double price;
		public Product() {
			super();
		}
		public Product(int id, String name, double price) {
			super();
			this.id = id;
			this.name = name;
			this.price = price;
		}
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
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		@Override
		public String toString() {
			return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
		}
	}


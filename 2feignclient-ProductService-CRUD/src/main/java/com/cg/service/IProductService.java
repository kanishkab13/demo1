
	package com.cg.service;
	 
	import java.util.List;
import java.util.Optional;

import com.cg.model.Product;
	 
	public interface IProductService {
		public List<Product> findAll();
		public Optional<Product> findProductById(int id);
		public Product CreateProduct(Product p);
		public String DeleteProductbyId(int id);
		public Product UpdateData(Product p);
	}


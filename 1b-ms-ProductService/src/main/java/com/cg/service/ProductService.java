package com.cg.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.cg.model.Product;
import com.cg.repository.ProductRepository;
 
@Service
public class ProductService implements IProductService {
 
	@Autowired
	ProductRepository productRepository;
	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}
	
	public Optional<Product> findProductById(int id) {
		return productRepository.findById(id);
	}
	
	public Product CreateProduct(Product p) {
		return productRepository.save(p);
	}
	
	public String DeleteProductbyId(int id) {
		if (productRepository.existsById(id)) {
	        productRepository.deleteById(id);;
	         return "deleted";
	    } else {
	    	 return "id not found";
	    }
			
	}
	
	public Product UpdateData(Product p) {	
		return productRepository.save(p);
	}
}

package com.cg.controller;

import java.util.List;
import java.util.Optional;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.exception.NotAcceptableException;
import com.cg.exception.ResourceNotFoundException;
import com.cg.model.Product;
import com.cg.service.IProductService;

import jakarta.validation.Valid;

@RequestMapping("/api")
@RestController
public class ProductController {
	@Autowired
	IProductService productService;
	//@GetMapping(path="/products", produces = {MediaType.APPLICATION_XML_VALUE})
	@GetMapping("/prod")
	public List<Product> getProducts()
	{
		return productService.findAll();
	}
	
	@GetMapping("/prod1/{id}")
     public Optional<Product>findByProductId(@Valid @PathVariable int id) throws ResourceNotFoundException{
		Optional<Product> product = productService.findProductById(id);
	    //java8 lambda version
    	product.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + id));
    	System.out.println(id);
         return product;	

		
	}
	
	@GetMapping("/prod/myProduct") 
	public Optional<Product> getProductbyId(@Valid @RequestParam int id)throws ResourceNotFoundException{
		Optional<Product> product = productService.findProductById(id);
	    //java8 lambda version
    	product.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + id));
    	System.out.println(id);
    	return productService.findProductById(id);
		
	}
	
	@PostMapping("/prod")   //to add product in postman without manually inserting into postgres
	public Product createMyProduct(@Valid @RequestBody Product p) throws BadRequestException {
		if (p.getName() == null || p.getPrice() <=0||p.getName()=="") {
            throw new BadRequestException("Product name or price is invalid.");
		}	
		return productService.CreateProduct(p);
	}
	
	
	@DeleteMapping("/prod/{id}")
	public String deleteProductbyId(@Valid @PathVariable int id) throws ResourceNotFoundException {
		String r= productService.DeleteProductbyId(id);
		if(r == null || r.isEmpty()) {
			throw new ResourceNotFoundException("Product not found for this id"+id);
		}		
		return r;
	}
	
	@PutMapping("/prod")
	public Product UpdateProduct(@Valid @RequestBody Product p) throws BadRequestException {
		if(p.getName()==null || p.getPrice() <=100 || p.getName()=="" || p.getId() >=10) {
			throw new BadRequestException("Product could not be updated as no product exists with this id");
		}
		return productService.UpdateData(p);
	}
	@Value("${error.productNotFound}")
    private String productNotFoundMessage;
    @Value("${error.productDeletionFailed}")
    private String productDeletionFailedMessage;
    @Value("${error.productAlreadyExists}")
    private String productAlreadyExistsMessage;
 
@PostMapping("/addproducts")
    public Product addProduct(@RequestBody @Valid Product product) throws ResourceNotFoundException {
        Optional<Product> existingProduct = productService.findProductById(product.getId());
        if (existingProduct.isPresent()) {
            throw new ResourceNotFoundException(String.format(productAlreadyExistsMessage, product.getName()));
        }
        return productService.CreateProduct(product);
    }	
			
}
 

package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
 
import com.cg.model.Product;
 
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer>{
	public List<Product> findAllByName(String name) ;
	@Query
	("select count(*) from Product p where p.name = :name")
	public int getCountByProduct(String name);
	
		
	
}
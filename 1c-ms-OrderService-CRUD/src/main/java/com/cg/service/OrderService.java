package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.model.Order;
import com.cg.repository.OrderRepository;

@Service
public class OrderService implements IOrderService {
	@Autowired
	OrderRepository orderrepo;
	@Override
	public List<Order> findAll(){
		return orderrepo.findAll();		
	}
	
	public Optional<Order> findOrderById(int id){
		return orderrepo.findById(id);		
	}
	
	public Order createOrder(Order o) {
		return orderrepo.save(o);
	}
	
	public String deleteOrderById(int id) {
		if (orderrepo.existsById(id)) {
	        orderrepo.deleteById(id);;
	         return "deleted";
	    } else {
	    	 return "id not found";
	    }
	}
	
    public Order updateOrder(Order o) {
    	return orderrepo.save(o);
    }
	

}

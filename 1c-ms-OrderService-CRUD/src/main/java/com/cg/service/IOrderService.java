package com.cg.service;

import java.util.List;
import java.util.Optional;

import com.cg.model.Order;

public interface IOrderService {

	public List<Order> findAll();
	public Optional<Order> findOrderById(int id);
	public Order createOrder(Order o);
	public String deleteOrderById(int id);
	public Order updateOrder(Order o);
  
}

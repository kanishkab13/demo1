package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.model.Order;

public interface OrderRepository extends JpaRepository<Order,Integer>{ 

}

package com.cg.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Micro_order")
public class Order {
 @Id
 @GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="Order_Id")
 private int orderid;
 @Column(name="Order_No")
 private String orderno;
 @Column(name="Order_date")
 private String orderdate;
 
public Order() {
	super();
}

public Order(int orderid, String orderno, String orderdate) {
	super();
	this.orderid = orderid;
	this.orderno = orderno;
	this.orderdate = orderdate;
}

public int getOrderid() {
	return orderid;
}

public void setOrderid(int orderid) {
	this.orderid = orderid;
}

public String getOrderno() {
	return orderno;
}

public void setOrderno(String orderno) {
	this.orderno = orderno;
}



public String getOrderdate() {
	return orderdate;
}

public void setOrderdate(String orderdate) {
	this.orderdate = orderdate;
}

@Override
public String toString() {
	return "Order [orderid=" + orderid + ", orderno=" + orderno + ", orderdate=" + orderdate + "]";
}
}
package com.yuji.testmybatis.service;

import java.util.List;

import com.yuji.testmybatis.beans.orders.Order;

public interface IOrderService {
	
	 public Order findOrderById(int oid); 
	 
	 public int saveOneOrder(Order order);
	 
	 public List<Order> findOrdersByObject(Order order);

}

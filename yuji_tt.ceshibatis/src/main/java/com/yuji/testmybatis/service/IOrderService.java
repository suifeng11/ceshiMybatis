package com.yuji.testmybatis.service;

import com.yuji.testmybatis.beans.orders.Order;

public interface IOrderService {
	
	 public Order findOrderById(int oid); 
	 
	 public int saveOneOrder(Order order);

}

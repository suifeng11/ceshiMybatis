package com.yuji.testmybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuji.testmybatis.beans.orders.Order;
import com.yuji.testmybatis.dao.orders.OrderDaoMapper;

@Service("OrderService")
public class OrderService implements IOrderService {
	
	 @Autowired
	 private OrderDaoMapper orderMapper;
	
	 public Order findOrderById(int oid)
	 {
		 return orderMapper.findOrderById(oid);
	 }

	@Override
	public int saveOneOrder(Order order) {
		// TODO Auto-generated method stub
		return orderMapper.saveOneOrder(order);
	}

}

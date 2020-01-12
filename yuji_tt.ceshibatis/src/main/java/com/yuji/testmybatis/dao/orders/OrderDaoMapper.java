package com.yuji.testmybatis.dao.orders;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.yuji.testmybatis.beans.orders.Order;
@Mapper
public interface OrderDaoMapper {

	 public Order findOrderById(int oid);
    
	 //根据对象属性值查询
     public List<Order> findOrdersByObject(Order order);
     
     //根据map对应的键值查询
     public List<Order> findOrdersByObject(Map<String,String> maps);
     
     public int saveOneOrder(Order order);
     
     public void  delOneOrder(Order order);
     
     
}

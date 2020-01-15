package com.yuji.testmybatis.servlet;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuji.testmybatis.beans.orders.Customer;
import com.yuji.testmybatis.beans.orders.Order;
import com.yuji.testmybatis.service.IOrderService;

@Controller
@RequestMapping("/order") 
public class OrderController {
	
	@Resource(name = "OrderService")
    private IOrderService orderService;
	
	// http://localhost:8080/order/getOneOrderById?ordId=1
	@ResponseBody
    @RequestMapping(value = "/getOneOrderById")
    public Order getOneOrderById(HttpServletRequest request) throws Exception {
    	 
		String sid = request.getParameter("ordId");
		
		return orderService.findOrderById((Integer.parseInt(sid)));
    }
	
	// http://localhost:8080/order/saveOneOrder?ordName=ordName&price=100.21&customerId=1
	
	@ResponseBody
    @RequestMapping(value = "/saveOneOrder")
    public Order saveOneOrder(HttpServletRequest request) throws Exception {
    	 
		String ordName = request.getParameter("ordName");
		String strPrice = request.getParameter("price");
		String customerId = request.getParameter("customerId");
		
		Order order = new Order();
		order.setOrdName(ordName);
		order.setPrice(Double.parseDouble(strPrice));
		order.setCreateTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		Customer cus = new Customer();
		cus.setId(Integer.parseInt(customerId));
		order.setCustomer(cus);
		
		int id =  orderService.saveOneOrder(order);;
		order.setId(id);
		
		return order;
		
    }

}

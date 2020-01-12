package com.yuji.testmybatis.servlet;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuji.testmybatis.beans.orders.Order;
import com.yuji.testmybatis.service.IOrderService;

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Resource(name = "OrderService")
    private IOrderService orderService;
	
	// http://localhost/order/getOneOrderById?ordId=1
	@ResponseBody
    @RequestMapping(value = "/getOneOrderById")
    public Order getOneOrderById(HttpServletRequest request) throws Exception {
    	 
		String sid = request.getParameter("ordId");
		
		return orderService.findOrderById((Integer.parseInt(sid)));
    }

}

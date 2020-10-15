package com.in28minutes.rest.webservices.restfulwebservices.orderDetails;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {
	
	@Autowired
	private OrderRepo orders;
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@PostMapping("/orders")
	public Orders addOrderDetails(@RequestBody Orders order1) {
		
		
		orders.save(order1);
		
		
		return order1;
	}
	
	
	@GetMapping(path = "/orders")
	public List<Orders> getOrderDetails(){
		return orders.findAll();
	}
	
	@DeleteMapping("/orders/{oId}")
	public List<Orders> deleteOrderDetails(@PathVariable Long oId) {
		Orders ord = orders.getOne(oId);
		
		orders.delete(ord);
		
		return orders.findAll();
	}
	
	@PutMapping(path = "/orders/{oId}")
	public Orders saveOrUpdateOrderDetails(@RequestBody Orders order) {
		orders.save(order);
		return order;
	}
	
	
	
	@RequestMapping("/orders/{oId}")
	
	public Optional<Orders> getOrderDetails(@PathVariable("oId") Long oId) {
	
		return orders.findById(oId);
	}

}

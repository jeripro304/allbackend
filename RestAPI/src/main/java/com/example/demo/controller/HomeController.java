package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Employee;
import com.example.demo.service.Service;

@RestController
public class HomeController {
	
	@Autowired
	Service ser;
	
	@PostMapping("/employee")
	@ResponseBody
	public String create(@RequestBody  Employee emp) {
		
		ser.create(emp);
		return "Employee Created";
		
	}
	
	@GetMapping("/employee")
	public List<Employee> getemployees() {
	    List<Employee> emplist=ser.getemployees();
		return emplist ;
	}

}

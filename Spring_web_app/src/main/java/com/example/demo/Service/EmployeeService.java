package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.Model.Employee;

@Component
public class EmployeeService {
	
	static List<Employee> emplist= new ArrayList<>();
	
	public void addemployee(Employee emp) {
		emplist.add(emp);
		System.out.println("from employee service");
		System.out.println(emplist);
	}
	
	public List<Employee> viewemployee(){
		
		return emplist;
		
	}
	

}

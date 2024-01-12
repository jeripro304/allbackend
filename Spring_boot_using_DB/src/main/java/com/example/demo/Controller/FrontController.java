package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Model.Employee;
import com.example.demo.Repo.EmployeeRepo;

@Controller
public class FrontController {
	
	@Autowired
	 EmployeeRepo er;
	
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/create")
	@ResponseBody
	public String home(String ename,int salary,String dept) {
		Employee e=new Employee();
		e.setEname(ename);
		e.setSalary(salary);
		e.setDept(dept);

		er.save(e);
		return "Employee added";
		
	}
	
	@RequestMapping("/view")
	@ResponseBody
	public String view() {
		return er.findAll().toString();
	}

}

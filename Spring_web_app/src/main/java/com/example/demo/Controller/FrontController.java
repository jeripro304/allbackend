package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Model.Employee;
import com.example.demo.Service.EmployeeService;

@Controller
public class FrontController {
	
	@Autowired
	EmployeeService es;
	
	@RequestMapping("/")
	public String View() {
		return "index.jsp";
	}
	
	@Autowired
	Employee emp;
	
	@RequestMapping("/empform")
	public ModelAndView display(int eid,String uname,int salary,String dept) {
		ModelAndView mv= new ModelAndView("index.jsp");
		emp.setEid(eid);
		emp.setUname(uname);
		emp.setSalary(salary);
		emp.setDept(dept);
		
		
		System.out.println(emp);
		es.addemployee(emp);
		
		
		
		return mv;
	}
	
//	@RequestMapping("/view")
//	public ModelAndView viewEmployee() {
//		List<Employee> emplist =es.viewemployee();
//		ModelAndView mv=new ModelAndView();
//		
//				
//		return mv;
//	}

	
	
}

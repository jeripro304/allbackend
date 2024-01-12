package com.example.db.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.db.Repo;
import com.example.db.Model.Employee;

import ch.qos.logback.core.model.Model;



@Controller
public class FrontController {
	
	@Autowired
	 Repo er;
	
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/create")
	public ModelAndView home(String ename,int salary,String dept) {
		ModelAndView mv=new ModelAndView("EmployeeCreate.jsp");
		Employee e=new Employee();
		e.setEname(ename);
		e.setSalary(salary);
		e.setDept(dept);
		er.save(e);
		mv.addObject("msg","Employee Created");
		return mv;
		
	}
	
	@RequestMapping("/view")
	public ModelAndView view() {
		ModelAndView mv=new ModelAndView("ViewEmployee.jsp");
		
		mv.addObject("emplist", er.findAll());
		return mv;
	}
	
	@RequestMapping("/search")
	public ModelAndView searchid(String search,String input) {
		ModelAndView mv=new ModelAndView("ViewEmployee.jsp");
		switch(search) {
		case "id":
			int id=Integer.parseInt(input);
			mv.addObject("emplist",er.findByeid(id));
			break;
		case "dept":
			mv.addObject("emplist",er.findByDept(input));
			break;
		}
		return mv;
	}
	
	@RequestMapping("/delete")
	public ModelAndView delete(int id) {
		ModelAndView mv=new ModelAndView("view");
		er.deleteById(id);
		return mv;
		
	}
	
	

}

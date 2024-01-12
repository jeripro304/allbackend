package microservices.springboot.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import microservices.springboot.entity.Employee;

@RestController
public class HomeController {
	
	@GetMapping("/employees")
	public List<Employee> employees(){
		List<Employee> elist=new ArrayList<>();
		for (int i=0;i<6;i++) {
			Employee e=new Employee(100+i,"Employee "+new Random().nextInt(10),new Random().nextInt(5000),"Dept "+new Random().nextInt(10));
		}
		return elist;
	}

}

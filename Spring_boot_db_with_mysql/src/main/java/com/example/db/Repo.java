package com.example.db;
import org.springframework.data.repository.CrudRepository;

import com.example.db.Model.Employee;
import java.util.List;


public interface Repo extends CrudRepository<Employee, Integer>{

	List<Employee> findByDept(String dept);
	List<Employee> findByeid(int id);


}

package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Model.Employee;

public interface Repo extends CrudRepository<Employee, Integer> {

}

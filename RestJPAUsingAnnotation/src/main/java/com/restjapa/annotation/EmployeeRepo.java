package com.restjapa.annotation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.restjapa.annotation.model.Employee;

@RepositoryRestResource(collectionResourceRel = "/employee", path="employee")
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}

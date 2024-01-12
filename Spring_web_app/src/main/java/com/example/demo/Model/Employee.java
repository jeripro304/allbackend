package com.example.demo.Model;

import org.springframework.stereotype.Component;

@Component
public class Employee {
	private int eid;
	private String uname;
	private int salary;
	private String dept;
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", uname=" + uname + ", salary=" + salary + ", dept=" + dept + "]";
	}
	
	

}

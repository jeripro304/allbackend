package microservices.springboot.entity;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	private int eid;
	private String ename;
	private int salary;
	private String dept;

}

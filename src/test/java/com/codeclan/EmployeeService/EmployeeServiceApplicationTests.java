package com.codeclan.EmployeeService;

import com.codeclan.EmployeeService.repositories.DepartmentRepository;
import com.codeclan.EmployeeService.repositories.EmployeeRepository;
import com.codeclan.EmployeeService.repositories.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmployeeServiceApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canCreateAnEmployeeWithADepartmentAndProject(){
		Department department = new Department("Employee");
		departmentRepository.save(department);

		Employee employee1 = new Employee("Randy", "Marsh", "RMA59", department);
		employeeRepository.save(employee1);

		Project project1 = new Project("Kill Kenny", 30);
		projectRepository.save(project1);
		project1.addEmployee(employee1);
		projectRepository.save(project1);
	}

}

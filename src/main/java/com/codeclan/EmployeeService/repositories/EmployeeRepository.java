package com.codeclan.EmployeeService.repositories;

import com.codeclan.EmployeeService.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

package com.codeclan.EmployeeService.repositories;

import com.codeclan.EmployeeService.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}

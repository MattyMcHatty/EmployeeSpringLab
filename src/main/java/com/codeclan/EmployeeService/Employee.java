package com.codeclan.EmployeeService;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="employeeNo")
    private String employeeNo;
    @ManyToOne
    @JoinColumn(name="department_id", nullable = false)
    private Department department;
    @ManyToMany
    @JsonIgnoreProperties({"employees"})
    @JoinTable(
            name="employees_projects",
            joinColumns = { @JoinColumn(
                    name="employee_id",
                    nullable = false,
                    updatable = false
            )
            },
            inverseJoinColumns = { @JoinColumn(
                    name="project_id",
                    nullable = false,
                    updatable = false
            )
            }
    )
    private List<Project> projects;

    public Employee(String firstName, String lastName, String employeeNo, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeNo = employeeNo;
        this.department = department;
        this.projects = new ArrayList<>();
    }

    public Employee(){}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addProject(Project project){
        this.projects.add(project);
    }
}

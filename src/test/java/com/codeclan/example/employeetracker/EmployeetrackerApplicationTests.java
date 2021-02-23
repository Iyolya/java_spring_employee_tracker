package com.codeclan.example.employeetracker;

import com.codeclan.example.employeetracker.models.Department;
import com.codeclan.example.employeetracker.models.Employee;
import com.codeclan.example.employeetracker.models.Project;
import com.codeclan.example.employeetracker.repositories.DepartmentRepository;
import com.codeclan.example.employeetracker.repositories.EmployeeRepository;
import com.codeclan.example.employeetracker.repositories.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeetrackerApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	ProjectRepository projectRepository;

	@Autowired
	DepartmentRepository departmentRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createEmployeeAndDepartment() {

		Department department = new Department("HR");
		departmentRepository.save(department);

		Employee employee = new Employee("Jon", "Jones", "QWERTY12", department);
		employeeRepository.save(employee);

		department.addEmployeeToDepartment(employee);
		departmentRepository.save(department);

	}

	@Test
	public void addEmployeesAndProjects() {

		Department department = new Department("HR");
		departmentRepository.save(department);

		Employee employee = new Employee("Jon", "Jones", "QWERTY12", department);
		employeeRepository.save(employee);

		Project project = new Project("Java", 2);
		projectRepository.save(project);

		project.addEmployee(employee);
		projectRepository.save(project);

		employee.addProject(project);
		employeeRepository.save(employee);
	}

}

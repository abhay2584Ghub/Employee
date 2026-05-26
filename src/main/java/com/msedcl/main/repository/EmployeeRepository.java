package com.msedcl.main.repository;

import java.util.List;

import com.msedcl.main.entity.Employee;

public interface EmployeeRepository {
	Employee addNewEmployee(Employee employee);
	Employee updateEmployee(Employee employee);
	Employee getEmployeeByEmployeeId(int employeeId);
	boolean deleteEmployeeByEmployeeId(int employeeId);
	List<Employee> getAllEmployees();
	List<Employee> getEmployeeByName(String name);
	long getCountOfEmployees();
	
}
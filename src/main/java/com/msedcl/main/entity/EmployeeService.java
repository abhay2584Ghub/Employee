package com.msedcl.main.entity;

import java.util.List;

public interface EmployeeService {

	Employee addNewEmployee(Employee employee);
	Employee updateEmployee(Employee employee);
	Employee getEmployeeByEmployeeId(int employeeId);
	Employee getEmployeeByName(String employeeName);
	boolean deleteEmployeeByEmployeeId(int employeeId);
	List<Employee> getAllEmployees();
}

package com.msedcl.main.service;

import java.util.List;

import com.msedcl.main.entity.Employee;

public interface EmployeeService {

	Employee addNewEmployee(Employee employee);

	Employee updateEmployee(Employee employee);

	Employee getEmployeeByEmployeeId(int employeeId);

	List<Employee> getEmployeeByName(String employeeName);

	boolean deleteEmployeeByEmployeeId(int employeeId);

	List<Employee> getAllEmployees();

	long getCountOfEmployees();
}

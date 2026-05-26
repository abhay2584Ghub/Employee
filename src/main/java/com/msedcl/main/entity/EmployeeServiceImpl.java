package com.msedcl.main.entity;

import java.util.List;

import com.msedcl.main.entity.Employee;
import com.msedcl.main.repository.EmployeeRepository;
import com.msedcl.main.repository.EmployeeRepositoryImpl;

public class EmployeeServiceImpl implements EmployeeService {
	private static final EmployeeRepository employeeRepository 
										= new EmployeeRepositoryImpl();

	@Override
	public Employee addNewEmployee(Employee employee) {
		return employeeRepository.addNewEmployee(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.updateEmployee(employee);
	}

	@Override
	public Employee getEmployeeByEmployeeId(int employeeId) {
		return employeeRepository.getEmployeeByEmployeeId(employeeId);
	}

	@Override
	public boolean deleteEmployeeByEmployeeId(int employeeId) {
		return employeeRepository.deleteEmployeeByEmployeeId(employeeId);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.getAllEmployees();
	}
	@Override
	public List<Employee> getEmployeeByName(String Name)
	{
		return employeeRepository.getEmployeeByName(Name);
	}

}
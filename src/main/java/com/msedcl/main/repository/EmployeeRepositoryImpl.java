package com.msedcl.main.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.msedcl.main.entity.Employee;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

	private JdbcTemplate jdbcTemplate;
	private static final String ADD_NEW_EMPLOYEE = "INSERT INTO employee_details(name, salary)VALUES(?,?)";
	private static final String UPDATE_EMPLOYEE = "UPDATE employee_details SET name=?, salary=? WHERE employee_id=?";
	private static final String DELETE_EMPLOYEE = "DELETE FROM employee_details WHERE employee_id=?";
	private static final String SELECT_EMPLOYEE_BE_EMPLOYEE_ID = "SELECT * FROM employee_details WHERE employee_id=?";
	private static final String SELECT_ALL_EMPLOYEE = "SELECT * FROM employee_details";
	private static final String COUNT_OF_EMPLOYEE = "SELECT COUNT(employee_id) FROM employee_details";
	

	public EmployeeRepositoryImpl(JdbcTemplate jdbcTemplate) {
		System.out.println("Overloaded Constructor Called");
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	@Transactional
	public Employee addNewEmployee(Employee employee) {
		int rowsInserted = jdbcTemplate.update(ADD_NEW_EMPLOYEE, employee.getName(), employee.getSalary());
		if (rowsInserted > 0)
			return employee;
		else
			return null;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		int rowsUpdate = jdbcTemplate.update(UPDATE_EMPLOYEE, employee.getName(), employee.getSalary(),
				employee.getEmployeeId());
		if (rowsUpdate > 0)
			return employee;
		else
			// TODO Auto-generated method stub
			return null;
	}

	@Override
	public Employee getEmployeeByEmployeeId(int employeeId) {
		return jdbcTemplate.queryForObject(SELECT_EMPLOYEE_BE_EMPLOYEE_ID, (rs, row) -> new Employee(rs.getInt(1),
				rs.getString(2),
				rs.getDouble(3)),
				employeeId);
	}

	@Override
	public boolean deleteEmployeeByEmployeeId(int employeeId) {
		int rowsUpdate = jdbcTemplate.update(DELETE_EMPLOYEE, employeeId);
		if (rowsUpdate > 0)
			return true;
		return false;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(SELECT_ALL_EMPLOYEE,
				(rs, rowCount) -> new Employee(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
	}

	@Override
	public List<Employee> getEmployeeByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getCountOfEmployees() {
		
		// TODO Auto-generated method stub
		return 0;
	}

}

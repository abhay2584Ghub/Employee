package com.msedcl.main.entity;

import java.util.List;
import java.util.Scanner;

import com.msedcl.main.entity.Employee;
import com.msedcl.main.util.HibernateUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.transaction.TransactionManager;

public class EmployeeCRUDMain {
	public static void main(String[] args) {
		EmployeeService employeeService = new EmployeeServiceImpl();
		Scanner scanner = new Scanner(System.in);
		int employeeId, choice;
		String name, continueChoice;
		double salary;

		do {
			System.out.println("Menu");
			System.out.println("1. Add New Employee");
			System.out.println("2. Search Employee By EmployeeId");
			System.out.println("3. Delete Employee By EmployeeId");
			System.out.println("4. Update Name of Existing Employee");
			System.out.println("5. Select All Employees");
			System.out.println("6. Search Employee by Name");
			System.out.println("7. Print total Emp count");
			System.out.println("Enter your choice");
			choice = scanner.nextInt();
			switch (choice) {
			case 7:
				long count = employeeService.getCountOfEmployees();
				
				break;
			case 6:
				System.out.println("Enter name");
				name=scanner.next();
				List<Employee> employeeList = employeeService.getAllEmployees()
				break;
				
			case 1:
				System.out.println("Enter Name");
				name = scanner.next();
				System.out.println("Enter Salary");
				salary = scanner.nextDouble();
				Employee employee = new Employee(0, name, salary);
				if (employeeService.addNewEmployee(employee) != null) {
					System.out.println("New employee added successfully");
					System.out.println("EmployeeId :: " + employee.getEmployeeId());
				}
				break;
			case 2:
				System.out.println("Enter employeeId");
				employeeId = scanner.nextInt();
				employee = employeeService.getEmployeeByEmployeeId(employeeId);
				if (employee != null)
					System.out.println(employee);
				else
					System.out.println("Invalid EmployeeId");
				break;
			case 3:
				System.out.println("Enter employeeId");
				employeeId = scanner.nextInt();
				if (employeeService.deleteEmployeeByEmployeeId(employeeId)) {
					System.out.println("Employee deleted successfully");
				} else {
					System.out.println("Invalid EmployeeId");
				}
				break;
			case 4:
				System.out.println("Enter employeeId");
				employeeId = scanner.nextInt();
				System.out.println("Enter New Name");
				name = scanner.next();
				System.out.println("Enter New Salary");
				salary = scanner.nextDouble();
				employee = new Employee(employeeId, name, salary);
				if (employeeService.updateEmployee(employee) != null) {
					System.out.println("Employee added successfully");
					System.out.println(employee);
				}
				break;
			case 5:
				employeeList = employeeService.getAllEmployees();
				employeeList.forEach(e -> System.out.println(e));
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
			System.out.println("Do you want to continue?");
			continueChoice = scanner.next();
		} while (continueChoice.equals("yes"));

	}
}
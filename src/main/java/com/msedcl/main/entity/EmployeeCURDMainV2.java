package com.msedcl.main.entity;

import java.util.Scanner;
import com.msedcl.main.util.HibernateUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EmployeeCURDMainV2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int employeeId, choice;
		String name, continueChoice;
		double salary;

		do {
			System.out.println("Menu");
			System.out.println("1. Add New Employee");
			System.out.println("2. Search employee");
			System.out.println("3. Delete employee");
			System.out.println("4. update employee");
			System.out.println("Enter your choice");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter Name");
				name = scanner.next();
				System.out.println("Enter Salary");
				salary = scanner.nextDouble();
				Employee employee = new Employee(0, name, salary);
				addNewEmployee(employee);
				break;
			case 2:
				System.out.println("Enter employeeId");
				employeeId = scanner.nextInt();
				getEmployeebyEmployeeID(employeeId);
				break;
			case 3:
				System.out.println("Enter employeeId");
				employeeId = scanner.nextInt();
				deleteEmployeeByEmployeeId(employeeId);
				break;
			case 4:
				System.out.println("Enter employeeId");
				employeeId = scanner.nextInt();
				System.out.println("Enter new Name :");
				name = scanner.next();
				System.out.println("Enter Salary");
				salary = scanner.nextDouble();
				employee = new Employee(employeeId, name, salary);
				updateEmployee(employee);
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
			System.out.println("Do you want to continue?");
			continueChoice = scanner.next();
		} while (continueChoice.equals("yes"));

	}

	public static void getEmployeebyEmployeeID(int employeeId) {
		// 1 Create EntityManager object
		EntityManager entityManager = HibernateUtil.getEntityManager();

		// 2. Get employee from database
		Employee employee = entityManager.find(Employee.class, employeeId);
		if (employee != null)
			System.out.println(employee);
		else
			System.out.println("Invalid EmployeeID");
		// 3. Close EntityManager object
		entityManager.close();
	}

	public static void updateEmployee(Employee employee) {
		EntityManager entitiManager = HibernateUtil.getEntityManager();
		Employee existingEmployee = entitiManager.find(Employee.class, employee.getEmployeeId());
		if (existingEmployee != null) {
			EntityTransaction entityTransaction = entitiManager.getTransaction();
			entityTransaction.begin();
			existingEmployee.setName(employee.getName());
			existingEmployee.setSalary(employee.getSalary());
			entityTransaction.commit();
			System.out.println("Employee Updated sucessfully");
		} else
			System.out.println("Invalid EmployeeId");
		entitiManager.close();
	}

	public static void addNewEmployee(Employee employee) {
		// 1. Create EntityManager object
		EntityManager entityManager = HibernateUtil.getEntityManager();

		// 2. Create Transaction object
		EntityTransaction entityTransaction = entityManager.getTransaction();

		// 3. Start Transaction
		entityTransaction.begin();

		// 4. Save employee object into database
		entityManager.persist(employee);

		// 5. Commit Transaction
		entityTransaction.commit();
		// 6. Close EntityManager
		entityManager.close();
		System.out.println("Employee create with employee id" + employee.getEmployeeId());
	}

	public static void deleteEmployeeByEmployeeId(int employeeId) {
		// 1. Create EntityManager object
		EntityManager entityManager = HibernateUtil.getEntityManager();

		// 2. Get employee by employeeID
		Employee existingEmployee = entityManager.find(Employee.class, employeeId);
		if (existingEmployee != null) {
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(existingEmployee);
			entityTransaction.commit();
			System.out.println("Employee deleted sucessfully!");
		} else {
			System.out.println("Invalid EmployeeId");
		}
		entityManager.close();
	}

}

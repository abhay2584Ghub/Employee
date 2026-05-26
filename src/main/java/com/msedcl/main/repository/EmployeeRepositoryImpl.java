package com.msedcl.main.repository;

import java.util.List;
import org.hibernate.query.Query;
import com.msedcl.main.entity.Employee;
import com.msedcl.main.util.HibernateUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class EmployeeRepositoryImpl implements EmployeeRepository {
	private EntityManager entityManager;
	private EntityTransaction entityTransaction;

	@Override
	public Employee addNewEmployee(Employee employee) {
		entityManager = HibernateUtil.getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(employee);
		entityTransaction.commit();
		entityManager.close();
		return employee;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		entityManager = HibernateUtil.getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(employee);
		entityTransaction.commit();
		entityManager.close();
		return employee;
	}

	@Override
	public Employee getEmployeeByEmployeeId(int employeeId) {
		entityManager = HibernateUtil.getEntityManager();
		Employee existingEmployee = entityManager.find(Employee.class, employeeId);
		entityManager.close();
		if (existingEmployee != null)
			return existingEmployee;
		return null;
	}

	@Override
	public boolean deleteEmployeeByEmployeeId(int employeeId) {
		entityManager = HibernateUtil.getEntityManager();
		Employee existingEmployee = entityManager.find(Employee.class, employeeId);
		if (existingEmployee != null) {
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(existingEmployee);
			entityTransaction.commit();
			return true;
		}
		entityManager.close();
		return false;
	}

	@Override
	public List<Employee> getAllEmployees() {
		entityManager = HibernateUtil.getEntityManager();
		String hql = "FROM Employee";
		List<Employee> employeeList = entityManager
				.createQuery(hql, Employee.class).getResultList();
		return employeeList;
	}

	
	@Override
	public List<Employee> getEmployeeByName(String name) {
		entityManager = HibernateUtil.getEntityManager();
		String hql = "FROM Employee WHERE name = :empName";
		List<Employee> employeeList = entityManager.createQuery(hql, Employee.class).setParameter("empName", name)
				.getResultList();
		entityManager.close();
		return employeeList;
	}

	@Override
	public long getCountOfEmployees()
	{	entityManager = HibernateUtil.getEntityManager();
		String hql = "SELECT COUNT(e) FROM Employee e";
		long count = entityManager.createQuery(hql, Long.class)
				.getSingleResult();
		entityManager.close();
		return count;
	}
}

package com.msedcl.main.entity;

import java.util.Scanner;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="Login_details")
public class Login_page {

	@Id
	@Column(name = "employee_id")
	private int employeeId;
	
	@Column(name = "password", length=50, nullable = false)
	private String password;
	
	@Column(name ="invalid_login_count", nullable = false)
	private int invalid_login_count;
	
	@Column(name ="max", nullable = false)
	private int max;
	
	@Column(name ="status", nullable = false)
	private String status;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getInvalid_login_count() {
		return invalid_login_count;
	}

	public void setInvalid_login_count(int invalid_login_count) {
		this.invalid_login_count = invalid_login_count;
	}

	public double getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Login_page [employeeId=" + employeeId + ", password=" + password + ", invalid_login_count="
				+ invalid_login_count + ", max=" + max + ", status=" + status + "]";
	}
}

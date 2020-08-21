package model.bean;

import java.time.LocalDate;

public class Employee {
	private String empId;
	private String empName;
	private String numberPhone;
	private LocalDate birthday;
	private String gender;
	private String ingUrl;
	private LocalDate startDate;
	private float salary;
	private Account account;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String empId, String empName, String numberPhone, LocalDate birthday, String gender,
			LocalDate startDate, float salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.numberPhone = numberPhone;
		this.birthday = birthday;
		this.gender = gender;
		this.startDate = startDate;
		this.salary = salary;
	}



	public String getIngUrl() {
		return ingUrl;
	}

	public void setIngUrl(String ingUrl) {
		this.ingUrl = ingUrl;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getNumberPhone() {
		return numberPhone;
	}

	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}

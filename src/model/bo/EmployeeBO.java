package model.bo;

import java.util.List;

import model.bean.Account;
import model.bean.Employee;
import model.dao.EmployeeDAO;

/**
 * EmployeeBO.java
 * 
 * Version
 * 
 * Date: 30-04-2020
 *
 * Copyright
 * 
 * Modification Logs: DATE AUTHOR DESCRIPTION
 * ------------------------------------------------------ 30-04-2020 HienTT20
 * Create
 */
public class EmployeeBO {
	private EmployeeDAO dao = new EmployeeDAO();

	public List<Employee> getEmployees() {
		return dao.getAll();
	}

	public int numberOfRecord() {
		return dao.getCount();
	}

	public boolean checkPrimary(String empId) {
		for(Employee employee: getEmployees()) {
			if(employee.getEmpId().equals(empId)) {
				return true;
			}
		}
		return false;
	}
	public void insert(Employee employee) {
		dao.insert(employee);
	}

	public List<Employee> getEmployees(int start, int recordPerPage) {
		// TODO Auto-generated method stub
		return dao.getEmployees(start, recordPerPage);
	}

	public Employee getEmployee(String empId) {
		return dao.find(empId);
	}

	public void update(Employee employee) {
		dao.update(employee);
		
	}

	public void delete(String empId) {
		dao.delete(empId);
	}
	
	public Account getAccount(String empId) {
		return dao.getAccount(empId);
	}

	public Employee getEmployeeByAccountId(int accountId) {
		return dao.getEmployeeByAccountID(accountId);
	}
	public List<Employee> getPT(){
		return dao.getPT();
	}

}

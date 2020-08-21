package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import common.Validate;
import model.bean.Account;
import model.bean.Employee;

public class EmployeeDAO {
	private Connection conn;

	public void insert(Employee employee) {
		conn = ConnectDB.getConnect();
		String sql = "insert into EMPLOYEE(empId, empName, numberPhone, birthday, imgUrl,startdate,salary,gender,accountId) "
				+ "values (?,?,?,?,?,?,?,?,?)";
		String insertAccount = "insert into ACCOUNT(accountName,password,accountType) values(?,?,?)";
		String selectAccount = "select accountId from Account where accountName= ?";
		PreparedStatement pst1 = null;
		PreparedStatement pst2 = null;
		PreparedStatement pst3 = null;
		Account account = employee.getAccount();
		try {
			conn.setAutoCommit(false);
			pst1 = conn.prepareStatement(insertAccount);
			pst1.setString(1, account.getAccountName());
			pst1.setString(2, account.getPassword());
			pst1.setString(3, account.getAccountType());
			pst1.executeUpdate();

			pst2 = conn.prepareStatement(selectAccount);
			pst2.setString(1, account.getAccountName());
			ResultSet rs = pst2.executeQuery();
			if (rs.next()) {
				account.setAccountId(rs.getInt(1));
			}

			pst3 = conn.prepareStatement(sql);
			pst3.setString(1, employee.getEmpId());
			pst3.setNString(2, employee.getEmpName());
			pst3.setString(3, employee.getNumberPhone());
			pst3.setDate(4, Date.valueOf(employee.getBirthday()));
			pst3.setString(5, employee.getIngUrl());
			pst3.setDate(6, Date.valueOf(employee.getStartDate()));
			pst3.setFloat(7, employee.getSalary());
			pst3.setNString(8, employee.getGender());
			pst3.setInt(9, account.getAccountId());

			pst3.executeUpdate();
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException excep) {

				}
			}
		} finally {

			try {
				pst1.close();
				pst2.close();
				pst3.close();
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void update(Employee employee) {
		conn = ConnectDB.getConnect();
		String sql = "update EMPLOYEE set empName = ?, numberPhone = ?, birthday = ?, startDate=?, salary=?, gender= ?"
				+ " where empId = ?";
		PreparedStatement pstm = null;
		try {

			pstm = conn.prepareStatement(sql);
			pstm.setString(1, employee.getEmpName());
			pstm.setNString(2, employee.getNumberPhone());
			pstm.setDate(3, Date.valueOf(employee.getBirthday()));
			pstm.setDate(4, Date.valueOf(employee.getStartDate()));
			pstm.setFloat(5, employee.getSalary());
			pstm.setNString(6, employee.getGender());
			pstm.setString(7, employee.getEmpId());
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void delete(String empId) {
		conn = ConnectDB.getConnect();
		String sql = "delete from EMPLOYEE where empId = ?";
		PreparedStatement pstm = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, empId);
			pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public Employee find(String empId) {
		conn = ConnectDB.getConnect();
		String sql = "select * from EMPLOYEE where empId = ?";
		PreparedStatement pstm = null;
		Employee emp = new Employee();
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, empId);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				emp.setEmpId(rs.getString("empId"));
				emp.setEmpName(rs.getNString("empName"));
				emp.setNumberPhone(rs.getString("numberPhone"));
				emp.setBirthday(rs.getDate("birthday").toLocalDate());
				emp.setIngUrl(rs.getString("imgUrl"));
				emp.setStartDate(rs.getDate("startDate").toLocalDate());
				emp.setSalary(rs.getFloat("salary"));
				emp.setGender(rs.getNString("gender"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// TODO: handle finally clause
			try {
				pstm.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return emp;
	}

	public int getCount() {
		conn = ConnectDB.getConnect();
		String sql = "select count(*) from EMPLOYEE";
		PreparedStatement pstm = null;
		ResultSet rs = null;
		int count = 0;
		try {
			pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}

	public List<Employee> getAll() {
		conn = ConnectDB.getConnect();
		String sql = "select * from EMPLOYEE";
		PreparedStatement pstm = null;
		List<Employee> list = new ArrayList<Employee>();
		try {
			pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				String empId = rs.getString("empId");
				String empName = rs.getNString("empName");
				String numberPhone = rs.getString("numberPhone");
				LocalDate birthday = rs.getDate("birthday").toLocalDate();
				String imgUrl = rs.getString("imgUrl");
				LocalDate startDate = rs.getDate("startDate").toLocalDate();
				float salary = rs.getFloat("salary");
				String gender = rs.getNString("gender");
				Employee employee = new Employee(empId, empName, numberPhone, birthday, gender, startDate, salary);
				employee.setIngUrl(imgUrl);
				list.add(employee);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public List<Employee> getEmployees(int start, int recordPerPage) {
		conn = ConnectDB.getConnect();
		String sql = "select * from EMPLOYEE order by empId offset ? rows fetch next ? rows only";
		PreparedStatement pstm = null;
		List<Employee> list = new ArrayList<Employee>();
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, start);
			pstm.setInt(2, recordPerPage);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmpId(rs.getString("empId"));
				emp.setEmpName(rs.getNString("empName"));
				emp.setNumberPhone(rs.getString("numberPhone"));
				emp.setBirthday(rs.getDate("birthday").toLocalDate());
				emp.setIngUrl(rs.getString("imgUrl"));
				emp.setStartDate(rs.getDate("startDate").toLocalDate());
				emp.setSalary(rs.getFloat("salary"));
				emp.setGender(rs.getNString("gender"));
				emp.setIngUrl(rs.getString("imgUrl"));
				list.add(emp);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	public Account getAccount(String empId) {
		conn= ConnectDB.getConnect();
		String sql= "select * from EMPLOYEE inner join ACCOUNT on EMPLOYEE.accountId= MEMBER.accountId where memberId=?";
		PreparedStatement pst= null;
		Account account= new Account();
		try {
			pst= conn.prepareStatement(sql);
			pst.setString(1, empId);
			ResultSet rs= pst.executeQuery();
			if(rs.next()) {
				account.setAccountId(rs.getInt("accountId"));
				account.setAccountName(rs.getNString("accountName"));
				account.setPassword(Validate.getMd5(rs.getString("password")));
				account.setAccountType(rs.getString("accountType"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return account;
	}
	
	public Employee getEmployeeByAccountID(int accountId) {
		conn= ConnectDB.getConnect();
		String sql= "select * from EMPLOYEE inner join ACCOUNT on EMPLOYEE.accountId= MEMBER.accountId where ACCOUNT.accountId=?";
		PreparedStatement pst= null;
		Employee emp= new Employee();
		try {
			pst= conn.prepareStatement(sql);
			pst.setInt(1, accountId);
			ResultSet rs= pst.executeQuery();
			if(rs.next()) {
				emp.setEmpId(rs.getString("empId"));
				emp.setEmpName(rs.getNString("empName"));
				emp.setNumberPhone(rs.getString("numberPhone"));
				emp.setBirthday(rs.getDate("birthday").toLocalDate());
				emp.setIngUrl(rs.getString("imgUrl"));
				emp.setStartDate(rs.getDate("startDate").toLocalDate());
				emp.setSalary(rs.getFloat("salary"));
				emp.setGender(rs.getNString("gender"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return emp;
	}
	public List<Employee> getPT() {
		conn = ConnectDB.getConnect();
		String sql = "select * from EMPLOYEE inner join ACCOUNT on ACCOUNT.accountId= EMPLOYEE.accountId where accountType='PT'";
		PreparedStatement pstm = null;
		List<Employee> list = new ArrayList<Employee>();
		try {
			pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				String empId = rs.getString("empId");
				String empName = rs.getNString("empName");
				String numberPhone = rs.getString("numberPhone");
				LocalDate birthday = rs.getDate("birthday").toLocalDate();
				String imgUrl = rs.getString("imgUrl");
				LocalDate startDate = rs.getDate("startDate").toLocalDate();
				float salary = rs.getFloat("salary");
				String gender = rs.getNString("gender");
				Employee employee = new Employee(empId, empName, numberPhone, birthday, gender, startDate, salary);
				employee.setIngUrl(imgUrl);
				list.add(employee);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}

package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import model.bean.ClassGym;

public class ClassDao {
	private Connection conn;

	public void insert(ClassGym lopHoc) {
		conn = ConnectDB.getConnect();
		String sql = "Insert into CLASS (classId,className,packageId,empId,schedule,maxMember,dateStart,dateEnd,status,startTime) Values (?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, lopHoc.getClassId());
			pst.setNString(2, lopHoc.getClassName());
			pst.setString(3, lopHoc.getPackageId());
			pst.setString(4, lopHoc.getEmpId());
			pst.setString(5, lopHoc.getSchedule());
			pst.setInt(6, lopHoc.getMaxMember());
			pst.setDate(7, Date.valueOf(lopHoc.getDateStart()));
			pst.setDate(8, Date.valueOf(lopHoc.getDateEnd()));
			pst.setNString(9, lopHoc.getStatus());
			pst.setTime(10, Time.valueOf(lopHoc.getStartTime()));
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public List<ClassGym> getClassOpen() {
		conn = ConnectDB.getConnect();
		String sql = "SELECT classId, className, packageId, empName, schedule, maxMember, dateStart, dateEnd, status, startTime"
				+ " FROM CLASS inner join EMPLOYEE on CLASS.empId= EMPLOYEE.empId where status=N'Đang mở'";
		List<ClassGym> listClass = new ArrayList<ClassGym>();
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			ResultSet resultSet = pst.executeQuery();
			while (resultSet.next()) {
				ClassGym lop = new ClassGym();
				lop.setClassId(resultSet.getString("classId"));
				lop.setClassName(resultSet.getNString("className"));
				lop.setPackageId(resultSet.getString("packageId"));
				lop.setEmpId(resultSet.getNString("empName"));
				lop.setSchedule(resultSet.getString("schedule"));
				lop.setMaxMember(resultSet.getInt("maxMember"));
				lop.setDateStart(resultSet.getDate("dateStart").toLocalDate());
				lop.setDateEnd(resultSet.getDate("dateEnd").toLocalDate());
				lop.setStatus(resultSet.getNString("status"));
				lop.setStartTime(resultSet.getTime("startTime").toLocalTime());
				listClass.add(lop);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listClass;
	}

	public void update(ClassGym lop) {
		conn = ConnectDB.getConnect();
		String sql = "UPDATE CLASS SET className = ?, packageId = ?, empId = ?, schedule = ?, maxMember = ?, dateStart = ?, dateEnd = ?,status = ?,startTime = ? WHERE classId = ?";
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setNString(1, lop.getClassName());
			pst.setString(2, lop.getPackageId());
			pst.setString(3, lop.getEmpId());
			pst.setNString(4, lop.getSchedule());
			pst.setInt(5, lop.getMaxMember());
			pst.setDate(6, Date.valueOf(lop.getDateStart()));
			pst.setDate(7, Date.valueOf(lop.getDateEnd()));
			pst.setNString(8, lop.getStatus());
			pst.setTime(9, Time.valueOf(lop.getStartTime()));
			pst.setString(10, lop.getClassId());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void deleteById(String classId) {
		conn = ConnectDB.getConnect();
		String sql = "DELETE FROM CLASS where classId = ?";
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, classId);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public List<ClassGym> getClassList(int start, int recordPerPage) {
		conn = ConnectDB.getConnect();
		String sql = String.format("SELECT * " + " FROM CLASS "
				+ "order by classId offset %d rows fetch next %d rows only", start, recordPerPage);
		List<ClassGym> listClasses = new ArrayList<ClassGym>();
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			ResultSet resultSet = pst.executeQuery();
			while (resultSet.next()) {
				ClassGym lop = new ClassGym();
				lop.setClassId(resultSet.getString("classId"));
				lop.setClassName(resultSet.getNString("className"));
				lop.setPackageId(resultSet.getString("packageId"));
				lop.setEmpId(resultSet.getString("empId"));
				lop.setSchedule(resultSet.getString("schedule"));
				lop.setMaxMember(resultSet.getInt("maxMember"));
				lop.setDateStart(resultSet.getDate("dateStart").toLocalDate());
				lop.setDateEnd(resultSet.getDate("dateEnd").toLocalDate());
				lop.setStatus(resultSet.getNString("status"));
				lop.setStartTime(resultSet.getTime("startTime").toLocalTime());
				listClasses.add(lop);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listClasses;
	}

	public int numberOfRecords() {
		conn = ConnectDB.getConnect();
		PreparedStatement pst = null;
		int row = 0;
		try {
			pst = conn.prepareStatement("select count(*) from CLASS");
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				row = rs.getInt(1);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return row;

	}

	public ClassGym searchById(String classId) {
		conn = ConnectDB.getConnect();
		String sql = "select * from CLASS where classId =?";
		PreparedStatement pst= null;
		ResultSet resultSet = null;
		ClassGym lop = null;
		try {
			pst= conn.prepareStatement(sql);
			pst.setString(1, classId);
			resultSet = pst.executeQuery();
			if (resultSet.next()) {
				lop = new ClassGym();
				lop.setClassId(resultSet.getString("classId"));
				lop.setClassName(resultSet.getNString("className"));
				lop.setPackageId(resultSet.getString("packageId"));
				lop.setEmpId(resultSet.getString("empId"));
				lop.setSchedule(resultSet.getString("schedule"));
				lop.setMaxMember(resultSet.getInt("maxMember"));
				lop.setDateStart(resultSet.getDate("dateStart").toLocalDate());
				lop.setDateEnd(resultSet.getDate("dateEnd").toLocalDate());
				lop.setStatus(resultSet.getNString("status"));
				lop.setStartTime((resultSet.getTime("startTime")).toLocalTime());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return lop;
	}
	
	public int getMaxMember(String classId) {
		conn= ConnectDB.getConnect();
		String sql="select maxMember\r\n" + 
				"from CLASS\r\n" + 
				"where CLASS.classId=?";
		PreparedStatement pst= null;
		int result = 0;
		try {
			pst= conn.prepareStatement(sql);
			pst.setString(1, classId);
			ResultSet rs= pst.executeQuery();
			if(rs.next()) {
				result= rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public String getClassId(String className) {
		conn= ConnectDB.getConnect();
		String sql="select classId\r\n" + 
				"from CLASS\r\n" + 
				"where className=?";
		PreparedStatement pst= null;
		String result = null;
		try {
			pst= conn.prepareStatement(sql);
			pst.setNString(1, className);
			ResultSet rs= pst.executeQuery();
			if(rs.next()) {
				result= rs.getString(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public List<ClassGym> getAll() {
		conn = ConnectDB.getConnect();
		List<ClassGym> listClasses = new ArrayList<ClassGym>();
		String sql="select * from CLASS";
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			ResultSet resultSet = pst.executeQuery();
			while (resultSet.next()) {
				ClassGym lop = new ClassGym();
				lop.setClassId(resultSet.getString("classId"));
				lop.setClassName(resultSet.getNString("className"));
				lop.setPackageId(resultSet.getString("packageId"));
				lop.setEmpId(resultSet.getString("empId"));
				lop.setSchedule(resultSet.getString("schedule"));
				lop.setMaxMember(resultSet.getInt("maxMember"));
				lop.setDateStart(resultSet.getDate("dateStart").toLocalDate());
				lop.setDateEnd(resultSet.getDate("dateEnd").toLocalDate());
				lop.setStatus(resultSet.getNString("status"));
				lop.setStartTime(resultSet.getTime("startTime").toLocalTime());
				listClasses.add(lop);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listClasses;
	}
	
	
}

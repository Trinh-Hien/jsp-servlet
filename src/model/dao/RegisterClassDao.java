package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.bean.RegisterClass;

/**
 * RegisterClassDao.java
 * 
 * Version
 * 
 * Date: 03-05-2020
 *
 * Copyright
 * 
 * Modification Logs: DATE AUTHOR DESCRIPTION
 * ------------------------------------------------------ 03-05-2020 HienTT20
 * Create
 */
public class RegisterClassDao {
	private Connection conn;

	public int getnumberRegisted(String classId) {
		conn = ConnectDB.getConnect();
		String sql = "select COUNT(memberId) as SoLuong\r\n"
				+ "from CLASS inner join REGISTER_CLASS on CLASS.classId= REGISTER_CLASS.classId\r\n"
				+ "where CLASS.classId=?\r\n" + "group by CLASS.classId,className";
		PreparedStatement pst = null;
		int result = 0;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, classId);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
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
		return result;
	}

	public void insert(RegisterClass class1) {
		conn = ConnectDB.getConnect();
		String sql = "insert into REGISTER_CLASS VALUES(?,?,?,?)";
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, class1.getMemberId());
			pst.setString(2, class1.getClassId());
			pst.setDate(3, Date.valueOf(class1.getRegisterDate()));
			pst.setNString(4, class1.getPayStatus());
			pst.executeUpdate();
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
	}

	public List<RegisterClass> getAll() {
		conn = ConnectDB.getConnect();
		String sql = "select * from REGISTER_CLASS";
		List<RegisterClass> list = new ArrayList<RegisterClass>();
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				RegisterClass registerClass = new RegisterClass();
				registerClass.setMemberId(rs.getInt("memberId"));
				registerClass.setClassId(rs.getString("classId"));
				registerClass.setRegisterDate(rs.getDate("registerDate").toLocalDate());
				registerClass.setPayStatus(rs.getNString("payStatus"));
				list.add(registerClass);
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
		return list;

	}

	public List<List<String>> getDetail(int memberId) {
		conn = ConnectDB.getConnect();
		String sql = "select className, registerDate,dateStart,maxMember,price, payStatus\r\n"
				+ "from CLASS inner join REGISTER_CLASS on CLASS.classId= REGISTER_CLASS.classId inner join PACKAGE on PACKAGE.packageId=CLASS.packageId\r\n"
				+ "where memberId= ?";
		List<List<String>> list = new ArrayList<List<String>>();
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, memberId);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				List<String> element = new ArrayList<String>();
				element.add(rs.getNString("className"));
				element.add(rs.getDate("registerDate").toString());
				element.add(rs.getDate("dateStart").toString());
				element.add(Integer.toString(rs.getInt("maxMember")));
				element.add(Integer.toString(rs.getInt("price")));
				element.add(rs.getNString("payStatus"));
				list.add(element);
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
		return list;
	}

	public void delete(String classId, int memberId) {
		conn = ConnectDB.getConnect();
		String sql = "delete from REGISTER_CLASS where classId=? and memberId=?";
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, classId);
			pst.setInt(2, memberId);
			pst.executeUpdate();
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
	}

	public void update(RegisterClass registerClass) {
		conn = ConnectDB.getConnect();
		String sql = "update REGISTER_CLASS set registerDate=?,payStatus=? where classId=? and memberId=?";
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setDate(1, Date.valueOf(registerClass.getRegisterDate()));
			pst.setNString(2, registerClass.getPayStatus());
			pst.setString(3, registerClass.getClassId());
			pst.setInt(4, registerClass.getMemberId());
			pst.executeUpdate();
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

	}

	public RegisterClass getRegisterClass(int memberId, String classId) {
		conn = ConnectDB.getConnect();
		String sql = "select * from REGISTER_CLASS where classId=? and memberId=?";
		PreparedStatement pst = null;
		RegisterClass registerClass = new RegisterClass();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, classId);
			pst.setInt(2, memberId);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				registerClass.setMemberId(rs.getInt("memberId"));
				registerClass.setClassId(rs.getString("classId"));
				registerClass.setRegisterDate(rs.getDate("registerDate").toLocalDate());
				registerClass.setPayStatus(rs.getNString("payStatus"));
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
		return registerClass;
	}

}

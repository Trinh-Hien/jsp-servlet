package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.bean.RegisterService;

/**
 * RegisterServiceDao.java
 * 
 * Version
 * 
 * Date: 02-05-2020
 *
 * Copyright
 * 
 * Modification Logs: DATE AUTHOR DESCRIPTION
 * ------------------------------------------------------ 02-05-2020 HienTT20
 * Create
 */
public class RegisterServiceDao {
	private Connection conn;

	public List<List<String>> getService(int accountId) {
		conn = ConnectDB.getConnect();
		String sql = "select serviceName, timeOfPurchase, amount, status\r\n"
				+ "from ACCOUNT inner join MEMBER on ACCOUNT.accountId= MEMBER.accountId \r\n"
				+ "inner join REGISTER_SERVICE on MEMBER.memberId= REGISTER_SERVICE.memberId\r\n"
				+ "inner join SERVICE on SERVICE.serviceId= REGISTER_SERVICE.serviceId\r\n"
				+ "where ACCOUNT.accountId= ?";
		PreparedStatement pst = null;
		List<List<String>> result = new ArrayList<List<String>>();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, accountId);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				List<String> element = new ArrayList<String>();
				element.add(rs.getNString("serviceName"));
				element.add(rs.getDate("timeOfPurchase").toString());
				element.add(Integer.toString(rs.getInt("amount")));
				element.add(rs.getNString("status"));
				result.add(element);
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

	public void insertRegisterService(RegisterService service) {
		conn = ConnectDB.getConnect();
		String sql = "insert into REGISTER_SERVICE values(?,?,?,?,?)";
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, service.getServiceId());
			pst.setInt(2, service.getMemberId());
			pst.setDate(3, Date.valueOf(service.getTimeOfPurchase()));
			pst.setInt(4, service.getAmount());
			pst.setNString(5, service.getStatus());
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

	public List<RegisterService> getAll() {
		conn = ConnectDB.getConnect();
		List<RegisterService> list = new ArrayList<RegisterService>();
		String sql = "SELECT registerServiceId, serviceId, memberId, timeOfPurchase, amount,status FROM REGISTER_SERVICE ";
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			ResultSet resultSet = pst.executeQuery();
			while (resultSet.next()) {
				RegisterService registerService;
				registerService = new RegisterService();
				registerService.setRegisterServiceId(resultSet.getInt("registerServiceId"));
				registerService.setServiceId(resultSet.getString("serviceId"));
				registerService.setMemberId(resultSet.getInt("memberId"));
				registerService.setTimeOfPurchase(resultSet.getDate("timeOfPurchase").toLocalDate());
				registerService.setAmount(resultSet.getInt("amount"));
				registerService.setStatus(resultSet.getNString("status"));
				list.add(registerService);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;

	}

	public void delete(int id) {
		conn = ConnectDB.getConnect();
		String sql = "delete from REGISTER_SERVICE where registerServiceId = ?";
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
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

	public RegisterService getById(int id) {
		conn = ConnectDB.getConnect();
		RegisterService registerService = new RegisterService();
		String sql = "SELECT * FROM REGISTER_SERVICE where registerServiceId=?";
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet resultSet = pst.executeQuery();
			if (resultSet.next()) {
				registerService.setRegisterServiceId(resultSet.getInt("registerServiceId"));
				registerService.setServiceId(resultSet.getString("serviceId"));
				registerService.setMemberId(resultSet.getInt("memberId"));
				registerService.setTimeOfPurchase(resultSet.getDate("timeOfPurchase").toLocalDate());
				registerService.setAmount(resultSet.getInt("amount"));
				registerService.setStatus(resultSet.getNString("status"));
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

		return registerService;
	}

	public void update(RegisterService rs) {
		conn = ConnectDB.getConnect();
		String sql = "update REGISTER_SERVICE set serviceId=?, memberId=?, timeOfPurchase=?, amount=?, status=? where registerServiceId=?";
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, rs.getServiceId());
			pst.setInt(2, rs.getMemberId());
			pst.setDate(3, Date.valueOf(rs.getTimeOfPurchase()));
			pst.setInt(4, rs.getAmount());
			pst.setNString(5, rs.getStatus());
			pst.setInt(6, rs.getRegisterServiceId());
			pst.executeUpdate();
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
		
	}
}

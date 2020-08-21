package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.bean.Account;
import model.bean.Member;

/**
 * CommonDao.java
 * 
 * Version
 * 
 * Date: 30-04-2020
 *
 * Copyright
 * 
 * Modification Logs: 
 * DATE			 AUTHOR			 DESCRIPTION
 * ------------------------------------------------------ 
 * 30-04-2020 		HienTT20     Create
 */
public class CommonDao {
	private static Connection conn;

	public void registerMember(Account account, Member member) throws SQLException{
		conn = ConnectDB.getConnect();
		String insertAccount = "insert into ACCOUNT(accountName,password,accountType) values(?,?,?)";
		String selectAccount="select accountId from Account where accountName= ?";
		String insertMember = "insert into MEMBER(fullName, birthday, gender, numberPhone, imgUrl, address,accountId) values (?,?,?,?,?,?,?)";
		PreparedStatement insertAcc = null;
		PreparedStatement insertMem = null;
		PreparedStatement select= null;
		int accountId = 0;
		try {
			conn.setAutoCommit(false);
			insertAcc = conn.prepareStatement(insertAccount);
			insertAcc.setString(1, account.getAccountName());
			insertAcc.setString(2, account.getPassword());
			insertAcc.setString(3, account.getAccountType());
			insertAcc.executeUpdate();
			
			select= conn.prepareStatement(selectAccount);
			select.setString(1, account.getAccountName());
			ResultSet rs= select.executeQuery();
			if(rs.next()) {
				accountId= rs.getInt(1);
			}
			
			insertMem = conn.prepareStatement(insertMember);
			insertMem.setNString(1, member.getFullName());
			insertMem.setDate(2, Date.valueOf(member.getBirthday()));
			insertMem.setNString(3, member.getGender());
			insertMem.setString(5, member.getImgUrl());
			insertMem.setString(4, member.getNumberPhone());
			insertMem.setNString(6, member.getAddress());
			insertMem.setInt(7, accountId);
			insertMem.executeUpdate();
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
				insertAcc.close();
				insertMem.close();
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

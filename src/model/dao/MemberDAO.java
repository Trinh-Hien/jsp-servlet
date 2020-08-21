package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.bean.Member;

public class MemberDAO {
	private Connection conn;

	public Member getMemberByAccount(int accountId) {
		conn = ConnectDB.getConnect();
		String sql = "select * from MEMBER where accountId= ?";
		PreparedStatement pstm = null;
		Member member = new Member();
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, accountId);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				member.setMemberId(rs.getInt("memberId"));
				member.setFullName(rs.getNString("fullName"));
				member.setBirthday(rs.getDate("birthday").toLocalDate());
				member.setAddress(rs.getNString("address"));
				member.setGender(rs.getNString("gender"));
				member.setImgUrl(rs.getString("imgUrl"));
				member.setNumberPhone(rs.getString("numberPhone"));
				member.setMemberId(rs.getInt("memberId"));
			}
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

		return member;
	}

	public void update(Member member) {
		conn = ConnectDB.getConnect();
		PreparedStatement pstm = null;
		String sql = "update MEMBER set fullName= ?, birthday= ?, gender= ?, numberPhone= ?, address=? where memberId =?";

		try {
			pstm = conn.prepareStatement(sql);
			pstm.setNString(1, member.getFullName());
			pstm.setDate(2, Date.valueOf(member.getBirthday()));
			pstm.setNString(3, member.getGender());
			pstm.setString(5, member.getAddress());
			pstm.setString(4, member.getNumberPhone());
			pstm.setInt(6, member.getMemberId());
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

	public int numberOfRecord() {
		conn = ConnectDB.getConnect();
		String sql = "select count(*) from MEMBER";
		PreparedStatement pst = null;
		int result = 0;
		try {
			pst = conn.prepareStatement(sql);
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

	public List<Member> getMember(int start, int recordPerPage) {
		conn = ConnectDB.getConnect();
		String sql = "select * from MEMBER order by memberId offset ? rows fetch next ? rows only";
		List<Member> members = new ArrayList<Member>();
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, start);
			pst.setInt(2, recordPerPage);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Member member = new Member();
				member.setMemberId(rs.getInt("memberId"));
				member.setFullName(rs.getNString("fullName"));
				member.setBirthday(rs.getDate("birthday").toLocalDate());
				member.setAddress(rs.getNString("address"));
				member.setNumberPhone(rs.getString("numberPhone"));
				member.setGender(rs.getNString("gender"));
				member.setImgUrl(rs.getString("imgUrl"));
				member.setAccountId(rs.getInt("accountId"));
				members.add(member);
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
		return members;
	}

	public Member getMemberByMemberId(int memberId) {
		conn = ConnectDB.getConnect();
		String sql = "select * from MEMBER where memberId= ?";
		PreparedStatement pstm = null;
		Member member = new Member();
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, memberId);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				member.setMemberId(rs.getInt("memberId"));
				member.setFullName(rs.getNString("fullName"));
				member.setBirthday(rs.getDate("birthday").toLocalDate());
				member.setAddress(rs.getNString("address"));
				member.setGender(rs.getNString("gender"));
				member.setNumberPhone(rs.getString("numberPhone"));
				member.setMemberId(rs.getInt("memberId"));
				member.setAccountId(rs.getInt("accountId"));
			}
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

		return member;
	}

}

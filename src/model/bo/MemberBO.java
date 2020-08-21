package model.bo;

import java.util.List;

import model.bean.Member;
import model.dao.MemberDAO;

/**
 * MemberBO.java
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
public class MemberBO {
	private MemberDAO dao = new MemberDAO();

	public Member getMemberByAccountId(int accountId) {
		return dao.getMemberByAccount(accountId);
	}
	public void update(Member member) {
		dao.update(member);
	}
	public int numberOfRecord() {
		return dao.numberOfRecord();
	}
	public List<Member> getPagination(int start, int recordPerPage){
		return dao.getMember(start,recordPerPage);
	}
	public Member getMemberByMemberId(int memberId) {
		return dao.getMemberByMemberId(memberId);
	}
}

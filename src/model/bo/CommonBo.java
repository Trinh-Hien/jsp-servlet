package model.bo;

import java.sql.SQLException;

import model.bean.Account;
import model.bean.Member;
import model.dao.CommonDao;

/**
 * CommonBo.java
 * 
 * Version
 * 
 * Date: 30-04-2020
 *
 * Copyright
 * 
 * Modification Logs:
 * DATE               AUTHOR          DESCRIPTION				
 * ------------------------------------------------------			
 * 30-04-2020            HienTT20          Create				
 */
public class CommonBo {
	CommonDao dao= new CommonDao();
	public void registerAccount(Account account, Member member) throws SQLException {
		dao.registerMember(account, member);
	}

}



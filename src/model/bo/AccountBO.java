package model.bo;

import java.util.List;

import model.bean.Account;
import model.dao.AccountDao;

public class AccountBO {
	private AccountDao accountDao = new AccountDao();

	public List<Account> getAllAccounts() {
		return accountDao.getAllAccount();
	}

	public List<Account> getAccounts(int start, int recordPerPage) {
		return accountDao.getAccounts(start, recordPerPage);
	}

	public int numberOfRecord() {
		return accountDao.numberOfRecord();
	}

	public Account getAccount(int accountId) {
		return accountDao.getAccount(accountId);
	}

	public boolean insertAccount(Account account) {
		return accountDao.insertAccount(account);
	}

	public boolean updateAccount(Account account) {
		return accountDao.updateAccount(account);
	}

	public boolean deleteAccount(int accountId) {
		return accountDao.delete(accountId);
	}

	public Account getAccount(String userName, String password) {
		return accountDao.getAccount(userName, password);
	}

	public List<String> getAccountName() {
		return accountDao.getAccountName();
	}

}

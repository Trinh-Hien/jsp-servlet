package model.bean;

/**
 * @author dat18
 *
 */
public class Account {
	private int accountId;
	private String accountName;
	private String password;
	private String accountType;

	public Account() {
	}

	public Account(String accountName, String password, String accountType) {
		super();
		this.accountName = accountName;
		this.password = password;
		this.accountType = accountType;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountName=" + accountName + ", password=" + password
				+ ", accountType=" + accountType + "]";
	}

}

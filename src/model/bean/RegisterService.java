package model.bean;

import java.time.LocalDate;

public class RegisterService {

	private int registerServiceId;
	private String serviceId;
	private int memberId;
	private LocalDate timeOfPurchase;
	private int amount;
	private String status;

	public RegisterService() {
		// TODO Auto-generated constructor stub
	}

	public RegisterService(int registerServiceId, String serviceId, int memberId, LocalDate timeOfPurchase, int amount,
			String status) {
		super();
		this.registerServiceId = registerServiceId;
		this.serviceId = serviceId;
		this.memberId = memberId;
		this.timeOfPurchase = timeOfPurchase;
		this.amount = amount;
		this.status = status;
	}

	public RegisterService(String serviceId, int memberId, LocalDate timeOfPurchase, int amount, String status) {
		super();
		this.serviceId = serviceId;
		this.memberId = memberId;
		this.timeOfPurchase = timeOfPurchase;
		this.amount = amount;
		this.status = status;
	}

	public int getRegisterServiceId() {
		return registerServiceId;
	}

	public void setRegisterServiceId(int registerServiceId) {
		this.registerServiceId = registerServiceId;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public LocalDate getTimeOfPurchase() {
		return timeOfPurchase;
	}

	public void setTimeOfPurchase(LocalDate timeOfPurchase) {
		this.timeOfPurchase = timeOfPurchase;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

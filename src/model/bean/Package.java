package model.bean;

public class Package {
	private String packageId;
	private String packageName;
	private String packageType;
	private float price;

	public Package() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Package(String packageId, String packageName, String packageType, float price) {
		super();
		this.packageId = packageId;
		this.packageName = packageName;
		this.packageType = packageType;
		this.price = price;
	}

	public String getPackageId() {
		return packageId;
	}

	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getPackageType() {
		return packageType;
	}

	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
}

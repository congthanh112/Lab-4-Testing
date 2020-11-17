
public class Laptop {
	private String serial;
	private double price;
	private String model;
	private String branch;
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public Laptop(String serial, double price, String model, String branch) {
		this.serial = serial;
		this.price = price;
		this.model = model;
		this.branch = branch;
	}
}

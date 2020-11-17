

	
	public class Cust {
		
		private Long id;
		private String name;
		private String address;
		private String licenseNumber;
		
		public Cust(Long id, String name, String address, String licenseNumber) {
			this.id = id;
			this.name = name;
			this.address = address;
			this.licenseNumber = licenseNumber;
		}
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getLicenseNumber() {
			return licenseNumber;
		}
		public void setLicenseNumber(String licenseNumber) {
			this.licenseNumber = licenseNumber;
		}		
	}



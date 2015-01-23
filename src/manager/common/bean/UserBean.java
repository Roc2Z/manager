package manager.common.bean;

public class UserBean {
	private int id;
	
	private String name;
	
	private String address;
	
	private String city;
	
	private String phone;
	
	private String email;

	public int getId() {
		return id;
	}

	public void setId(String id) {
		this.id = Integer.valueOf(id);
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}

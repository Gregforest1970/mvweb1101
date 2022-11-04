package model;

public class User {
    String userName,phone,address;

    public User() {}
	public User(String userName, String phone, String address) {
		
		this.userName = userName;
		this.phone = phone;
		this.address = address;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", phone=" + phone + ", address=" + address + "]";
	}
    
}

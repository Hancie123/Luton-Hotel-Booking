package Libs;

//Author: Hancie Phago


public class CustomerLibs2 {
	
	int Registration_ID;
	String Title;
	String Name;
	String Address;
	long   Mobile;
	String Email;
	String Username;
	String Password;
	String Role;
	
	
	public CustomerLibs2() {
		
		this.Registration_ID = 0;
		this.Title = "";
		this.Name = "";
		this.Address = "";
		this.Mobile = 0;
		this.Email = "";
		this.Username = "";
		this.Password = "";
		this.Role = "";
		
	}
	
	public CustomerLibs2(int registration_ID, String title, String name, String address, long mobile, String email,
			String username, String password, String role) {
		
		this.Registration_ID = registration_ID;
		this.Title = title;
		this.Name = name;
		this.Address = address;
		this.Mobile = mobile;
		this.Email = email;
		this.Username = username;
		this.Password = password;
		this.Role = role;
		
	}

	public int getRegistration_ID() {
		return Registration_ID;
	}

	public void setRegistration_ID(int registration_ID) {
		Registration_ID = registration_ID;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public long getMobile() {
		return Mobile;
	}

	public void setMobile(long mobile) {
		Mobile = mobile;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	@Override
	public String toString() {
		return "CustomerLibs2 [Registration_ID=" + Registration_ID + ", Title=" + Title + ", Name=" + Name
				+ ", Address=" + Address + ", Mobile=" + Mobile + ", Email=" + Email + ", Username=" + Username
				+ ", Password=" + Password + ", Role=" + Role + "]";
	}

	
	
	
}
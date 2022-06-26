package Libs;

public class CustomerLibs {
	
	int Customer_ID;
	String Title;
	String Name;
	String Gender;
	String DOB;
	String Mobile;
	String Email;
	String Address;
	String Username;
	String Password;
	String Credit_Number;
	String Role;
	
	
	public CustomerLibs() {
		
		this.Customer_ID = 0;
		this.Title = "";
		this.Name = "";
		this.Gender = "";
		this.DOB = "";
		this.Mobile = "";
		this.Email = "";
		this.Address = "";
		this.Username = "";
		this.Password = "";
		this.Credit_Number = "";
		this.Role="";
	}
	
	
	public CustomerLibs(int customer_ID, String title, String name, String gender, String dOB, String mobile,
			String email, String address, String username, String password, String credit_Number, String role) {
		
		this.Customer_ID = customer_ID;
		this.Title = title;
		this.Name = name;
		this.Gender = gender;
		this.DOB = dOB;
		this.Mobile = mobile;
		this.Email = email;
		this.Address = address;
		this.Username = username;
		this.Password = password;
		this.Credit_Number = credit_Number;
		this.Role=role;
	}


	public int getCustomer_ID() {
		return Customer_ID;
	}


	public void setCustomer_ID(int customer_ID) {
		Customer_ID = customer_ID;
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


	public String getGender() {
		return Gender;
	}


	public void setGender(String gender) {
		Gender = gender;
	}


	public String getDOB() {
		return DOB;
	}


	public void setDOB(String dOB) {
		DOB = dOB;
	}


	public String getMobile() {
		return Mobile;
	}


	public void setMobile(String mobile) {
		Mobile = mobile;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
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


	public String getCredit_Number() {
		return Credit_Number;
	}


	public void setCredit_Number(String credit_Number) {
		Credit_Number = credit_Number;
	}


	public String getRole() {
		return Role;
	}


	public void setRole(String role) {
		Role = role;
	}


	@Override
	public String toString() {
		return "CustomerLibs [Customer_ID=" + Customer_ID + ", Title=" + Title + ", Name=" + Name + ", Gender=" + Gender
				+ ", DOB=" + DOB + ", Mobile=" + Mobile + ", Email=" + Email + ", Address=" + Address + ", Username="
				+ Username + ", Password=" + Password + ", Credit_Number=" + Credit_Number + ", Role=" + Role + "]";
	}


	

}

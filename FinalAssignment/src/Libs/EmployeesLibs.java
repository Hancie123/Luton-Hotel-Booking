package Libs;

public class EmployeesLibs {
	
	int ID;
	String Name;
	int Age;
	long Mobile;
	String Email;
	String Address;
	long Salary;
	String Department;
	
	public EmployeesLibs() {
		
		this.ID = 0;
		this.Name = "";
		this.Age = 0;
		this.Mobile = 0;
		this.Email = "";
		this.Address = "";
		this.Salary = 0;
		this.Department = "";
	}
	
	public EmployeesLibs(int iD, String name, int age, long mobile, String email, String address, long salary,
			String department) {
		
		ID = iD;
		Name = name;
		Age = age;
		Mobile = mobile;
		Email = email;
		Address = address;
		Salary = salary;
		Department = department;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
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

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public long getSalary() {
		return Salary;
	}

	public void setSalary(long salary) {
		Salary = salary;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	@Override
	public String toString() {
		return "EmployeesLibs [ID=" + ID + ", Name=" + Name + ", Age=" + Age + ", Mobile=" + Mobile + ", Email=" + Email
				+ ", Address=" + Address + ", Salary=" + Salary + ", Department=" + Department + "]";
	}
	
	

}

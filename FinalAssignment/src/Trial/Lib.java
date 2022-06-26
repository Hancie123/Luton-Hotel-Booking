package Trial;

public class Lib {
	
	int EmpID;
	String FirstName;
	String LastName;
	int Age;
	int DepartmentID;
	double Salary;
	
	public Lib() {
		
		EmpID = 0;
		FirstName = "";
		LastName = "";
		Age = 0;
		DepartmentID = 0;
		Salary = 0.0;
		
	}
	
	public Lib(int empID, String firstName, String lastName, int age, int departmentID, double salary) {
		super();
		EmpID = empID;
		FirstName = firstName;
		LastName = lastName;
		Age = age;
		DepartmentID = departmentID;
		Salary = salary;
	}

	public int getEmpID() {
		return EmpID;
	}

	public void setEmpID(int empID) {
		EmpID = empID;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public int getDepartmentID() {
		return DepartmentID;
	}

	public void setDepartmentID(int departmentID) {
		DepartmentID = departmentID;
	}

	public double getSalary() {
		return Salary;
	}

	public void setSalary(double salary) {
		Salary = salary;
	}
	
	

}

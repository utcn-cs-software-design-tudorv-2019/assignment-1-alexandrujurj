package data_access;

public class StudentProfile {
	
	int id;
	int studentId;
	
	String firstName;
	String lastName;
	
	String cnp;
	String address;
	
	String phone;
	String email;
	
	String group;
	
	public StudentProfile(int id, int studentId, String firstName, String lastName, String cnp, String address, String phone, String email,String group) {
		
		this.id=id;
		this.studentId=studentId;
		this.firstName=firstName;
		this.lastName=lastName;
		this.cnp=cnp;
		this.address=address;
		this.phone=phone;
		this.email=email;
		this.group=group;
		
	}
	
	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public int getId() {
		return this.id;
	}
	
	public int getStudentId() {
		return this.studentId;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	void setFirstName ( String firstName) {
		this.firstName=firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	void setLastName(String lastName) {
		this.lastName=lastName;
	}
	
	public String getCnp() {
		return this.cnp;
	}
	
	void setCnp(String cnp) {
		this.cnp=cnp;
	}
	
	public String getAddress() {
		return this.address;
	}
	
	void setAddress(String address) {
		this.address=address;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	void setPhone(String phone) {
		this.phone=phone;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	void setEmail(String email) {
		this.email=email;
	}
	
	
}

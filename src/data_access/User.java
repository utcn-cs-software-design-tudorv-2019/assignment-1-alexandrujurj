package data_access;



public class User {
	
	
	int id;
	String name;
	String password;
	String type;
	
	
	public User(int id,String name, String password,String type) {
		this.id=id;
		this.name = name;
		
		this.password = password;
		this.type=type;
		
	}
	
	void setId(int id ) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	void setName(String name) {
		
		this.name=name;
		
	}
	
	public String getName() {
		
		return this.name;
		
	}
	
	void setPassword(String password) {
		this.password=password;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	void setType(String type) {
		this.type=type;
	}
	
	public String getType() {
		return this.type;
	}
}

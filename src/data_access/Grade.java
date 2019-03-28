package data_access;

public class Grade {
	
	int id;
	
	int grade;
	
	public Grade (int id,int grade) {
		this.id=id;
		
		this.grade=grade;
	
	}
	
	public void setGrade(int grade) {
		
		this.grade=grade;
		
	}
	
public	int getGrade() {
		
		return this.grade;
		
	}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

}

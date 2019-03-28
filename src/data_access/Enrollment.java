package data_access;

public class Enrollment {
	
	int id;
	int idCourse;
	int idStudent;
	int grade;
	
	public Enrollment(int id, int idCourse, int idStudent, int grade) {
		
		this.id=id;
		this.idCourse=idCourse;
		this.idStudent=idStudent;
		this.grade=grade;
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdCourse() {
		return idCourse;
	}
	public void setIdCourse(int idCourse) {
		this.idCourse = idCourse;
	}
	public int getIdStudent() {
		return idStudent;
	}
	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int idGrade) {
		this.grade = grade;
	}
	
	

}

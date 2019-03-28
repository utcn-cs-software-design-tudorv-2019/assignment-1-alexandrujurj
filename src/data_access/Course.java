package data_access;



public class Course {

	int id;
	String teacherName;
	String courseName;
	
	public Course(int id, String teacherName, String courseName) {
		
		this.id=id;
		this.teacherName=teacherName;
		this.courseName=courseName;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	
	
	
	
	
}

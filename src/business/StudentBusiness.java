package business;

import java.util.ArrayList;
import java.util.Scanner;

import data_access.Course;
import data_access.CourseDAO;
import data_access.Enrollment;
import data_access.EnrollmentDAO;
import data_access.StudentProfile;
import data_access.StudentProfileDAO;
import data_access.UserDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StudentBusiness {

	StudentProfileDAO studentDAO = new StudentProfileDAO();

	EnrollmentDAO enrollment = new EnrollmentDAO();

	public void enrollStudent(StudentProfile stud, Course cour) {

		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		System.out.println(stud.getEmail() + " " + cour.getCourseName());
		enrollment.save(new Enrollment(0, cour.getId(), stud.getStudentId(), num));

	}

	public ObservableList<String> findEnrolledCourses(StudentProfile student) {
		ArrayList<Enrollment> enrollments = (new EnrollmentDAO()).findByIdStudent(student.getId());
		ObservableList<String> enrolledCourses = FXCollections.observableArrayList();

		for (Enrollment itr : enrollments) {
			System.out.println(itr);
			Course course = (new CourseDAO()).findById(itr.getIdCourse());

			enrolledCourses.add(itr.getId() + " " + course.getCourseName() + " Grade: " + itr.getGrade());
		}
		return enrolledCourses;
	}

	public void addStudent(int id, int idStudent, String firstName, String lastName, String cnp, String address,
			String phone, String email, String group) {

		studentDAO.save(new StudentProfile(id, idStudent, firstName, lastName, cnp, address, phone, email, group));

	}

	public void updateStudent(StudentProfile s, String firstName, String lastName, String cnp, String address,
			String phone, String email, String group) {

		String[] params = { firstName, lastName, cnp, address, phone, email, group };

		studentDAO.update(s, params);

	}

	public StudentProfile viewStudent(StudentProfile s) {

		System.out.println(s.getId());

		StudentProfile x = studentDAO.findById(s.getId());

		return x;

	}

	void deleteStudent(StudentProfile s) {
		studentDAO.delete(s);
	}

	public Course searchForCourse(String courseSession) {
		if (courseSession.isEmpty())
			return null;

		Course course = (new CourseDAO()).findByName(courseSession);
		return course;
	}

}

package test;

import javafx.application.Application;
import javafx.stage.Stage;
import presentation.Login;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import business.StudentBusiness;
import data_access.*;

public class test extends Application {

	
	public static void main(String[] args)  {
		
		//StudentProfile s = new StudentProfile(5,5,"","","","","","","");
		//System.out.println(new CourseDAO().findById(1).getCourseName());
		//new EnrollmentDAO().save(new Enrollment(0,5,5,7));
		//System.out.println(new StudentProfileDAO().findById(1).getFirstName());
		launch(args);
		
		
	}
	
	public void start(Stage primaryStage) throws Exception {
        new Login();
    }

}

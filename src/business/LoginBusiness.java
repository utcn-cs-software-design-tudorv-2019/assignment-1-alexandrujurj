package business;

import data_access.StudentProfile;
import data_access.StudentProfileDAO;
import data_access.User;
import data_access.UserDAO;

public class LoginBusiness {

	public User loginOperation(String userName,String password){
        UserDAO userDAO = new UserDAO();
        
        User user = userDAO.loginUser(userName,password);
        return user;
    }
	
	public StudentProfile loginAsStudent(int idUser){
        StudentProfileDAO studentDAO = new StudentProfileDAO();
        StudentProfile student = studentDAO.findById(idUser);
        return student;
    }

	
}

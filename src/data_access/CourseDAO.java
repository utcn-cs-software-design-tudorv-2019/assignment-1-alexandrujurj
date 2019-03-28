package data_access;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import data_access.Course;

public class CourseDAO implements AbstractDAO<Course>{
	
	Connection1 conn = new Connection1();

	@Override
	public ArrayList<Course> getAll() throws SQLException {
		// TODO Auto-generated method stub
		
		ArrayList<Course> aux = new ArrayList<Course>();
		
		Connection conect = conn.connect();
		String query = "SELECT * FROM `Course`";
        
        java.sql.Statement st = conect.createStatement();
        ResultSet rs = ((java.sql.Statement) st).executeQuery(query);
        
      
        
        
        while(rs.next()) {
       // Student stud = new Student();
	        
	        
	        Course stud = new Course(rs.getInt("id"),rs.getString("teacherName"),rs.getString("courseName"));
	        
	        aux.add(stud);
        }
        
        conect.close();
		return aux;
		
	}

	

	@Override
	public void save(Course t) {
		// TODO Auto-generated method stub
Connection conect = conn.connect();
		
		//String query = "INSERT INTO student_user (id, name, password)"+ " values ("+ t.id +",'"+ t.name +"', '"+ t.password +"')";
		
		
		
		 	String query = " insert into Course (id, teacherName, courseName)"
		        + " values (?, ?, ?)";

		      // create the mysql insert preparedstatement
		      PreparedStatement preparedStmt;
			try {
				preparedStmt = conect.prepareStatement(query);
			
			  preparedStmt.setInt    (1, t.id);
			  preparedStmt.setString (2, t.teacherName);
		      preparedStmt.setString (3, t.courseName);
		    
		      preparedStmt.close();
		      
		      preparedStmt.close();
		      conect.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			System.out.println(query);
		
	}

	@Override
	public void update(Course t, String[] params) {
		// TODO Auto-generated method stub
		
		Connection conect = conn.connect();
		try {
			
		
		 String query = "update Course set teacherName = ? , courseName = ? where id = ?" ;
		 
	      PreparedStatement preparedStmt = conect.prepareStatement(query);
	      
	      preparedStmt.setString(1, params[0]);
	      preparedStmt.setString(2, params[1]);
	      preparedStmt.setInt   (3, t.id);
	      // execute the java preparedstatement
	      preparedStmt.executeUpdate();
	      
	      preparedStmt.close();
	      conect.close();
	      
	      
	      
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }
		
	}

	@Override
	public void delete(Course t) {
		// TODO Auto-generated method stub
		Connection conect = conn.connect();
		
		try
	    {
	      // create the mysql database connection
	      // create the mysql delete statement.
	      // i'm deleting the row where the id is "3", which corresponds to my
	      // "Barney Rubble" record.
	      String query = "delete from Course where id ="+t.getId()+";";
	      PreparedStatement preparedStmt = conect.prepareStatement(query);
	      preparedStmt.setInt(1, t.id);

	      // execute the preparedstatement
	      preparedStmt.execute();
	      
	      preparedStmt.close();
	      conect.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }

		
	}



	@Override
	public Course findById(int id) {
		
		Connection conect = conn.connect();
		
		Course stud = new Course(0,"","");
		
		try
	    {
	      // create the mysql database connection
	      // create the mysql delete statement.
	      // i'm deleting the row where the id is "3", which corresponds to my
	      // "Barney Rubble" record.
	      String query = "SELECT * FROM Course where id ="+id+";";
	        
	        java.sql.Statement st = conect.createStatement();
	        ResultSet rs = ((java.sql.Statement) st).executeQuery(query);

	      // execute the preparedstatement
	        if(rs.next())
	        stud = new Course(rs.getInt("id"),rs.getString("teacherName"),rs.getString("courseName"));
	         
	      conect.close();
	      
	     
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }
		return stud;

	}



	public Course findByName(String courseSession) {
		// TODO Auto-generated method stub
		
Connection conect = conn.connect();
		
		Course stud = null;
		
		try
	    {
	      // create the mysql database connection
	      // create the mysql delete statement.
	      // i'm deleting the row where the id is "3", which corresponds to my
	      // "Barney Rubble" record.
	      String query = "SELECT * FROM Course where courseName ='"+courseSession+"';";
	        
	        java.sql.Statement st = conect.createStatement();
	        ResultSet rs = ((java.sql.Statement) st).executeQuery(query);

	      // execute the preparedstatement
	        if(rs.next())
	        stud = new Course(rs.getInt("id"),rs.getString("teacherName"),rs.getString("courseName"));
	         
	      conect.close();
	      
	     
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }
		return stud;
	}
	
	
	
}

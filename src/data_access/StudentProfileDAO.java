package data_access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentProfileDAO implements AbstractDAO<StudentProfile> {

	Connection1 conn = new Connection1();
	
	@Override
	public ArrayList<StudentProfile> getAll() throws SQLException {
		
		ArrayList<StudentProfile> aux = new ArrayList<StudentProfile>();
		
		Connection conect = conn.connect();
		String query = "SELECT * FROM `student_profile`";
        
        java.sql.Statement st = conect.createStatement();
        ResultSet rs = ((java.sql.Statement) st).executeQuery(query);
        
    	
    	while (rs.next()) {
    		
    		
    		
    		StudentProfile stud = new StudentProfile (rs.getInt("id"),rs.getInt("StudentId"),rs.getString("FirstName"),
    				rs.getString("LastName"),rs.getString("Cnp"),rs.getString("Address"),rs.getString("Phone"),rs.getString("Email"),rs.getString("Groupx"));
    		
    		aux.add(stud);
    		
    	}
		
    	conect.close();
		// TODO Auto-generated method stub
		return aux;
	}

	@Override
	public void save(StudentProfile t) {
		// TODO Auto-generated method stub
		
		Connection conect = conn.connect();
		
		//String query = "INSERT INTO student_user (id, name, password)"+ " values ("+ t.id +",'"+ t.name +"', '"+ t.password +"')";
		
		
		
		 String query = " insert into student_profile (id, StudentId, FirstName,"
		 		+ " LastName,  Cnp, Address,Phone, Email, Groupx )"
		        + " values (?, ?, ?,?,?,?,?,?,?)";

		      // create the mysql insert preparedstatement
		      PreparedStatement preparedStmt;
			try {
				preparedStmt = conect.prepareStatement(query);
			
				preparedStmt.setInt    (1, t.getId());
				preparedStmt.setInt (2, t.getStudentId());
				preparedStmt.setString (3, t.getFirstName());
				preparedStmt.setString(4,t.getLastName());
				preparedStmt.setString(5,t.getCnp());
				preparedStmt.setString(6,t.getAddress());
				preparedStmt.setString(7,t.getPhone());
				preparedStmt.setString(8,t.getEmail());
				preparedStmt.setString(8,t.getGroup());
				
		    
		      preparedStmt.execute();
		      
		      conect.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			System.out.println(query);
		
	}


	@Override
	public void update(StudentProfile t, String[] params) {
		// TODO Auto-generated method stub
		
		Connection conect = conn.connect();
		try {
			
		
		 String query = "update student_profile set FirstName = ? , LastName = ?, Cnp=?, Address=?, Phone =? , Email=?, Groupx = ? where id = ?" ;
		 
	      PreparedStatement preparedStmt = conect.prepareStatement(query);
	      
	      preparedStmt.setString(1, params[0]);
	      preparedStmt.setString(2, params[1]);
	      preparedStmt.setString(3, params[2]);
	      preparedStmt.setString(4, params[3]);
	      preparedStmt.setString(5, params[4]);
	      preparedStmt.setString(6, params[5]);
	      preparedStmt.setString(7, params[6]);
	      preparedStmt.setInt   (8, t.id);
	      // execute the java preparedstatement
	      preparedStmt.executeUpdate();
	      
	      conect.close();
	      
	      
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }
		
	}

	@Override
	public void delete(StudentProfile t) {
		// TODO Auto-generated method stub
		Connection conect = conn.connect();
		
		try
	    {
	      // create the mysql database connection
	      // create the mysql delete statement.
	      // i'm deleting the row where the id is "3", which corresponds to my
	      // "Barney Rubble" record.
	      String query = "delete from student_profile where id = ?";
	      PreparedStatement preparedStmt = conect.prepareStatement(query);
	      preparedStmt.setInt(1, t.id);

	      // execute the preparedstatement
	      preparedStmt.execute();
	      
	      conect.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }

		
	}

	@Override
	public StudentProfile findById(int id) {
		
		Connection conect =conn.connect();
		
		StudentProfile stud = new StudentProfile(0,0,"","","","","","","");
		
		try
	    {
	      // create the mysql database connection
	      // create the mysql delete statement.
	      // i'm deleting the row where the id is "3", which corresponds to my
	      // "Barney Rubble" record.
	      String query = "SELECT * FROM student_profile where id ="+id+";";
	        
	        java.sql.Statement st = conect.createStatement();
	        ResultSet rs = ((java.sql.Statement) st).executeQuery(query);

	      // execute the preparedstatement
	        if(rs.next())
	        stud = new StudentProfile (rs.getInt("id"),rs.getInt("StudentId"),rs.getString("FirstName"),
    				rs.getString("LastName"),rs.getString("Cnp"),rs.getString("Address"),rs.getString("Phone"),rs.getString("Email"),rs.getString("Groupx"));
	         
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

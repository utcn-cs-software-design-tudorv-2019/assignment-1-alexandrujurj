package data_access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GradeDAO implements AbstractDAO<Grade> {
	
	Connection1 conn = new Connection1 ();

	@Override
	public ArrayList<Grade> getAll() throws SQLException {
		// TODO Auto-generated method stub
		ArrayList<Grade> aux = new ArrayList<Grade>();
		
		Connection conect = conn.connect();
		String query = "SELECT * FROM `Grade`";
        
        java.sql.Statement st = conect.createStatement();
        ResultSet rs = ((java.sql.Statement) st).executeQuery(query);
        
      
        
        
        while(rs.next()) {
       // Student stud = new Student();
	        
	        
	        Grade stud = new Grade(rs.getInt("id"),rs.getInt("grade"));
	        
	        aux.add(stud);
        }
        
        conect.close();
		return aux;
		
	}

	@Override
	public void save(Grade t) {
		// TODO Auto-generated method stub
		
		Connection conect = conn.connect();
		
		//String query = "INSERT INTO student_user (id, name, password)"+ " values ("+ t.id +",'"+ t.name +"', '"+ t.password +"')";
		
		
		
		 	String query = " insert into Grade (id, grade)"
		        + " values (?, ?)";

		      // create the mysql insert preparedstatement
		      PreparedStatement preparedStmt;
			try {
				preparedStmt = conect.prepareStatement(query);
			
			  preparedStmt.setInt (1, t.getId());
			  preparedStmt.setInt (2, t.getGrade());
		    
		      preparedStmt.execute();
		      conect.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			System.out.println(query);
		
	}

	@Override
	public void update(Grade t, String[] params) {
		// TODO Auto-generated method stub
		
		Connection conect = conn.connect();
		try {
			
		
		 String query = "update Grade set grade = ? where id = ?" ;
		 
	      PreparedStatement preparedStmt = conect.prepareStatement(query);
	      
	      preparedStmt.setInt(1, Integer.parseInt(params[0]));
	      preparedStmt.setInt   (2, t.getId());
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
	public void delete(Grade t) {
		// TODO Auto-generated method stub
		
		Connection conect = conn.connect();
		
		try
	    {
	      // create the mysql database connection
	      // create the mysql delete statement.
	      // i'm deleting the row where the id is "3", which corresponds to my
	      // "Barney Rubble" record.
	      String query = "delete from Grade where id = ?";
	      PreparedStatement preparedStmt = conect.prepareStatement(query);
	      preparedStmt.setInt(1, t.getId());

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
	public Grade findById(int id) {
		
		Connection conect = conn.connect();
		Grade stud = new Grade(0,0);
		
		try
	    {
	      // create the mysql database connection
	      // create the mysql delete statement.
	      // i'm deleting the row where the id is "3", which corresponds to my
	      // "Barney Rubble" record.
	      String query = "SELECT * FROM Grade where id = ?";
	        
	        java.sql.Statement st = conect.createStatement();
	        ResultSet rs = ((java.sql.Statement) st).executeQuery(query);

	      // execute the preparedstatement
	        if(rs.next())
	      stud = new Grade(rs.getInt("id"),rs.getInt("grade"));
	         
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

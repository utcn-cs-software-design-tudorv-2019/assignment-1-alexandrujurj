package data_access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EnrollmentDAO implements AbstractDAO<Enrollment> {
	
	Connection1 conn = new Connection1();

	@Override
	public ArrayList<Enrollment> getAll() throws SQLException {
		// TODO Auto-generated method stub
		
		ArrayList<Enrollment> aux = new ArrayList<Enrollment>();
		
		Connection conect = conn.connect();
		String query = "SELECT * FROM `Enrollment`";
        
        java.sql.Statement st = conect.createStatement();
        ResultSet rs = ((java.sql.Statement) st).executeQuery(query);
        
      
        
        
        while(rs.next()) {
       // Student stud = new Student();
	        
	        
	        Enrollment stud = new Enrollment(rs.getInt("id"),rs.getInt("idCourse"),rs.getInt("idStudent"),rs.getInt("grade"));
	        
	        aux.add(stud);
        }
        
        conect.close();
		return aux;
		
	}

	@Override
	public void save(Enrollment t) {
		// TODO Auto-generated method stub
		
		Connection conect = conn.connect();
		
		//String query = "INSERT INTO student_user (id, name, password)"+ " values ("+ t.id +",'"+ t.name +"', '"+ t.password +"')";
		
		
		
		 	String query = " insert into Enrollment (id, idCourse, idStudent, grade)"
		        + " values (?, ?,?,?)";

		      // create the mysql insert preparedstatement
		      PreparedStatement preparedStmt;
			try {
				preparedStmt = conect.prepareStatement(query);
			
			  preparedStmt.setInt (1, t.getId());
			  preparedStmt.setInt (2, t.getIdCourse());
			  preparedStmt.setInt (3, t.getIdStudent());
			  preparedStmt.setInt (4, t.getGrade());
		    
		      preparedStmt.execute();
		      conect.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			System.out.println(query);
		
	}

	@Override
	public void update(Enrollment t, String[] params) {
		// TODO Auto-generated method stub
		
		Connection conect = conn.connect();
		try {
			
		
		 String query = "update Enrollment set idCourse = ?, idStudent = ?, grade = ? where id = ?" ;
		 
	      PreparedStatement preparedStmt = conect.prepareStatement(query);
	      
	      preparedStmt.setInt(1, Integer.parseInt(params[0]));
	      preparedStmt.setInt(2, Integer.parseInt(params[1]));
	      preparedStmt.setInt(3, Integer.parseInt(params[2]));
	      preparedStmt.setInt   (4, t.getId());
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
	public void delete(Enrollment t) {
		// TODO Auto-generated method stub
		
Connection conect = conn.connect();
		
		try
	    {
	      // create the mysql database connection
	      // create the mysql delete statement.
	      // i'm deleting the row where the id is "3", which corresponds to my
	      // "Barney Rubble" record.
	      String query = "delete from Enrollment where id ="+t.getId()+";";
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
	public Enrollment findById(int id) {
Connection conect = conn.connect();
		
		Enrollment stud = new Enrollment(0,0,0,0);
		
		try
	    {
	      // create the mysql database connection
	      // create the mysql delete statement.
	      // i'm deleting the row where the id is "3", which corresponds to my
	      // "Barney Rubble" record.
	      String query = "SELECT * FROM Enrollment where id ="+id+";";
	        
	        java.sql.Statement st = conect.createStatement();
	        ResultSet rs = ((java.sql.Statement) st).executeQuery(query);

	      // execute the preparedstatement
	        if(rs.next())
	        stud = new Enrollment(rs.getInt("id"),rs.getInt("idCourse"),rs.getInt("idStudent"),rs.getInt("grade"));
	         
	      conect.close();
	      
	      
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }
		return stud;

	}

	
	public ArrayList<Enrollment> findByIdStudent(int id) {
		Connection conect = conn.connect();
		
		ArrayList<Enrollment> aux = new ArrayList<>();
		
		Enrollment stud = new Enrollment(0,0,0,0);
		
		try
	    {
	      // create the mysql database connection
	      // create the mysql delete statement.
	      // i'm deleting the row where the id is "3", which corresponds to my
	      // "Barney Rubble" record.
	      String query = "SELECT * FROM Enrollment where idStudent ="+id+";";
	        
	        java.sql.Statement st = conect.createStatement();
	        ResultSet rs = ((java.sql.Statement) st).executeQuery(query);

	      // execute the preparedstatement
	        while(rs.next()) {
	        stud = new Enrollment(rs.getInt("id"),rs.getInt("idCourse"),rs.getInt("idStudent"),rs.getInt("grade"));
	        aux.add(stud);
	        }
	      conect.close();
	      
	      
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }
		return aux;

	}

	
}

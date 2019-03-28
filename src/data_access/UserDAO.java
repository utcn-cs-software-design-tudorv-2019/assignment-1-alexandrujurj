package data_access;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO implements AbstractDAO<User>{
	
	Connection1 conn=new Connection1();

	@Override
	public ArrayList<User> getAll() throws SQLException {
		ArrayList<User> aux = new ArrayList<User>();
		Connection conect = conn.connect();
		String query = "SELECT * FROM `user`";
        
        java.sql.Statement st = conect.createStatement();
        ResultSet rs = ((java.sql.Statement) st).executeQuery(query);
        
      
        
        
        while(rs.next()) {
       // Student stud = new Student();
	        
	        
	        User stud = new User(rs.getInt("id"),rs.getString("name"),rs.getString("password"),rs.getString("type"));
	        
	        aux.add(stud);
        }
        
        conect.close();
		return aux;
		
		
	}

	@Override
	public void save(User t){
		// TODO Auto-generated method stub
		Connection conect = conn.connect();
		
		//String query = "INSERT INTO student_user (id, name, password)"+ " values ("+ t.id +",'"+ t.name +"', '"+ t.password +"')";
		
		
		
		 String query = " insert into user (id, name, password,type)"
		        + " values (?, ?, ?)";

		      // create the mysql insert preparedstatement
		      PreparedStatement preparedStmt;
			try {
				preparedStmt = conect.prepareStatement(query);
			
				  preparedStmt.setInt    (1, t.id);
				preparedStmt.setString (2, t.name);
		      preparedStmt.setString (3, t.password);
		      preparedStmt.setString (4, t.type);
		    
		      preparedStmt.execute();
		      conect.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			System.out.println(query);

	}

	@Override
	public void update(User t, String[] params) {
		// TODO Auto-generated method stub
		Connection conect = conn.connect();
		try {
			
		
		 String query = "update user set name = ? , password = ?, type = ? where id = ?" ;
		 
	      PreparedStatement preparedStmt = conect.prepareStatement(query);
	      
	      preparedStmt.setString(1, params[0]);
	      preparedStmt.setString(2, params[1]);
	      preparedStmt.setString(3, params[2]);
	      preparedStmt.setInt   (4, t.id);
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
	public void delete(User t) {
		// TODO Auto-generated method stub
		
Connection conect = conn.connect();
		
		try
	    {
	      // create the mysql database connection
	      // create the mysql delete statement.
	      // i'm deleting the row where the id is "3", which corresponds to my
	      // "Barney Rubble" record.
	      String query = "delete from user where id = ?";
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
	public User findById(int id) {

		Connection conect = conn.connect();
		User stud = null;
		
		try
	    {
	      // create the mysql database connection
	      // create the mysql delete statement.
	      // i'm deleting the row where the id is "3", which corresponds to my
	      // "Barney Rubble" record.
	      String query = "SELECT * FROM user where id ="+id+";";
	        
	        java.sql.Statement st = conect.createStatement();
	        ResultSet rs = ((java.sql.Statement) st).executeQuery(query);

	      // execute the preparedstatement
	        if(rs.next())
	        stud = new User(rs.getInt("id"),rs.getString("name"),rs.getString("password"),rs.getString("type"));
	         
	      conect.close();
	      
	     
	    }
	    catch (Exception e)
	    {
	      System.err.println("Got an exception! ");
	      System.err.println(e.getMessage());
	    }
		return stud;
	}
	
	public User loginUser(String userName, String password) {

		Connection conect = conn.connect();
		User stud = null;
		
		try
	    {
	      // create the mysql database connection
	      // create the mysql delete statement.
	      // i'm deleting the row where the id is "3", which corresponds to my
	      // "Barney Rubble" record.
	      String query = "SELECT * FROM user WHERE name = '" + userName + "' AND password = '" + password +"';";
	        
	        java.sql.Statement st = conect.createStatement();
	        ResultSet rs = ((java.sql.Statement) st).executeQuery(query);

	      // execute the preparedstatement
	        if(rs.next())
	        stud = new User(rs.getInt("id"),rs.getString("name"),rs.getString("password"),rs.getString("type"));
	         
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

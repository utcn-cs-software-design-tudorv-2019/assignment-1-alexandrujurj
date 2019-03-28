package data_access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connection1 {

	private String user = "jurj97";
	private String pass = "0racle123";
	private String dbClass = "com.mysql.cj.jdbc.Driver";
	private String dbDriver = "jdbc:mysql://db4free.net:3306/assignment1proj";
	private Connection conn = null;
	
	public Connection1() {}
	
	public Connection connect() {
	   
	    //load driver
	    try {
	        Class.forName(dbClass).newInstance();
	        System.out.println("driver loaded"); // THIS IS BEING RETURNED
	    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
	        System.err.println(ex);
	    }
	    // Connection
	    try {
	        conn = DriverManager.getConnection(dbDriver, user, pass);
	        System.out.println("connected"); // THIS IS NOT BEING RETURNED
	       
	    } catch (SQLException ex) {
	        System.out.println("SQLException: " + ex.getMessage());
	    }
	    return conn;
	}
	
}

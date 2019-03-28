package data_access;


import java.sql.SQLException;
import java.util.ArrayList;

public interface AbstractDAO<T> {
	
	ArrayList<T> getAll() throws SQLException;
	
	T findById(int id);
	
	void save(T t);
	
	void update(T t, String[] params);
	
	void delete(T t);	
	

}

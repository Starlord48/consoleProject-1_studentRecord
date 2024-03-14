package userDefinedCollections;
import java.sql.*;

public class DbConnection {
	static String url = "jdbc:mysql://localhost:3306/school";
	static String username = "root";
	static String password = "07@ug200One";
	
	public static Connection connectDatabase() throws SQLException, ClassNotFoundException {
			Class.forName("com.mysql.cj.jdbc.Driver");
	        return DriverManager.getConnection(url, username, password);
	}
}

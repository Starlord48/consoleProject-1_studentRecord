package userDefinedCollections;

import java.util.ArrayList;
import java.sql.*;
import java.util.*;

public class StudentManager {
	private static int studentId = 1;
	static List<Student> list = new ArrayList<>();

	
	public StudentManager() throws SQLException, ClassNotFoundException {

	}
	
	public static void addStudent(String studentName, int studentRoll, String studentCourse) throws ClassNotFoundException, SQLException {
		

		list.add(new Student(studentId++, studentName, studentRoll, studentCourse));
		
		String query = "INSERT INTO students (studentName, studentRoll, studentCourse)"
				+ " values(?,?,?)";
		Connection connection = DbConnection.connectDatabase();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		
		preparedStatement.setString(1, studentName);
		preparedStatement.setInt(2, studentRoll);
		preparedStatement.setString(3, studentCourse);
		preparedStatement.execute();
		connection.close();
	}
	public static Student getStudent(int id) throws ClassNotFoundException, SQLException {
//		for(int i=0; i<list.size();i++) {
//			if(id == list.get(i).getStudentID()) return list.get(i);
//		}
//		return null;
		String query = "SELECT * FROM students WHERE studentId="+id;
		Connection connection = DbConnection.connectDatabase();
		Statement statement=	connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		
		ResultSet resultSet =statement.executeQuery(query);
		//if(!(resultSet != null && resultSet.next())) return null;
		if(!resultSet.absolute(1)) return null;
		
		return new Student(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3), resultSet.getString(4));
		
	}
	
	public static boolean updateStudent(int id, String studentName, int studentRoll, String studentCourse) throws SQLException, ClassNotFoundException {
//		for(int i=0; i<list.size();i++) {
//			if(id == list.get(i).getStudentID()) {
//				list.get(i).setStudentName(studentName);
//				list.get(i).setStudentRoll(studentRoll);
//				list.get(i).setStudentCourse(studentCourse);
//				return true;
//			}
//		
//		}
//		return false;
		String query = "UPDATE students SET studentName = ? , studentRoll =? , studentCourse =?  WHERE studentId =?";
		Connection connection = DbConnection.connectDatabase();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, studentName);
        preparedStatement.setInt(2, studentRoll);
        preparedStatement.setString(3, studentCourse);
        preparedStatement.setInt(4, id);

		preparedStatement.executeUpdate();
		connection.close();
		return true;
	
	}
	
	public static boolean deleteStudent(int id) throws ClassNotFoundException, SQLException {
//		for(int i=0; i<list.size();i++) {
//			if(id == list.get(i).getStudentID()) {
//				list.remove(i); 
//				return true;
//			}
//		}
//		return false;
		
		String query = "DELETE FROM students WHERE studentId = ?";
		Connection connection = DbConnection.connectDatabase();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);

        preparedStatement.executeUpdate();
		connection.close();
		return true;
	}
}

//The exception you're encountering indicates that the ResultSet object you're working 
//with is of type ResultSet.TYPE_FORWARD_ONLY, which does not support the absolute() method.
//This type of ResultSet is typically the default type returned by JDBC when executing
//a query, especially if the statement is created without specifying a result set type explicitly.
//
//To use the absolute() method, you need to create a scrollable ResultSet. You can do 
//this by specifying the appropriate result set type when creating the Statement object. Here's how you can modify your code to create a scrollable ResultSet:

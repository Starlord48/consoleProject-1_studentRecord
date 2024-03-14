package userDefinedCollections;
import java.sql.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		//infinite loop to give a continous application feel in console
		while(true) {

			//Giving option to the user and getting input from user
			Scanner scan = new Scanner(System.in);
			System.out.println("Select an action to perform: \n\t1.addStudent\t2.getStudent\n\t3.updateStudent\t4.removeStudent");
			int option = scan.nextInt();
			scan.nextLine();
			int id; String name; int roll; String course;
			
			
			try {
				//switch case to serve a specific request from the user
				switch(option) {
				//Creation of new data
				case 1 : 
					System.out.println("Enter the name");
					name = scan.nextLine();
					System.out.println("Enter the roll");
					roll = scan.nextInt();
					scan.nextLine();
					System.out.println("Enter the course");
					course = scan.nextLine();
					StudentManager.addStudent( name, roll, course);
					System.out.println("Student added");
					break;
				//Retrival of an exsisting data
				case 2:
					System.out.println("Enter student ID");
					id = scan.nextInt();
					Student student = StudentManager.getStudent(id);
					if(student == null) System.out.println("NO STUDENT with ID "+id);
					else student.printStudent();
					break;
				//Editing of an exsisting data
				case 3: 
					System.out.println("Enter student ID");
					id = scan.nextInt();
					scan.nextLine();
					System.out.println("Enter the name");
					name = scan.nextLine();
					System.out.println("Enter the roll");
					roll = scan.nextInt();
					scan.nextLine();
					System.out.println("Enter the course");
					course = scan.nextLine();
					if(StudentManager.updateStudent(id, name, roll, course))
						System.out.println("Student is UPDATED");
					else  
						System.out.println("NO STUDENT with ID "+id);
					break;
				//Deletion of an exsisting data
				case 4:
					System.out.println("Enter student ID");
					id = scan.nextInt();
					scan.nextLine();
					if(StudentManager.deleteStudent(id)) System.out.println("Successfully deleted");
					else System.out.println("NO STUDENT with ID "+id);
					break;		
				default :
					System.out.println("Not an valid Option");
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

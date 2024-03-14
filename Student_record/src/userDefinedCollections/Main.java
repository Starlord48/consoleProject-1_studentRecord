package userDefinedCollections;
import java.sql.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		
		while(true) {

			Scanner scan = new Scanner(System.in);
			System.out.println("Select an action to perform: \n\t1.addStudent\t2.getStudent\n\t3.updateStudent\t4.removeStudent");
			int option = scan.nextInt();
			scan.nextLine();
			int id; String name; int roll; String course;
			
			
			try {
				switch(option) {
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
				case 2:
					System.out.println("Enter student ID");
					id = scan.nextInt();
					Student student = StudentManager.getStudent(id);
					if(student == null) System.out.println("NO STUDENT with ID "+id);
					else student.printStudent();
					break;
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

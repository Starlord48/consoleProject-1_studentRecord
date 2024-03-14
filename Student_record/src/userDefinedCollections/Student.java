package userDefinedCollections;

public class Student {
	private int studentID;
	private String studentName;
	private int studentRoll;
	private String studentCourse;

	public Student(int ID, String name, int roll, String course) {
		studentID = ID;
		studentName = name;
		studentRoll = roll;
		studentCourse = course;
	}
	public int getStudentID() {
		return studentID;
	}
	public String getStudentName() {
		return studentName;
	}
	public int getStudentRoll() {
		return studentRoll;
	}
	public String getStudentCourse() {
		return studentCourse;
	}
		
	public void setStudentID(int ID) {
		studentID = ID;
		
	}
	public void setStudentName(String name) {
		studentName = name;
		
	}
	public void setStudentRoll(int roll) {
		studentRoll = roll;
		
	}
	public void setStudentCourse(String course) {
		studentCourse = course;
	}
	public void printStudent() {
		System.out.println("Student id: " + studentID+"\tStudent name: "+studentName+"\n student Roll: "+studentRoll+ "\t course: "+studentCourse);
	}
}

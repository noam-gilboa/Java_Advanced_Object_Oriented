//done

import java.util.*;


/**
 * An abstract class representing a student
 * that extends Comparable and includes methods and fields 
 * related to student information and courses. 
 * It also implements the Comparable interface to 
 * enable comparison between Student objects based on their IDs.
 * 
 * This class provides basic properties and methods to manage student information and courses.
 * Note that when you implement Comparable, it is possible that a warning
 * is given, which you should ignore for now, until we discuss Generic. 
 */
//done
public abstract class Student implements Comparable {
	protected ArrayList<Course> courses;
	protected int id;
	protected String name;
	
	//creates a student object
	public Student() {
		courses=new ArrayList<Course>();
		this.id=0;
		this.name="";
	}
	
	//add a course for the student
	public abstract void addCourse(Course course) throws Exception;
	
	//removes a course for the student
	public abstract void dropCourse(Course course);
	
	
	//gets the student ID
	public int getId() {	
		return this.id;
	}
	//returns the student name
	public String getName() {
		return this.name;
	}
	
	//get the list of courses attached to student
	public ArrayList<Course> getCourses(){
		return this.courses;
	}	
	
	//compares one student to another, compare method specified in implemented Comparable
	public int compareTo(Object object) {
		Student obj=(Student) object;
		
		return Integer.compare(this.id,obj.id);
	}
	
	/*  Your implementation starts here
	 * Recall that :
	 * 1. No System.out.println statements should appear here.
	 * 	  Instead, you need to return the result.
	 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
	 *    Instead, refer to the input parameters of this method.   
	 */
}


/**
 * A class representing a registered student.
 * This class extends the abstract class Student and provides methods and properties
 * specific to registered students and their course registrations.
 */
class RegisteredStudent extends Student {
	
	protected ArrayList<Course> courses;
	protected int id;
	protected String name;
	
	//creates a new registered student object
	public RegisteredStudent(int id,String name) {
		this.id=id;
		this.name=name;
		this.courses=new ArrayList<>();
	}
	//adds a course to registered student
	
	public void addCourse(Course course) throws Exception {
		
		    if (course.prerequisite != null && !this.courses.contains(course.prerequisite)) {
		        throw new PrerequisiteException("addCourse failed due to missing prerequisite.");
		    }
		    
		    if (course.offered==false) {
		        throw new RegistrationException("Course not offered.");
		    }
		    if (this.courses.contains(course)) {
		    	return;
		    }
		    this.courses.add(course);
		
	}	
			
		
	
	//removes a course from registered student
	public void dropCourse(Course course) {
		this.courses.remove(course);
	}
	
	//generated hash code 
	@Override
	public int hashCode() {
		return Objects.hash(courses, id, name);
	}

	//gets the student ID
	public int getId() {	
		return this.id;
	}
	//returns the student name
	public String getName() {
		return this.name;
	}
	
	//get the list of courses attached to student
	public ArrayList<Course> getCourses(){
		return this.courses;
	}	
	
	//compares one student to another, compare method specified in implemented Comparable
	public int compareTo(Object object) {
		RegisteredStudent obj=(RegisteredStudent) object;
		return Integer.compare(this.id,obj.id);
	}
	
	//generated equals mthod to check if one student is equal to another
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegisteredStudent other = (RegisteredStudent) obj;
		return Objects.equals(courses, other.courses) && id == other.id && Objects.equals(name, other.name);
	}
	
	
	
	
	/*  Your implementation starts here
	 * Recall that :
	 * 1. No System.out.println statements should appear here.
	 * 	  Instead, you need to return the result.
	 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
	 *    Instead, refer to the input parameters of this method.   
	 */
}



/**
 * A class representing a course.
 * This class contains information about a course, including its name, prerequisite,
 * and whether it is currently offered.
 */
class Course {
	/*  Your implementation starts here
	 * Recall that :
	 * 1. No System.out.println statements should appear here.
	 * 	  Instead, you need to return the result.
	 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
	 *    Instead, refer to the input parameters of this method.   
	 */
	
	protected String name;
	protected boolean offered;
	protected Course prerequisite;
	//new course object without a prereq
	public Course (String name, boolean offered) {
		this.name=name;
		this.offered=offered;
		this.prerequisite=null;
	}
	//new course object with a prereq
	public Course (String name, Course prerequisite, boolean offered) {
		this.name=name;
		this.prerequisite=prerequisite;
		this.offered=offered;	
	}
	//returns name of course
	public String getName() {
		return this.name;	
	}
	//sets the course name
	public void setName(String name) {
		this.name=name;
	}
	//gets the prereq for the course
	public Course getPrerequisite() {
		return this.prerequisite;
	}
	//set the prereq for the course
	public void setPrerequisite(Course prerequisite) {
		this.prerequisite=prerequisite;
	}
	//generated hashcode method to return hash of object
	@Override
	public int hashCode() {
		return Objects.hash(name, offered, prerequisite);
	}
	//generated equals method to check equality
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(name, other.name) && offered == other.offered
				&& Objects.equals(prerequisite, other.prerequisite);
	}
	
	
	
	
	
    
    
}




/**
 * A custom exception class representing an exception related to course registration.
 * This exception can be used to handle registration-related errors.
 */
class RegistrationException extends Exception {
	//constructs an error with no custom message
	public RegistrationException(){
		super();
	}
	//constructs an error with a custom message
	public RegistrationException(String message){
		super(message);
	}
	
	/*  Your implementation starts here
	 * Recall that :
	 * 1. No System.out.println statements should appear here.
	 * 	  Instead, you need to return the result.
	 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
	 *    Instead, refer to the input parameters of this method.   
	 */
}

/**
 * A custom exception class representing an exception related to course prerequisites.
 * This exception can be used to handle errors related to course prerequisites.
 */
class PrerequisiteException extends RegistrationException {
	//constructs an error with no custom message
	public PrerequisiteException(){
		super();
	}
	//constructs an error with a custom message
	public PrerequisiteException(String message){
		super(message);
	}
	/*  Your implementation starts here
	 * Recall that :
	 * 1. No System.out.println statements should appear here.
	 * 	  Instead, you need to return the result.
	 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
	 *    Instead, refer to the input parameters of this method.   
	 */
}
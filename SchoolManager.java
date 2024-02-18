
import java.util.*;

/**
 * This class manages employees in a school and their lists/sets.
 * Your implementation of this class or methods should not contains:
 * 1. System.out.println statements. Instead, you need to return the result. 
 * 2. Scanner operations(e.g., input.nextInt()). Instead, refer to the input parameters of this method.
 */

public class SchoolManager {
	
		// TODO: Your implementation starts here
		/*  Your implementation starts here
		 * Recall that :
		 * 1. No System.out.println statements should appear here.
		 * 	  Instead, you need to return the result.
		 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
		 *    Instead, refer to the input parameters of this method.   
		 */
	
	
	private MyList overtimeList;
	private MySet seminarRegistrationSet;
	
	public SchoolManager() {
		overtimeList=new MyList();
		seminarRegistrationSet=new MySet();
		
	}
	public void addToOvertimeList(Employee e) {
		overtimeList.add(e);
		
	} 
	public void addToSeminarRegistrationList(Employee e) {
		seminarRegistrationSet.add(e);
		
	} 
	public int getOvertimeEmployeeCount() {
		return overtimeList.getSize();
	} 
	public int getSeminarRegistrationsCount() {
		return seminarRegistrationSet.getSize();
	}

	public String displayOvertimeList() {
		if (overtimeList.toString()=="[]") {
			return "Overtime List: No employees in the overtime list.";
		}
		return "Overtime List: "+overtimeList.toString();
	}
	public String displaySeminarRegistrationList() {
		if (seminarRegistrationSet.toString()=="[]") {
			return "Registration List: No employees in the registration list.";
		}
		return "Registration List: "+seminarRegistrationSet.toString();
	}
	
	
	

	

}

/**
 * 
 * This class represents an employee in the school management system.
 * Your implementation of this class or methods should not contains:
 * 1. System.out.println statements. Instead, you need to return the result. 
 * 2. Scanner operations(e.g., input.nextInt()). Instead, refer to the input parameters of this method.
 */
class Employee {
		private String name;
		private int age;
		private String employeeId;
		
		
		public Employee(String name, int age, String Id) {
			this.name=name;
			this.age=age;
			this.employeeId=Id;
			
		}
		public void setName(String name) {
			this.name=name;
			
		}
		public void setAge(int age) {
			this.age=age;
		}
		public void setEmployeeId(String Id) {
			this.employeeId=Id;
			
		}
		public String getName() {
			return this.name;
		}
		public int getAge() {
			return this.age;
			
		}
		public String getEmployeeId() {
			return this.employeeId;
			
		}
		@Override
		public String toString() {
			return "{"+ name +" (ID: "+ employeeId + ")}";
		}
		@Override
		public int hashCode() {
			return Objects.hash(age, employeeId, name);
		}
		@Override
		public boolean equals(Object obj) {
			if (this==null) {
				return false;
			}
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Employee other = (Employee) obj;
			return age == other.age && Objects.equals(employeeId, other.employeeId) && Objects.equals(name, other.name);
		}
		
		
	
		// TODO: Your implementation starts here
		/* 
		 * Recall that :
		 * 1. No System.out.println statements should appear here.
		 * 	  Instead, you need to return the result.
		 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
		 *    Instead, refer to the input parameters of this method.   
		 */
	
	

}

/**
 * 
 * This class represents a container that stores objects in an array-like
 * structure. Your implementation of this class or methods should not contains:
 * 1. System.out.println statements. Instead, you need to return the result. 
 * 2. Scanner operations(e.g., input.nextInt()). Instead, refer to the input parameters of this method.
 */
class Container {
	// ALREADY IMPLEMENTED; DO NOT MODIFY
	/**
	 * The initial size of the container.
	 */
	protected final int INITIAL_SIZE = 10;

	/**
	 * The array that holds the objects.
	 */
	

	/**
	 * The number of elements currently stored in the container.
	 */
	protected int size=0;
	protected Object[] list=new Object[INITIAL_SIZE];

	// TODO: Your implementation starts here
	/*  Your implementation starts here
	 * Recall that :
	 * 1. No System.out.println statements should appear here.
	 * 	  Instead, you need to return the result.
	 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
	 *    Instead, refer to the input parameters of this method.   
	 */
	public void add(Object obj) {
		 if (size >= list.length) {
		        int newCapacity = list.length+2; // Double the capacity
		        list = Arrays.copyOf(list, newCapacity);
		    }
		    // Add the object to the list and update the size
		    list[size] = obj;
		    size++;		
	}
	public Object remove(Object obj) {
		Object[] newList=new Object[this.size-1];
		int index=0;
		boolean removed=false;
		
		for (int i=0;i<this.size;i++) {
			if (this.list[i]==null) {
				continue;
			}
			if (this.list[i].equals(obj)&&!removed) {
				removed=true;
				continue;
				
			}
			
			else {
				newList[index++]=this.list[i];
			}
		}
		this.size--;
		this.list=newList;
		return obj;	
		
	}
	public int getSize() {
		return this.size;
	}
	public Boolean isEmpty() {
		boolean empty=true;
		for (int i=0;i<this.size;i++) {
			if (list[i]!=null) {
				empty=false;
			}
			
		}
		return empty;
	}
	
	public boolean contains(Object obj) {
		for (int i = 0; i < size; i++) {
            if (list[i] != null && list[i].equals(obj)) {
                return true;
            }
        }
        return false;
    
		
	}
	public int countOccurrences(Object obj) {
		int count=0;
		for (int i=0;i<this.size;i++) {
			if (this.list[i]==obj) {
				count++;
			}
		}
		return count;
		
	}
	@Override
	public String toString() {
		int count=0;
		for (int i=0;i<this.size;i++) {
			if (this.list!=null) {
				count++;
			}
			
		}
		Object[] newList=new Object[count];
		
		for (int i=0;i<count;i++) {
			newList[i]=this.list[i];
		}
		
		
		return Arrays.toString(newList);
	}
	
	
	
	
}

/**
 * This class simulates an ArrayList concept, where you can add unlimited number
 * of elements to the list.
 */
class MyList extends Container {
	public MyList() {
		super();
		super.size=0;
	}
	
	public Object get(int index) {
        
        return super.list[index];
    }

    @Override
    public void add(Object obj) {
        super.add(obj);
    }

    @Override
    public Object remove(Object obj) {
        return super.remove(obj);
    }
	
	
	
	// TODO: Your implementation starts here
	/*  Your implementation starts here
	 * Recall that :
	 * 1. No System.out.println statements should appear here.
	 * 	  Instead, you need to return the result.
	 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
	 *    Instead, refer to the input parameters of this method.   
	 */
	
	
	
}

/**
 * This class simulates a custom set that stores unique elements.
 */
class MySet extends Container {
	
	
	public MySet() {
		super();
		
	}
	 public void add(Object obj) {
		 
	        if (super.contains(obj)==false) {
	            super.add(obj);
	        }
	    }

	    @Override
	    public Object remove(Object obj) {
	        if (super.contains(obj)==true) {
	            return super.remove(obj);
	        }
	        return obj;
	    }
}
	
	// TODO: Your implementation starts here
	/*  Your implementation starts here
	 * Recall that :
	 * 1. No System.out.println statements should appear here.
	 * 	  Instead, you need to return the result.
	 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
	 *    Instead, refer to the input parameters of this method.   
	 */




import java.io.*;
import java.util.*;

/**
 * The {@code Container} class is a generic container that can hold objects. It
 * provides methods for adding and removing objects, as well as querying the
 * size of the container.
 * In your implementation of this class:
 * 1. No System.out.println statements should appear here. Instead, you need to return the result. 
 * 2. No Scanner operations should appear here (e.g., input.nextInt()). Instead, refer to the input parameters of this method.
 */
public class Container {
	// No instance variable should be defined for this class.
	/*  Your implementation starts here
	 * Recall that :
	 * 1. No System.out.println statements should appear here.
	 * 	  Instead, you need to return the result.
	 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
	 *    Instead, refer to the input parameters of this method.   
	 */
	
	public Container() {
		
	}
	
	public void add(Object object) {
		
	}
	
	public Object remove() {
		return null;
	}
	
	public int getSize() {
		return 0;
	}
	
}

/**
 * The {@code Queue} class simulates a queue data structure, inserting and
 * removing data by the FIFO (first-in, first-out) rule. It stores orders with a
 * total amount above or equal to 1500 in the queue.
 *
 */
class Queue extends Container {
	/*  Your implementation starts here
	 * Recall that :
	 * 1. No System.out.println statements should appear here.
	 * 	  Instead, you need to return the result.
	 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
	 *    Instead, refer to the input parameters of this method.   
	 */

	private ArrayList<Order> queue;
	
	public Queue(String fileName) {
		List<String> readList = IOHandler.readFile(fileName);
		String curLine;
		int orderId;
		String customerName;
		String productName;
		int quantity;
		double unitPrice;
		int pos;
		queue = new ArrayList<Order>();
		
		for (int i = 0; i < readList.size(); i++) {
			curLine = readList.get(i);
			pos = curLine.indexOf(',');
			orderId = Integer.parseInt(curLine.substring(0, pos));
			curLine = curLine.substring(pos+2);
			pos = curLine.indexOf(',');
			customerName = curLine.substring(0, pos);
			curLine = curLine.substring(pos+2);
			pos = curLine.indexOf(',');
			productName = curLine.substring(0, pos);
			curLine = curLine.substring(pos+2);
			pos = curLine.indexOf(',');
			quantity = Integer.parseInt(curLine.substring(0, pos));
			curLine = curLine.substring(pos+2);
			unitPrice = Double.parseDouble(curLine);
			Order order = new Order(orderId, customerName, productName, quantity, unitPrice);
			add(order);
		}
	}
	
	public void add(Object order) {
		Order o = (Order)order;
		if (o.getTotalAmount() >= 1500) {
			queue.add(o);
		}
	}
	
	public Object remove() {
		if (queue.size() > 0) {
			return queue.remove(0);
		}
		return null;
	}
	
	public Object top() {
		if (queue.size() > 0) {
			return queue.get(0);
		}
		return null;
	}
	
	public int getSize() {
		return queue.size();
	}
	
}

/**
 * The {@code Stack} class simulates a stack data structure, inserting and
 * removing data by the FILO (first-in, last-out) rule. It stores orders with a
 * total amount below 1500 in the stack.
 *
 */
class Stack extends Container {
	
	/*  Your implementation starts here
	 * Recall that :
	 * 1. No System.out.println statements should appear here.
	 * 	  Instead, you need to return the result.
	 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
	 *    Instead, refer to the input parameters of this method.   
	 */
	
	private ArrayList<Order> stack;
	
	public Stack(String fileName) {
		List<String> readList = IOHandler.readFile(fileName);
		String curLine;
		int orderId;
		String customerName;
		String productName;
		int quantity;
		double unitPrice;
		int pos;
		stack = new ArrayList<Order>();
		
		for (int i = 0; i < readList.size(); i++) {
			curLine = readList.get(i);
			pos = curLine.indexOf(',');
			orderId = Integer.parseInt(curLine.substring(0, pos));
			curLine = curLine.substring(pos+2);
			pos = curLine.indexOf(',');
			customerName = curLine.substring(0, pos);
			curLine = curLine.substring(pos+2);
			pos = curLine.indexOf(',');
			productName = curLine.substring(0, pos);
			curLine = curLine.substring(pos+2);
			pos = curLine.indexOf(',');
			quantity = Integer.parseInt(curLine.substring(0, pos));
			curLine = curLine.substring(pos+2);
			unitPrice = Double.parseDouble(curLine);
			Order order = new Order(orderId, customerName, productName, quantity, unitPrice);
			add(order);
		}
	}
	
	public void add(Object order) {
		Order o = (Order)order;
		if (o.getTotalAmount() < 1500) {
			stack.add(o);
		}
	}
	
	public Object remove() {
		if (stack.size() > 0) {
			return stack.remove(stack.size() - 1);
		}
		return null;
	}
	
	public Object top() {
		if (stack.size() > 0) {
			return stack.get(stack.size() - 1);
		}
		return null;
	}
	
	public int getSize() {
		return stack.size();
	}
	
}

/**
 * The {@code IOHandler} class provides static methods for handling input and
 * output operations with files. It allows reading content from a file and
 * writing content to a file.
 *
 */
class IOHandler {
	
	/*  Your implementation starts here
	 * Recall that :
	 * 1. No System.out.println statements should appear here.
	 * 	  Instead, you need to return the result.
	 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
	 *    Instead, refer to the input parameters of this method.   
	 */

	public IOHandler() {
		
	}
	
	public static List<String> readFile(String fileName){
		ArrayList<String> list = new ArrayList<String>();
		
		try {
			File myFile = new File(fileName);
			Scanner readFile = new Scanner(myFile);
			while (readFile.hasNextLine()) {
				list.add(readFile.nextLine());
			}
			readFile.close();
		} catch (FileNotFoundException e) {
			System.out.println("File " + fileName + " could not be found!");
		}
		
		return list;		
	}
	
	public static void writeFile(String fileName, List<String> content) {
		try {
			PrintWriter myFile = new PrintWriter(fileName);
			for (int i = 0; i < content.size(); i++) {
				myFile.println(content.get(i));
			}
			myFile.close();
		} catch (IOException e) {
			System.out.println("Cannot write to the file " + fileName + ". Error is " + e.getMessage());
		}
	}	
}

/**
 * The {@code Order} class represents an order in the order processing system.
 * It encapsulates information about the order such as order ID, customer name,
 * product name, quantity, and unit price.
 *
 */
class Order {
	
	/*  Your implementation starts here
	 * Recall that :
	 * 1. No System.out.println statements should appear here.
	 * 	  Instead, you need to return the result.
	 * 2. No Scanner operations should appear here (e.g., input.nextInt()).
	 *    Instead, refer to the input parameters of this method.   
	 */
	
	private String customerName;
	private int orderId;
	private String productName;
	private int quantity;
	private double unitPrice;
	
	public Order(int orderId, String customerName, String productName, int quantity, double unitPrice) {
		this.orderId = orderId;
		this.customerName = customerName;
		this.productName = productName;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}
	
	public double getTotalAmount() {
		return Math.round(quantity * unitPrice * 100.0) / 100.0;
	}
	
	@Override
	public String toString() {
		return "[" + orderId + ", " + customerName + ", " + productName + ", " + quantity + ", " + Math.round(unitPrice * 100.0) / 100.0 + "]";
	}
}
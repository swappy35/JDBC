package practice;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement;
import java.util.Scanner;

public class Student {

	// JDBC URL, username and password of MySQL server
    private static final String url = "jdbc:mysql://localhost:3306/db_world";
    private static final String user = "root";
    private static final String password = "root";
    
    // JDBC variables for opening and managing connection
    Connection con;
    PreparedStatement prSt;
    Statement stmt;
	
	public static void main(String[] args) {
		
		Student stud = new Student();
    	
        Scanner input = new Scanner(System.in);
        
        System.out.println("===================== MENU==========================");
        System.out.println("1. Retieve the employees Data"); 
        System.out.println("2. Count number of Employees");
        System.out.println("3. Insert the new employee Record");
        System.out.println("4. Update the employee Record");
        System.out.println("====================================================");
    	System.out.println("Enter your choice from (1-4): ");
    	
    	int number = input.nextInt();
    	System.out.println("You entered option" + number);
    	
//    	switch(number)
//    	{
//    	case 1: stud.retrieveData();
//    	        break;
//    	
//    	case 2: stud.countEmployees();
//    	        break;
//    	        
//    	case 3: stud.insertRecord();
//    	        break;
//    	        
//    	case 4: stud.updateRecord();
//    	        break;
//    	}	   
	}	
}
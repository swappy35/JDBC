package assignment;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.Driver;

public class StudentPrepStmt {
	
	// JDBC URL, username and password of MySQL server
    private static final String url = "jdbc:mysql://localhost:3306/db_world";
    private static final String user = "root";
    private static final String password = "root";
    
    // JDBC variables for opening and managing connection
    Connection con;
    PreparedStatement PrepStmt;
    Statement stmt;
	
	public static void main(String[] args) {
		
		StudentPrepStmt stud = new StudentPrepStmt();
		Scanner input = new Scanner(System.in);
		
		System.out.println("===================== MENU==========================");
        System.out.println("1. Retieve the students Record"); 
        System.out.println("2. Insert the students Record");
        System.out.println("3. Update the students Record");
        System.out.println("4. Delete the students Record");
        System.out.println("====================================================");
    	System.out.println("Enter your choice from (1-4): ");
    	
    	int number = input.nextInt();
    	System.out.println("You entered option" + number);
    	
    	switch(number)
    	{
    	case 1: stud.retrieveData();
    	        break;
    	
    	case 2: stud.insertRecord();
    	        break;
    	        
    	case 3: stud.updateRecord();
    	        break;
    	        
    	case 4: stud.deleteRecord();
    	        break;
    	}	   
	}
	
	public void retrieveData(){
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			con = DriverManager.getConnection(url, user, password);
			//PrepStmt = con.prepareStatement(query);
			stmt = con.createStatement();
			String query = "select * from StudentPrepStmt";
			ResultSet rs = stmt.executeQuery(query);
			System.out.println("S_ID\tS_Name\tS_Age\tS_City");
			
			while(rs.next()){
				int S_ID = rs.getInt("S_ID");
				String S_Name = rs.getString("S_Name");
				int S_Age = rs.getInt("S_Age");
				String S_City = rs.getString("S_City");
				System.out.println(S_ID+"\t"+S_Name+"\t"+S_Age+"\t"+S_City);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void insertRecord(){
		String query = "insert into StudentPrepStmt(S_ID, S_Name, S_Age, S_City) values (?, ?, ?, ?)";
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url, user, password);
				PrepStmt = con.prepareStatement(query);
				
				Scanner input = new Scanner(System.in);
				
				System.out.println("Enter Student ID: ");
				int S_ID = input.nextInt();
				System.out.println();
				
				System.out.println("Enter Student Name: ");
				String S_Name = input.next();
				System.out.println();
				
				System.out.println("Enter Student Age: ");
				int S_Age = input.nextInt();
				System.out.println();
				
				System.out.println("Enter Student City: ");
				String S_City = input.next();
				System.out.println();
				
				PrepStmt.setInt(1, S_ID);
				PrepStmt.setString(2, S_Name);
				PrepStmt.setInt(3, S_Age);
				PrepStmt.setString(4, S_City);
				
				int count = PrepStmt.executeUpdate();
				stmt = con.createStatement();
				System.out.println("Record Inserted");
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
	            e.printStackTrace();
	        } finally{
	            try{
	                if(PrepStmt != null) PrepStmt.close();
	                if(con != null) con.close();
	            } catch(Exception ex){}
	        }	
	}
	public void updateRecord(){
		String query = "UPDATE studentprepstmt SET S_City = ? WHERE S_ID = ?";
		try{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			PrepStmt = con.prepareStatement(query);
			Scanner input = new Scanner(System.in);
			System.out.println("Enter student ID where you want to update: ");
			int S_ID = input.nextInt();
			System.out.println();
			
			System.out.println("Enter student ID where you want to update: ");
			String S_City = input.next();
			System.out.println();
			
			PrepStmt.setString(1, S_City);
			PrepStmt.setInt(2, S_ID);
			
			int rowAffected = PrepStmt.executeUpdate();
			System.out.println(String.format("Row affected %d", rowAffected));
			
		}
	    catch (SQLException ex) {
	    System.out.println(ex.getMessage());
	    }
	}
	
	public void deleteRecord(){
		String query = "DELETE from StudentPrepStmt where S_ID = ? ";
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url, user, password);

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			PrepStmt = con.prepareStatement(query);
			Scanner input = new Scanner(System.in);
			
			System.out.println("Enter the Student ID to be deleted: ");
			int S_ID = input.nextInt();
			System.out.println();
			
			PrepStmt.setInt(1, S_ID);
			PrepStmt.executeUpdate();
			System.out.println("Record Deleted");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}	
	}
}

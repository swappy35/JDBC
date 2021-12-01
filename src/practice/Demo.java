package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo {
	
	//Step 1: Datasource ::: JDBC URL, username and password of MySQL server
    private static final String url = "jdbc:mysql://localhost:3306/db_world";
    private static final String user = "root";
    private static final String password = "root";

    //Step 2: // JDBC variables for opening and managing connection
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;
   
    
	public static void main(String[] args) {
		
		String query1 = "select * from emp";
		
	    //Step 3: register the driver
	    try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	    
	    try {
			con = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			rs = stmt.executeQuery(query1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			while (rs.next()) 
			{ 
			   int id = rs.getInt(1); 
			   String name = rs.getString(2); 
			   String salary = rs.getString(3); 
			   System.out.printf("empid : %d, empname: %s, salary : %s \n", id, name, salary); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}










package users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Admin {

	public void login() {
		
		        try {
		        	Scanner sc = new Scanner(System.in);
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fitness", "root", "prasanna");

		            System.out.println("Enter UserName:");
		            String email = sc.next();

		            System.out.println("Enter your Password:");
		            String password = sc.next();

		            String query = "SELECT * FROM user WHERE email = ? AND password = ? AND user_type = 3 ";
		            PreparedStatement ptobj = con.prepareStatement(query);
		            ptobj.setString(1, email);
		            ptobj.setString(2, password);

		            ResultSet rs = ptobj.executeQuery();
		            
		            while(true) {
		            	
		            	if (rs.next()) {
		            		System.out.println("Login successful!");
		            	}
		            }
		        }catch(Exception e) {}       
	}
}

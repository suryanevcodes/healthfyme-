package users;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
 
 
 
public class LoginUser {
	
	 public void login() {
	        try {
	        	Scanner sc = new Scanner(System.in);
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fitness", "root", "prasanna");
 
	            System.out.println("Enter your Email:");
	            String email = sc.next();
 
	            System.out.println("Enter your Password:");
	            String password = sc.next();
 
	            String query = "SELECT * FROM user2 WHERE email = ? AND password = ?";
	            
	            PreparedStatement ptobj = con.prepareStatement(query);
	            ptobj.setString(1, email);
	            ptobj.setString(2, password);
 
	            ResultSet rs = ptobj.executeQuery();
	            
	            while(true) {
	            	
	            	if (rs.next()) {
	            		System.out.println("Login successful!");
	            		System.out.println("Select the below Options");
	            		System.out.println("1. display workout");
	            		System.out.println("2. Account Details");
	            		System.out.println("3. Meal/workout");
	            		int choice =0;
	            		do {
	            			
	            			System.out.println("Enter the choice");
	            			choice = sc.nextInt();
	            			switch (choice) {
	            			case 1:
	            				System.out.println("---workouts---");
	            				
	            				break;
	            			case 2:
	            				System.out.println("Account Details");
	            				DisplayUsers du= new DisplayUsers();
	            				du.display(email);
	            				break;
	            			case 3:
	            				Meal_workout ml = new Meal_workout();
	            				ml.Meal_workouts(email);
	            				
	            			default:
	            				System.out.println("Invalid choice");
	            			}
	            		}while(choice!=5);
	            		
	            	} else {
	            		System.out.println("Login failed. Invalid email or password.");
	            	}
	            	con.close();
	            }
 
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	
}
 
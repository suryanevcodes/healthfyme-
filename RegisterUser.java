package users;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
 
public class RegisterUser {
	  public void register() {
	        try {
	        	Scanner sc = new Scanner(System.in);
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fitness", "root", "prasanna");
	            System.out.println("Select user type:");
	            System.out.println("1. Regular User");
	            System.out.println("2. Premium User");
	            System.out.println("3. Admin User");
	            System.out.println("4. Trainer");
	            System.out.println("5. CoTrainer");
	            System.out.println("6. Nutritionist");
	            System.out.println("7. Health Professional");
	            System.out.println("8. Content Creator");
	            System.out.println("Enter the number of selected type:");
 
	            int userType = sc.nextInt();
	            sc.nextLine();
 
	            String query = "INSERT INTO user2 (id, lastname, firstname,age, weight, Height, email, password, user_type) VALUES (?, ?, ?, ?,?,?, ?, ?, ?)";
	            PreparedStatement ptobj = con.prepareStatement(query);
 
	            System.out.println("Enter the Last name:");
	            String lastName = sc.nextLine();
 
	            System.out.println("Enter the First name:");
	            String firstName = sc.nextLine();
	            
	            System.out.println("Enter Age:");
	            int age = sc.nextInt();
	            
	            System.out.println("Enter the weight:");
	            float weight = sc.nextFloat();
	            
	            System.out.println("Enter the Height:");
	            float height = sc.nextFloat();
	            sc.nextLine();
 
	            System.out.println("Enter the Email:");
	            String email = sc.nextLine();
 
	            System.out.println("Enter the Password:");
	            String password = sc.nextLine();
 
	            System.out.println("Enter the Id:");
	            int id = sc.nextInt();
	            sc.nextLine();
 
	            ptobj.setInt(1, id);
	            ptobj.setString(2, lastName);
	            ptobj.setString(3, firstName);
	            ptobj.setInt(4, age);
	            ptobj.setFloat(5,weight);
	            ptobj.setFloat(6, height);
	            
	            ptobj.setString(7, email);
	            ptobj.setString(8, password);
	            ptobj.setInt(9, userType);
 
	            int result = ptobj.executeUpdate();
 
	            if (result > 0) {
	                System.out.println("User registered successfully!");
	            } else {
	                System.out.println("Failed to register user.");
	            }
 
	            con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
}
 

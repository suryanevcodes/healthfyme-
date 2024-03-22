package users;

import java.util.Scanner;

public class WorkoutSelector {

	public void workdisplay() {
		 Scanner scanner = new Scanner(System.in);

	        while (true) {
	            System.out.println("1. Workout 1");
	            System.out.println("2. Workout 2");
	            System.out.println("3. Workout 3");
	            System.out.println("4. Workout 4");
	            System.out.println("5. Workout 5");
	            System.out.println("6. Exit");
	            System.out.println("\nChoose a workout:");

	            int option = scanner.nextInt();

	            switch (option) {
	                case 1:
	                    System.out.println("You selected Workout 1");
	                    Workout w1 = new Workout(0.5);
	                    w1.display();
	                    break;
	                case 2:
	                    System.out.println("You selected Workout 2");
	                    Workout w2 = new Workout(0.7);
	                    w2.display();
	                    
	                    break;
	                case 3:
	                    System.out.println("You selected Workout 3");
	                    Workout w3 = new Workout(0.8);
	                    w3.display();
	                    break;
	                case 4:
	                    System.out.println("You selected Workout 4");
	                    Workout w4 = new Workout(0.6);
	                    w4.display();
	                    break;
	                case 5:
	                    System.out.println("You selected Workout 5");
	                    Workout w5 = new Workout(0.4);
	                    w5.display();
	                    break;
	                case 6:
	                    scanner.close();
	                    System.exit(0);
	                default:
	                    System.out.println("Invalid option. Please choose again.");
	            }
	        }
	}
	
	
    
}

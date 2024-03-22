package users;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
 
public class Meal_workout {
	
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Meal_workouts("s");
        scanner.close();
    }
        
	public static void Meal_workouts(String email) {
        try {
            int weight = 0;
            int height = 0;
            
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fitness", "root", "prasanna");
            String query = "SELECT height, weight FROM user2 WHERE email = ? ";
            PreparedStatement pt = con.prepareStatement(query);
            pt.setString(1, email);
            ResultSet rs = pt.executeQuery();
            
            while (rs.next()) {
                weight = rs.getInt("weight");
                height = rs.getInt("height");
            }
      
            System.out.println("Weight: " + weight);
            System.out.println("Height: " + height);
            
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Welcome to HealthifyMe!");
                System.out.println("Select an option:");
                System.out.println("1. Meal Plans");
                System.out.println("2. Exercise");
                System.out.println("3. Start The Workout");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
 
                switch (choice) {
                    case  3:
                    	WorkoutSelector w = new WorkoutSelector();
        				w.workdisplay();
                    case 1:
                        // Calculate BMI and display meal plans
                        double bmiMeal = calculateBMI(weight, height);
                        String bmiCategoryMeal = getBMICategory(bmiMeal);
                        displayMealPlans(bmiCategoryMeal);
 
                        // Prompt the user to select exercise
                        System.out.println("Would you like to view exercise plans? (Y/N)");
                        String exerciseChoiceMeal = scanner.nextLine().toUpperCase();
                        if (exerciseChoiceMeal.equals("Y")) {
                            displayExercisePlans(bmiCategoryMeal);
                        }
                        break;
                    case 2:
                        // Calculate BMI and display exercise plans
                        double bmiExercise = calculateBMI(weight, height);
                        String bmiCategoryExercise = getBMICategory(bmiExercise);
                        displayExercisePlans(bmiCategoryExercise);
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (Exception e) {
            // Handle any exceptions
            e.printStackTrace(); // Print the exception trace for debugging
        }
    }
    public static double calculateBMI(double weight, double height) {
        return weight / (height * height);
    }
 
    // Get BMI Category
    public static String getBMICategory(double bmi) {
        if (bmi < 18.5)
            return "Underweight";
        else if (bmi >= 18.5 && bmi < 25)
            return "Normal weight";
        else if (bmi >= 25 && bmi < 30)
            return "Overweight";
        else
            return "Obese";
    }
 
    // Display meal plans based on BMI category
   // Display meal plans based on BMI category
// Display meal plans based on BMI category
// Display meal plans based on BMI category
public static void displayMealPlans(String bmiCategory) {
    System.out.println("Meal plans for " + bmiCategory + " category:");
    System.out.println("--------------------------------------------------------------------");
    System.out.println("| Meal        | Item                   | Calories                   |");
    System.out.println("--------------------------------------------------------------------");
 
    // Add predefined meal plans based on BMI categories
    if (bmiCategory.equals("Underweight")) {
        printMeal("Breakfast", "2 idli", 100);
        printMeal("Breakfast", "1 glass of milk", 120);
        printMeal("Lunch", "2 chapati", 200);
        printMeal("Lunch", "1 bowl of dal", 150);
        printMeal("Dinner", "1 bowl of rice", 150);
        printMeal("Dinner", "1 bowl of vegetable curry", 100);
    } else if (bmiCategory.equals("Normal weight")) {
        printMeal("Breakfast", "1 serving of oatmeal", 150);
        printMeal("Breakfast", "1 banana", 100);
        printMeal("Lunch", "1 grilled chicken breast", 200);
        printMeal("Lunch", "1 cup of brown rice", 150);
        printMeal("Dinner", "1 salmon fillet", 250);
        printMeal("Dinner", "1 cup of steamed broccoli", 50);
    } else if (bmiCategory.equals("Overweight")) {
        printMeal("Breakfast", "1 avocado toast", 200);
        printMeal("Breakfast", "1 boiled egg", 70);
        printMeal("Lunch", "1 turkey sandwich", 300);
        printMeal("Lunch", "1 cup of vegetable soup", 100);
        printMeal("Dinner", "1 baked salmon", 300);
        printMeal("Dinner", "1 cup of quinoa", 150);
    } else if (bmiCategory.equals("Obese")) {
        printMeal("Breakfast", "1 protein smoothie", 250);
        printMeal("Breakfast", "1 handful of almonds", 150);
        printMeal("Lunch", "1 grilled vegetable salad", 200);
        printMeal("Lunch", "1 cup of lentil soup", 150);
        printMeal("Dinner", "1 grilled tofu", 200);
        printMeal("Dinner", "1 cup of brown rice", 150);
    }
 
    System.out.println("--------------------------------------------------------------------");
 
    // Calculate and display total calories for each meal type and overall
    int totalCaloriesBreakfast = getTotalCaloriesForMealType("Breakfast", bmiCategory);
    int totalCaloriesLunch = getTotalCaloriesForMealType("Lunch", bmiCategory);
    int totalCaloriesDinner = getTotalCaloriesForMealType("Dinner", bmiCategory);
    int totalCalories = totalCaloriesBreakfast + totalCaloriesLunch + totalCaloriesDinner;
 
    System.out.println("Total calories for Breakfast: " + totalCaloriesBreakfast);
    System.out.println("Total calories for Lunch: " + totalCaloriesLunch);
    System.out.println("Total calories for Dinner: " + totalCaloriesDinner);
    System.out.println("Total calories consumed today: " + totalCalories);
}
 
// Print a single meal plan item in the table format
private static void printMeal(String mealType, String item, int calories) {
    System.out.printf("| %-12s| %-22s| %-26s|\n", mealType, item, calories + " calories");
}
 
// Calculate total calories for a specific meal type
private static int getTotalCaloriesForMealType(String mealType, String bmiCategory) {
    int totalCalories = 0;
 
    if (bmiCategory.equals("Underweight")) {
        if (mealType.equals("Breakfast")) {
            totalCalories += 100 + 120; // Calories for 2 idli and 1 glass of milk
        } else if (mealType.equals("Lunch")) {
            totalCalories += 200 + 150; // Calories for 2 chapati and 1 bowl of dal
        } else if (mealType.equals("Dinner")) {
            totalCalories += 150 + 100; // Calories for 1 bowl of rice and 1 bowl of vegetable curry
        }
    } else if (bmiCategory.equals("Normal weight")) {
        if (mealType.equals("Breakfast")) {
            totalCalories += 150 + 100; // Calories for 1 serving of oatmeal and 1 banana
        } else if (mealType.equals("Lunch")) {
            totalCalories += 200 + 150; // Calories for 1 grilled chicken breast and 1 cup of brown rice
        } else if (mealType.equals("Dinner")) {
            totalCalories += 250 + 50; // Calories for 1 salmon fillet and 1 cup of steamed broccoli
        }
    } else if (bmiCategory.equals("Overweight")) {
        if (mealType.equals("Breakfast")) {
            totalCalories += 200 + 70; // Calories for 1 avocado toast and 1 boiled egg
        } else if (mealType.equals("Lunch")) {
            totalCalories += 300 + 100; // Calories for 1 turkey sandwich and 1 cup of vegetable soup
        } else if (mealType.equals("Dinner")) {
            totalCalories += 300 + 150; // Calories for 1 baked salmon and 1 cup of quinoa
        }
    } else if (bmiCategory.equals("Obese")) {
        if (mealType.equals("Breakfast")) {
            totalCalories += 250 + 150; // Calories for 1 protein smoothie and 1 handful of almonds
        } else if (mealType.equals("Lunch")) {
            totalCalories += 200 + 150; // Calories for 1 grilled vegetable salad and 1 cup of lentil soup
        } else if (mealType.equals("Dinner")) {
            totalCalories += 200 + 150; // Calories for 1 grilled tofu and 1 cup of brown rice
        }
    }
 
    return totalCalories;
}
 
 
 
 
    // Display exercise plans based on BMI category
// Display exercise plans based on BMI category
// Display exercise plans based on BMI category
public static void displayExercisePlans(String bmiCategory) {
    System.out.println("Exercise plans for " + bmiCategory + " category:");
    System.out.println("PLAN A");
    System.out.println("-------------------------------------------------------------------------");
    System.out.println("| Activity                        | Duration    | Calories Burned|");
    System.out.println("-------------------------------------------------------------------------");
 
    int totalCaloriesBurned = 0; // Variable to store total calories burned
 
    // Add predefined exercise plans based on BMI categories
    if (bmiCategory.equals("Underweight")) {
        totalCaloriesBurned += printExercise("Morning", "brisk walking", "30mins", 150);
        totalCaloriesBurned += printExercise("Morning", "strength training", "20mins", 200);
        totalCaloriesBurned += printExercise("Evening", "cycling", "45mins", 250);
        totalCaloriesBurned += printExercise("Evening", "HIIT", "15mins", 200);
        totalCaloriesBurned += printExercise("Evening", "jump rope", "20mins", 200);
    } else if (bmiCategory.equals("Normal weight")) {
        totalCaloriesBurned += printExercise("Morning", "jogging", "30mins", 200);
        totalCaloriesBurned += printExercise("Morning", "yoga", "20mins", 150);
        totalCaloriesBurned += printExercise("Afternoon", "workout", "1 hour", 400);
        totalCaloriesBurned += printExercise("Afternoon", "cycling", "15mins", 100);
        totalCaloriesBurned += printExercise("Evening", "swimming", "45mins", 300);
        totalCaloriesBurned += printExercise("Evening", "stretching", "20mins", 100);
    } else if (bmiCategory.equals("Overweight")) {
        totalCaloriesBurned += printExercise("Morning", "brisk walking", "20mins", 100);
        totalCaloriesBurned += printExercise("Morning", "strength training", "30mins", 250);
        totalCaloriesBurned += printExercise("Afternoon", "aerobics class", "1 hour", 400);
        totalCaloriesBurned += printExercise("Afternoon", "cycling", "20mins", 150);
        totalCaloriesBurned += printExercise("Evening", "Zumba", "45mins", 350);
        totalCaloriesBurned += printExercise("Evening", "jump rope", "20mins", 200);
    } else if (bmiCategory.equals("Obese")) {
        totalCaloriesBurned += printExercise("Morning", "brisk walking", "20mins", 100);
        totalCaloriesBurned += printExercise("Morning", "strength training", "30mins", 250);
        totalCaloriesBurned += printExercise("Afternoon", "circuit training", "1 hour", 450);
        totalCaloriesBurned += printExercise("Afternoon", "cycling", "20mins", 150);
        totalCaloriesBurned += printExercise("Evening", "kickboxing", "45mins", 400);
        totalCaloriesBurned += printExercise("Evening", "jump rope", "20mins", 200);
    }
 
    System.out.println("-------------------------------------------------------------------------");
    System.out.println("Total calories burned today: " + totalCaloriesBurned + " calories");
}
 
// Print a single exercise plan item in the table format
private static int printExercise(String timeOfDay, String activity, String duration, int caloriesBurned) {
    System.out.printf("| %-30s| %-12s| %-15s|\n", activity, duration, caloriesBurned + " calories");
    System.out.println("|                                |              |                |");
    System.out.println("-------------------------------------------------------------------------");
 
    return caloriesBurned; // Return calories burned for this exercise plan
}
 
 
 
}
 
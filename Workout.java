
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;



public class Workout {
    private double caloriesPerSecond;
    private Timer timer;
    private long startTime;
    private boolean timerRunning;
    private long totalTimeInSeconds;
    private static double totalcalorires=0;

    public static double getTotalcalorires() {
		return totalcalorires;
	}

	public static void setTotalcalorires(double totalcalorires) {
		Workout.totalcalorires = totalcalorires;
	}

	public Workout(double caloriesPerSecond) {
        this.caloriesPerSecond = caloriesPerSecond;
        this.timer = new Timer();
        this.timerRunning = false;
        this.totalTimeInSeconds = 0;
    }

    public void startTimer() {
        if (!timerRunning) {
            startTime = System.currentTimeMillis();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    long elapsedTime = (System.currentTimeMillis() - startTime) / 1000;
                    totalTimeInSeconds = elapsedTime;
                    clearConsole();
                    System.out.print("\rElapsed Time: " + formatTime(elapsedTime));
                }
            }, 0, 1000); // Update every second
            timerRunning = true;
            System.out.println("\nTimer started.");
        }
    }

    public void stopTimer() {
        if (timerRunning) {
            timer.cancel();
            timerRunning = false;
            long elapsedTime = System.currentTimeMillis() - startTime;
            totalTimeInSeconds = elapsedTime / 1000;
            double caloriesBurned = calculateCaloriesBurned();
            Workout.totalcalorires=caloriesBurned+Workout.totalcalorires;
            System.out.println("\nTimer stopped. Total time: " + formatTime(totalTimeInSeconds));
            System.out.println("Calories burned: " + String.format("%.2f",Workout.totalcalorires));
        }
    }

    private double calculateCaloriesBurned() {
        return caloriesPerSecond * totalTimeInSeconds;
    }

    public void pauseTimer() {
        if (timerRunning) {
            timer.cancel();
            timerRunning = false;
            System.out.println("\nTimer paused.");
        }
    }

    public void resumeTimer() {
        if (!timerRunning) {
            timer = new Timer();
            long pausedTime = System.currentTimeMillis() - startTime;
            startTime = System.currentTimeMillis() - pausedTime;
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    long elapsedTime = (System.currentTimeMillis() - startTime) / 1000;
                    totalTimeInSeconds = elapsedTime;
                    clearConsole();
                    System.out.print("\rElapsed Time: " + formatTime(elapsedTime));
                }
            }, 0, 1000); // Update every second
            timerRunning = true;
            System.out.println("\nTimer resumed.");
        }
    }

    private String formatTime(long seconds) {
        long hours = seconds / 3600;
        long minutes = (seconds % 3600) / 60;
        seconds = seconds % 60;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    private static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    
    public void display() {
    		Scanner scanner = new Scanner(System.in);
            System.out.println("1. Start Timer");
            System.out.println("2. Stop Timer");
            System.out.println("3. Pause Timer");
            System.out.println("4. Resume Timer");
            System.out.println("5. Exit");
            System.out.println("Choose an option:");
            while(true) {
            	int option = scanner.nextInt();
            	switch (option) {
            	case 1:
            		this.startTimer();
            		break;
            	case 2:
            		this.stopTimer();
            		WorkoutSelector w= new WorkoutSelector();
            		w.workdisplay();
            		break;
            	case 3:
            		this.pauseTimer();
            		break;
            	case 4:
            		this.resumeTimer();
            		break;
            	case 5:
            		scanner.close();
            		System.exit(0);	
            	default:
            	System.out.println("Invalid option. Please choose again.");
            }
      
        }
          
    	
    }


}


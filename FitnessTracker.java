import java.util.ArrayList;
import java.util.Scanner;

public class FitnessTracker {
    private static final ArrayList<Workout> workouts = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcolme to your Fitness Tracker!");

        boolean running = true;
        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Workout");
            System.out.println("2. View Workouts");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addWorkout();
                    break;
                case 2:
                    viewWorkouts();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void logWorkout() {
        System.out.print("Workout Name: ");
        String name = scanner.nextLine();

        System.out.print("Duration (in minutes): ");
        int duration = Integer.parseInt(scanner.nextLine());

        System.out.print("Calories Burned: ");
        int calories = Integer.parseInt(scanner.nextLine());

        System.out.print("Notes: ");
        String notes = scanner.nextLine();

        Workout workout = new Workout(name, duration, calories, notes);
        workouts.add(workout);

        System.out.println("Workout logged successfully!");
    }

    private static void viewWorkouts() {
        if (workouts.isEmpty()) {
            System.out.println("No workouts logged yet.");
        } else {
            for (Workout w : workouts) {
                System.out.println(w)
            }
        }
    }
}
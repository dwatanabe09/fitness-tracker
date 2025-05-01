import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class FitnessTracker {
    private static final ArrayList<Workout> workouts = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static final String FILE_NAME = "workouts.txt";

    public static void main(String[] args) {
        System.out.println("Welcome to your Fitness Tracker!");
        loadWorkoutsFromFile();

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
                    logWorkout();
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

        System.out.println("Goodbye! Be Consistent!");
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

        LocalDate date = LocalDate.now();

        Workout workout = new Workout(name, duration, calories, notes, date);
        workouts.add(workout);
        saveWorkoutToFile(workout);

        System.out.println("Workout logged successfully!");
    }

    private static void viewWorkouts() {
        if (workouts.isEmpty()) {
            System.out.println("No workouts logged yet.");
        } else {
            for (Workout w : workouts) {
                System.out.println(w);
                System.out.println("---------------------");
            }
        }
    }

    private static void saveWorkoutToFile(Workout workout) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(workout.toCSV());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving workout: " + e.getMessage());
        }
    }

    private static void loadWorkoutsFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String name = parts[0];
                    int duration = Integer.parseInt(parts[1]);
                    int calories = Integer.parseInt(parts[2]);
                    String notes = parts[3];
                    LocalDate date = LocalDate.parse(parts[4]);
                    workouts.add(new Workout(name, duration, calories, notes, date));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading workouts: " + e.getMessage());
        }
    }
}

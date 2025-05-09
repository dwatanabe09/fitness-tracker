import java.time.LocalDate;

public class Workout {
    private String name;
    private int duration;
    private int caloriesBurned;
    private String notes;
    private LocalDate date;
    private String category;

    public Workout(String name, int duration, int caloriesBurned, String notes, LocalDate date, String category) {
        this.name = name;
        this.duration = duration;
        this.caloriesBurned = caloriesBurned;
        this.notes = notes;
        this.date = date;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Workout: " + name +
               "\nDuration: " + duration + " minutes" +
               "\nCalories Burned: " + caloriesBurned +
               "\nNotes: " + notes +
               "\nDate: " + date +
               "\nCategory: " + category;
    }

    public String toCSV() {
        return name + "," +
               duration + "," +
               caloriesBurned + "," +
               notes + "," +
               date + "," +
               category;
    }
    public String getCategory() {
        return category;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getDuration() {
        return duration;
    }

    public int getCaloriesBurned() {
        return caloriesBurned;
    }
}
}

import java.time.LocalDate;

public class Workout {
    private String name;
    private int duration;
    private int caloriesBurned;
    private String notes;
    private LocalDate date;

    public Workout(String name, int duration, int caloriesBurned, String notes, LocalDate date) {
        this.name = name;
        this.duration = duration;
        this.caloriesBurned = caloriesBurned;
        this.notes = notes;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Workout: " + name +
               "\nDuration: " + duration + " minutes" +
               "\nCalories Burned: " + caloriesBurned +
               "\nNotes: " + notes +
               "\nDate: " + date;
    }

    public String toCSV() {
        return name + "," +
               duration + "," +
               caloriesBurned + "," +
               notes + "," +
               date;
    }
}

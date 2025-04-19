public class Workout {
    private String name;
    private int duration;
    private int caloriesBurned;
    private String notes;

    public Workout(String name, int duration, int caloriesBurned, String notes) {
        this.name = name;
        this.duration = duration;
        this.caloriesBurned = caloriesBurned;
        this.notes = notes;
    }

    @Override

    public String toString() {
        return "Workout: " + name +
                "\nDuration: " + duration + " minutes" +
                "\nCalories Burned: " + caloriesBurned +
                "\nNotes: " + notes;
    }

}
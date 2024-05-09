
/**
 * Represents a running or walking exercise session.
 * Inherits properties and methods from the Exercise class.
 */
public class RunWalk extends Exercise {

    private double distance;
    /**
     * Constructor for creating a RunWalk object.
     *
     * @param name        The name of the person doing the exercise.
     * @param date        The date
     * @param duration    The duration of the exercise
     * @param distance    The distance covered
     * @param comment     Additional comments
     */
    public RunWalk(String name, String date, double duration, double distance, String comment) {
        super(name, date, duration, comment);
        setDistance(distance);
    }



    /**
     * Retrieves the distance covered during the exercise session.
     *
     * @return The distance
     */
    public double getDistance() {
        return distance;
    }


    /**
     * Sets the distance
     *
     * @param distance The distance
     * If the input is less than 0, the distance is set to 0.
     */
    public void setDistance(double distance) {
        if (distance < 0) {
            this.distance = 0;
        } else {
            this.distance = distance;
        }
    }


    @Override
    public String getType() {
        return "Run/Walk";
    }



    /**
     * Calculates the calories burned during the exercise
     * @return The number of calories burned, or 0 if duration is zero.
     */
    @Override
    public double getCaloriesBurned() {

        if (getDuration() == 0) return 0;
        return (getDistance() / getDuration()) * 9000;
    }


    /**
     * Provides a string representation of the exercise session.
     *
     * @return A formatted string with exercise details including name, type, date, duration, calories burned, and comments.
     */
    @Override
    public String toStringCustomInfo() {

        return String.format("%s\t%s\t%s\t%.2f\t%.2f", this.getName(),getType(),getDateAsString(),this.getDuration(),getCaloriesBurned(),getComment());
    }

}

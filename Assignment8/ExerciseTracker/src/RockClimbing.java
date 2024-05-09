/**
 * Represents a rock climbing exercise session.
 * Inherits properties and methods from the Exercise class.
 */


public class RockClimbing extends Exercise{

    private double height;
    private double timesClimbed = getDuration();




    /**
     * Constructor for creating a RockClimbing object.
     *
     * @param name        The name of the person doing the exercise.
     * @param date        The date on which the exercise was performed.
     * @param height      The height climbed during the exercise session in meters.
     * @param comment     Additional comments about the exercise session.
     */
    public RockClimbing(String name, String date, double height, String comment){
        super(name, date, height, comment);
        this.height = height;

    }

    public double getHeight(){
        return height;
    }


    public double getTimesClimbed() {
        return timesClimbed;
    }

    public void setTimesClimbed(double distance) {
        if (distance < 0) {
            this.timesClimbed = 0;
        } else {
            this.timesClimbed = timesClimbed;
        }
    }



    /**
     * Sets the height climbed during the exercise session.
     *
     * @param height The height to be set in meters.
     * If the input is less than 0, the height is set to 0.
     */
    public void setHeight(double height){
        if (height < 0){
            this.height = 0;

        }else {
            this.height = height;
        }
    }


    /**
     * Provides a string of exercise info.
     *
     * @return A formatted string with exercise details including name, type, date, height climbed, calories burned, and comments.
     */
    @Override
    public String toStringCustomInfo() {
        return String.format("%s\t%s\t%s\t%.2f\t%.2f", this.getName(),getType(),this.getDate(),this.getHeight(),getCaloriesBurned(),getComment());
    }



    @Override
    public String getType() {
        return "RockClimbing";
    }



    /**
     * Calculates the calories burned
     *
     * @return The number of calories burned.
     */
    @Override
    public double getCaloriesBurned() {
        return ((height * 1) * 100);
    }
}

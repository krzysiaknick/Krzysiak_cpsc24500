

/**
 * Represents a weight lifting exercise session.
 * Inherits properties and methods from the Exercise class.
 */


public class WeightLifting extends Exercise{

    private double weightLifted;




    /**
     * Constructor for creating a WeightLifting object.
     *
     * @param name        The name of the person doing the exercise.
     * @param date        The date on which the exercise was done.
     * @param duration    The duration of the exercise session in minutes.
     * @param weightLifted The weight lifted during the exercise in kilograms.
     * @param comment     Any additional comments about the exercise session.
     */

    public WeightLifting(String name, String date, double duration, double weightLifted, String comment){
        super(name,date,duration,comment);
        this.weightLifted = weightLifted;
    }


    public double getWeightLifted(){
        return weightLifted;

    }



    /**
     * Sets the weight lifted during the exercise session.
     *
     * @param weightLifted The weight to be set in kilograms.
     * If the input is less than 0, the weight lifted is set to 0.
     */


    public void setWeightLifted(double weightLifted){

        if (weightLifted < 0){
            this.weightLifted = 0;
        } else {
            this.weightLifted = weightLifted;
        }
    }


    /**
     *
     * @return A formatted string with exercise details including name, type, date, weight lifted, calories burned, and comments.
     */

    @Override
    public String toStringCustomInfo() {
        return String.format("%s\t%s\t%s\t%.2f\t%.2f", this.getName(),getType(),getDateAsString(),this.getWeightLifted(),getCaloriesBurned(),getComment());
    }

    @Override
    public String getType() {
        return "Weight Lifting";
    }

    @Override
    public double getCaloriesBurned() {
        return (getWeightLifted() / getDuration()) * 50 ;
    }
}

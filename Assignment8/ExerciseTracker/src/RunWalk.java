import java.util.Date;

public class RunWalk extends Exercise {

    private double distance;

    public RunWalk(String name, String date, double duration, double distance, String comment) {
        super(name, date, duration, comment);
        setDistance(distance);
    }




    public double getDistance() {
        return distance;
    }

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

    @Override
    public double getCaloriesBurned() {

        if (getDuration() == 0) return 0;
        return (getDistance() / getDuration()) * 9000;
    }

    @Override
    public String toStringCustomInfo() {

        return String.format("%s\t%s\t%s\t%.2f\t%.2f", this.getName(),getType(),getDateAsString(),this.getDuration(),getCaloriesBurned(),getComment());
    }

}

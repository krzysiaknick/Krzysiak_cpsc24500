import java.util.Date;
import java.text.SimpleDateFormat;

public abstract class Exercise implements Comparable<Exercise> {
	private String name;
	private Date date;
	private double duration;
	private String comment;
	//you can use another Date format
	private SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * sets date to current date
	 */
	public void setDate() {
		this.date = new Date(); // current date
	}
	public void setDate(String date) {
		try {
			this.date = df.parse(date);
		} catch (Exception ex) {
			this.date = new Date(); // now
		}
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		if (duration < 0) {
			this.duration = 0;
		} else {
			this.duration = duration;
		}
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Exercise() {
		name = "Exercise";
		setDate();
		setDuration(0);
		setComment("Unknown exercise");
	}
	public Exercise(String name, Date date, double duration, String comment) {
		setName(name);
		setDate(date);
		setDuration(duration);
		setComment(comment);
	}
	public Exercise(String name, String date, double duration, String comment) {
		setName(name);
		setDate(date);
		setDuration(duration);
		setComment(comment);
	}
	String getDateAsString() {
		return df.format(date);
	}
	/**
	 * generates tab-delimited String containing exercise-specific data 
	 * @return tab-delimited String of exercise-specific info
	 */
	public abstract String toStringCustomInfo();
	
	@Override
	public String toString() {
		return String.format("%s\t%s\t%s\t%.2f\t%s\t%.2f\t%s", name,getType(),getDateAsString(),duration,toStringCustomInfo(),getCaloriesBurned(),comment);
	}
	public abstract String getType();
	
	public abstract double getCaloriesBurned();
	
	@Override
	public int compareTo(Exercise other) {
		return this.date.compareTo(other.date);

	}
	public String toSummaryString() {
		return String.format("%-20s%-25s%-15s%10.2f",getType(),name,getDateAsString(),getCaloriesBurned());
	}
}

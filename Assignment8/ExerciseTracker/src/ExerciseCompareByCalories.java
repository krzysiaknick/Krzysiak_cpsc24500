public class ExerciseCompareByCalories implements Comparable<Exercise>{

    /**
     * Compares calories burned
     * @return compared calories burnt
     */
    @Override
    public int compareTo(Exercise o) {
        return Double.compare(o.getCaloriesBurned(), o.getCaloriesBurned());
    }
}

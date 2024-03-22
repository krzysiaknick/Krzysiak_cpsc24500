package a5;

public class Node {
    private static final int MIN_VALUE = -100;
    private static final int MAX_VALUE = 100;


    private int x;
    private int y;

    //default
    public Node() {
        this.x = 0;
        this.y = 0;
    }


    // Copy constructor
    public Node(Node other) {
        this.x = other.x;
        this.y = other.y;
    }

    // Two parameter constructor
    public Node(int x, int y){
        this.x = x;
        this.y = y;

    }


    /**
     * @return x value
     */
    public int getX() {
        return x;
    }


    /**
     * @return y value
     */
    public int getY() {
        return y;

    }


    /**
     *
     * @param newX the new x value
     * @throws IllegalArgumentException if new x value is out of bounds
     */
    public void setX(int newX){
        if (newX >= MIN_VALUE && newX <= MAX_VALUE){
            x = newX;

        }else {
            throw new IllegalArgumentException("Out of bounds.");
        }
    }


    /**
     *
     * @param newY the new y value
     * @throws IllegalArgumentException if  new y value is out of bounds
     */
    public void setY(int newY){
        if (newY >= MIN_VALUE && newY <= MAX_VALUE){
            y = newY;

        }else {
            throw new IllegalArgumentException("Out of bounds.");
        }
    }



    /**
     * adds x and y coordinates
     * @param other the coordinates that are being added
     * @throws IllegalArgumentException if out of bounds
     */

    public void add(Node other) {
        int newX = this.x + other.x;
        int newY = this.y + other.y;

        if (newX >= MIN_VALUE && newX <=MAX_VALUE && newY >= MIN_VALUE && newY <=MAX_VALUE ){
            this.x = newX;
            this.y = newY;

        }else {
            throw new IllegalArgumentException("Out of bounds.");
        }
    }


    @Override
    public String toString() {
        return "Node " + "x=" + x + ", y=" + y ;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Node node = (Node) obj;
        return x == node.x && y == node.y;
    }



    /**
     *
     * @param value value to validate
     * @throws IllegalArgumentException If value is out of range
     */
    private void validateValue(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException("Value must be within the range [" + MIN_VALUE + ", " + MAX_VALUE + "].");
        }

    }








}








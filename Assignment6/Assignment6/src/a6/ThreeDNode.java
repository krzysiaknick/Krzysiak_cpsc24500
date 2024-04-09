package a6;

public class ThreeDNode extends Node {
    public static final int LOWER_LIMIT = -100;
    public static final int UPPER_LIMIT =  100;

    private int z;

    // Default Constructor
    public ThreeDNode() throws Exception {
        super(0, 0); // Initialize x and y to 0 using Node's constructor
        this.z = 0;
    }

    // Constructor that accepts x, y, and z
    public ThreeDNode(int x, int y, int z) throws Exception {
        super(x, y); // Set x and y using Node's constructor
        setZ(z);
    }

    /**
     * Copy constructor
     *
     * @param other
     * @throws Exception
     */
    public ThreeDNode(ThreeDNode other) throws Exception {
        super(other.getX(), other.getY()); // Copy x and y from other node
        this.z = other.getZ();
    }



    public void add(ThreeDNode other) throws Exception {
        super.add(other); // Add x and y using Node's add method
        int newZ = this.z + other.getZ();
        if (!isValidZ(newZ)) {
            throw new Exception("Resulting z value is out of valid range.");
        }
        this.z = newZ;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false; // Check x and y equality in Node
        if (!(obj instanceof ThreeDNode)) return false;
        ThreeDNode other = (ThreeDNode) obj;
        return this.z == other.z;
    }

    public int getZ() {
        return z;
    }

    //checks for valid z
    private boolean isValidZ(int z) {
        return z >= LOWER_LIMIT && z <= UPPER_LIMIT;
    }

    public void setZ(int z) throws Exception {
        if (!isValidZ(z)) {
            throw new Exception("Invalid operation: z value should be in the range: [" + LOWER_LIMIT + "," + UPPER_LIMIT + "]");
        }
        this.z = z;
    }

    @Override
    public String toString() {
        return super.toString() + ", z=" + z;
    }
}


public class Star implements Comparable<Star>{
    public double x,y,z;

    public Star(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int compareTo(Star star) {
        return Double.compare(this.getDistance(), star.getDistance());
    }

    public double getDistance() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public String toString() {
        return "(" + x + "," + y + "," + z + ")";
    }
}

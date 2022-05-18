package entities;

public class CartesianCoordinates {
    private double x;
    private double y;

    public CartesianCoordinates(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getDistanceBetween(CartesianCoordinates other) {
        return Math.sqrt(
            Math.pow((other.getX() - this.getX()), 2) +
            Math.pow((other.getY() - this.getY()), 2)
        );
    }
}

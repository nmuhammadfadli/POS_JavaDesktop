package component.model.chart.spline;

public class splinePoint {

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

    public splinePoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public splinePoint() {
    }

    private double x;
    private double y;

    public splinePoint copy() {
        return new splinePoint(x, y);
    }
}

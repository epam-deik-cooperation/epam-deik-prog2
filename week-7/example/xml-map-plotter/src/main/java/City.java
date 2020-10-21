public class City {
    private double xCoordinate;
    private double yCoordinate;
    private String state;

    public City(double xCoordinate, double yCoordinate, String state) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.state = state;
    }

    public void plot(MapImage map) {
        map.addPoint(this.yCoordinate, this.xCoordinate);
    }
}

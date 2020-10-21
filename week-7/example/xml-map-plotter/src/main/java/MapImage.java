import java.io.Writer;

public interface MapImage {
    void addPoint(double x, double y);

    void save(Writer targetStream);
}

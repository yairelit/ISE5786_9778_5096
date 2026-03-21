package primitives;

public class Ray {
    private Point _origin;
    private Vector _direction;

    Ray(Point origin, Vector vector){
        _origin = origin;
        _direction = vector;
    }
}

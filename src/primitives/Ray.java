package primitives;

/**
 * Ray in 3D space defined by an origin point and a direction vector.
 * The direction vector is always kept normalized.
 */
public class Ray {
    private final Point _origin;
    private final Vector _direction;

    /**
     * Constructs a ray from an origin point and a direction vector.
     * The direction vector is normalized by the constructor.
     * @param origin   the origin point
     * @param direction the direction vector
     */
    public Ray(Point origin, Vector direction) {
        _origin = origin;
        _direction = direction.normalize();
    }

    /**
     * Returns the origin point of the ray.
     * @return the origin point
     */
    public Point origin() {
        return _origin;
    }

    /**
     * Returns the normalized direction vector of the ray.
     * @return the direction vector
     */
    public Vector direction() {
        return _direction;
    }
}

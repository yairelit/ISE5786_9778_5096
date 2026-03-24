package geometries.impl;

import geometries.api.Geometry;
import primitives.Point;
import primitives.Vector;

/**
 * Plane class represents an infinite plane in 3D space.
 * A plane is defined by a point on the plane and a normalized normal vector.
 */
public class Plane extends Geometry {
    /** A reference point that lies on the plane. */
    private final Point _q0;
    /** The normalized normal vector of the plane. */
    private final Vector _normal;

    /**
     * Constructs a plane from three non-collinear points.
     * @param p1 first point on the plane
     * @param p2 second point on the plane
     * @param p3 third point on the plane
     * @throws IllegalArgumentException if the three points are collinear
     */
    public Plane(Point p1, Point p2, Point p3) {
        Vector v1 = p2.subtract(p1);
        Vector v2 = p3.subtract(p1);
        _normal = v1.crossProduct(v2).normalize();
        _q0 = p1;
    }

    /**
     * Constructs a plane from a point and a normal vector.
     * The normal is normalized by the constructor.
     * @param point  a point on the plane
     * @param normal the normal vector to the plane
     */
    public Plane(Point point, Vector normal) {
        _q0 = point;
        _normal = normal.normalize();
    }

    @Override
    public Vector getNormal(Point point) {
        return _normal;
    }
}

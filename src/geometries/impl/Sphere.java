package geometries.impl;

import geometries.api.Geometry;
import primitives.Point;
import primitives.Vector;

/**
 * Sphere represents a ball in 3D space defined by a center point and radius.
 */
public class Sphere extends RadialGeometry {
    /** The center point of the sphere. */
    private final Point _center;

    /**
     * Constructs a sphere with the given center and radius.
     * @param center the center point of the sphere
     * @param radius the radius of the sphere
     */
    public Sphere(Point center, double radius) {
        super(radius);
        _center = center;
    }

    @Override
    public Vector getNormal(Point point) {
        // Normal is from center to the point on the surface
        return point.subtract(_center).normalize();
    }
}

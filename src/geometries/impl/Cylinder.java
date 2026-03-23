package geometries.impl;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

/**
 * Cylinder represents a finite cylindrical tube with a given height.
 */
public class Cylinder extends Tube {
    private final double _height;

    /**
     * Constructs a cylinder with the specified radius, axis ray, and height.
     * @param radius the radius of the cylinder
     * @param axis   the central axis ray of the cylinder
     * @param height the height of the cylinder
     */
    public Cylinder(double radius, Ray axis, double height) {
        super(radius, axis);
        _height = height;
    }

    @Override
    public Vector getNormal(Point point) {
        // Normal computation is not required for this stage; can be implemented later.
        return null;
    }
}

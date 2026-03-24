package geometries.impl;

import geometries.api.Geometry;
import primitives.Point;
import primitives.Ray;
import primitives.Vector;

/**
 * Tube represents an infinite cylindrical tube around an axis ray with a fixed radius.
 */
public class Tube extends RadialGeometry {
    /** The central axis ray around which the tube is defined. */
    private final Ray _axis;

    /**
     * Constructs a tube with the specified radius and axis ray.
     * @param radius the radius of the tube
     * @param axis   the central axis ray of the tube
     */
    public Tube(double radius, Ray axis) {
        super(radius);
        _axis = axis;
    }

    @Override
    public Vector getNormal(Point point) {
        // Normal computation is not required for this stage; can be implemented later.
        return null;
    }
}

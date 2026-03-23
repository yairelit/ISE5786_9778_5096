package geometries.impl;

import geometries.api.Geometry;

/**
 * Abstract base class for geometries defined by a radius.
 */
abstract class RadialGeometry extends Geometry {
    protected final double _radius;
    protected final double _radiusSquared;

    /**
     * Constructs a radial geometry with the specified radius.
     * @param radius the radius of the geometry
     * @throws IllegalArgumentException if the radius is not positive
     */
    public RadialGeometry(double radius) {
        if (radius <= 0)
            throw new IllegalArgumentException("Radius must be positive");
        _radius = radius;
        _radiusSquared = radius * radius;
    }

    public double getRadius() { return _radius; }

    public double get_radiusSquared() {
        return _radiusSquared;
    }
}

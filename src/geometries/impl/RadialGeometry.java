package geometries.impl;

import geometries.api.Geometry;

/**
 * Abstract base class for geometries defined by a radius.
 * <p>
 * Stores the radius value and its squared value for use by concrete
 * subclasses such as spheres, tubes and cylinders.
 * </p>
 */
abstract class RadialGeometry extends Geometry {
    /** The radius of the geometry. */
    protected final double _radius;
    /** Precomputed squared radius for efficient calculations. */
    protected final double _radiusSquared;

    /**
     * Constructs a radial geometry with the specified radius.
     *
     * @param radius the radius of the geometry
     * @throws IllegalArgumentException if the radius is not positive
     */
    public RadialGeometry(double radius) {
        if (radius <= 0)
            throw new IllegalArgumentException("Radius must be positive");
        _radius = radius;
        _radiusSquared = radius * radius;
    }

    /**
     * Returns the radius of this geometry.
     *
     * @return the radius value
     */
    public double getRadius() { return _radius; }

    /**
     * Returns the squared radius of this geometry.
     *
     * @return the squared radius value
     */
    public double get_radiusSquared() { return _radiusSquared; }
}

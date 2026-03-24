package primitives;

import static primitives.Util.alignZero;

/**
 * Represents an immutable point in 3D Euclidean space.
 * <p>
 * A point is defined by its three Cartesian coordinates, stored internally
 * as a {@link Double3}. Points are used as the fundamental location type in
 * all geometric computations.
 * </p>
 */
public class Point {

    /** The origin point (0,0,0) in the 3D coordinate system. */
    public static final Point ZERO = new Point(Double3.ZERO);
    /** The underlying triplet of coordinates of this point. */
    protected final Double3 _xyz;

    /**
     * Constructs a point from its three Cartesian coordinates.
     *
     * @param x x-coordinate
     * @param y y-coordinate
     * @param z z-coordinate
     */
    public Point(double x, double y, double z) { this._xyz = new Double3(x, y, z); }

    /**
     * Constructs a point from an existing coordinate triplet.
     * <p>
     * The given {@link Double3} instance is used as the internal representation
     * of this point's coordinates.
     * </p>
     *
     * @param xyz coordinate triplet representing this point
     */
    public Point(Double3 xyz) { this._xyz = xyz; }

    /**
     * Subtracts another point from this point to create a vector from the other point to this point.
     * @param other the point to subtract
     * @return a new {@link Vector} from {@code other} to this point
     * @throws IllegalArgumentException if the result is a zero vector (points are identical)
     */
    public Vector subtract(Point other) {
        Double3 diff = _xyz.subtract(other._xyz);
        // Creating a vector with zero coordinates is forbidden and will throw
        return new Vector(diff);
    }

    /**
     * Translates this point by the given vector.
     * @param vector the translation vector
     * @return a new {@link Point} that is the result of adding the vector to this point
     */
    public Point add(Vector vector) {
        return new Point(_xyz.add(vector._xyz));
    }

    /**
     * Computes the squared Euclidean distance between this point and another point.
     * @param other the other point
     * @return the squared distance between the two points
     */
    public double distanceSquared(Point other) {
        double dx = _xyz._d1() - other._xyz._d1();
        double dy = _xyz._d2() - other._xyz._d2();
        double dz = _xyz._d3() - other._xyz._d3();
        return dx * dx + dy * dy + dz * dz;
    }

    /**
     * Computes the Euclidean distance between this point and another point.
     * @param other the other point
     * @return the distance between the two points
     */
    public double distance(Point other) {
        return Math.sqrt(alignZero(distanceSquared(other)));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        return _xyz.equals(((Point)obj)._xyz);
    }

    @Override
    public int hashCode() { return _xyz.hashCode(); }

    @Override
    public String toString() { return "" + _xyz; }
}

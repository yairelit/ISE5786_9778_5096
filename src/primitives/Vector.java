package primitives;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;

/**
 * Represents an immutable vector in 3D Euclidean space.
 * <p>
 * A vector models a directed difference between two points and supports
 * the basic linear algebra operations used throughout the geometry package.
 * Zero vectors are explicitly forbidden and attempts to create or compute a
 * zero vector result in an {@link IllegalArgumentException}.
 * </p>
 */
public class Vector extends Point {

    /** Unit vector along X axis (1,0,0). */
    public static final Vector AXIS_X = new Vector(1, 0, 0);
    /** Unit vector along Y axis (0,1,0). */
    public static final Vector AXIS_Y = new Vector(0, 1, 0);
    /** Unit vector along Z axis (0,0,1). */
    public static final Vector AXIS_Z = new Vector(0, 0, 1);

    public Vector(double x, double y, double z) {
        super(x, y, z);
        if (_xyz.equals(Double3.ZERO))
            throw new IllegalArgumentException("Zero vector is not allowed");
    }

    public Vector(Double3 xyz) {
        super(xyz);
        if (xyz.equals(Double3.ZERO))
            throw new IllegalArgumentException("Zero vector is not allowed");
    }

    /**
     * Adds another vector to this vector.
     * @param rhs the vector to add
     * @return a new {@link Vector} representing the sum
     * @throws IllegalArgumentException if the result is the zero vector
     */
    public Vector add(Vector rhs) {
        return new Vector(_xyz.add(rhs._xyz));
    }

    /**
     * Subtracts another vector from this vector.
     * @param rhs the vector to subtract
     * @return a new {@link Vector} representing the difference
     * @throws IllegalArgumentException if the result is the zero vector
     */
    public Vector subtract(Vector rhs) {
        return new Vector(_xyz.subtract(rhs._xyz));
    }

    /**
     * Scales this vector by a scalar factor.
     * @param factor the scaling factor
     * @return a new {@link Vector} scaled by the given factor
     * @throws IllegalArgumentException if the result is the zero vector
     */
    public Vector scale(double factor) {
        if (isZero(factor))
            throw new IllegalArgumentException("Scaling by zero creates a zero vector");
        return new Vector(_xyz.scale(factor));
    }

    /**
     * Computes the cross product of this vector with another vector.
     * @param rhs the other vector
     * @return a new {@link Vector} containing the cross product
     * @throws IllegalArgumentException if the vectors are parallel and the result is the zero vector
     */
    public Vector crossProduct(Vector rhs) {
        double x1 = _xyz._d1(), y1 = _xyz._d2(), z1 = _xyz._d3();
        double x2 = rhs._xyz._d1(), y2 = rhs._xyz._d2(), z2 = rhs._xyz._d3();
        double cx = y1 * z2 - z1 * y2;
        double cy = z1 * x2 - x1 * z2;
        double cz = x1 * y2 - y1 * x2;
        if (isZero(cx) && isZero(cy) && isZero(cz))
            throw new IllegalArgumentException("Cross product of parallel vectors is zero");
        return new Vector(alignZero(cx), alignZero(cy), alignZero(cz));
    }

    /**
     * Computes the dot product of this vector with another vector.
     * @param rhs the other vector
     * @return the dot product as a {@code double}
     */
    public double dotProduct(Vector rhs) {
        return _xyz._d1() * rhs._xyz._d1() + _xyz._d2() * rhs._xyz._d2() + _xyz._d3() * rhs._xyz._d3();
    }

    /**
     * Computes the squared length (magnitude) of this vector.
     * @return the squared length
     */
    public double lengthSquared() {
        return dotProduct(this);
    }

    /**
     * Computes the length (magnitude) of this vector.
     * @return the length as a {@code double}
     */
    public double length() { return Math.sqrt(alignZero(lengthSquared())); }

    /**
     * Returns a normalized (unit length) vector in the same direction.
     * @return a new normalized {@link Vector}
     * @throws IllegalArgumentException if the vector is effectively zero
     */
    public Vector normalize() {
        double len = length();
        if (isZero(len))
            throw new IllegalArgumentException("Cannot normalize zero vector");
        return new Vector(_xyz.divide(len));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        return _xyz.equals(((Vector) obj)._xyz);
    }

    @Override
    public int hashCode() { return _xyz.hashCode(); }

    @Override
    public String toString() { return "" + _xyz; }
}

package geometries.api;

import primitives.Vector;
import primitives.Point;

/**
 * Abstract base class for all geometric objects in the scene graph.
 * <p>
 * Every geometry is required to provide a surface normal for any point on its
 * surface via the {@link #getNormal(Point)} method. Additional capabilities
 * such as intersection computations will be added in later stages.
 * </p>
 */
public abstract class Geometry {
    /**
     * Returns the normal vector to the geometry's surface at the given point.
     *
     * @param point a point on the surface
     * @return the normal vector at the given point
     */
    public abstract Vector getNormal(Point point);
}
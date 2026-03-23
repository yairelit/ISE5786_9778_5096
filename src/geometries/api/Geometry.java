package geometries.api;

import primitives.Vector;
import primitives.Point;

/**
 * Base class for all geometric objects in the scene.
 * Provides a common interface for querying surface normals.
 */
public abstract class Geometry {
    /**
     * Returns the normal vector to the geometry's surface at the given point.
     * @param point a point on the surface
     * @return the normal vector at the given point
     */
    public abstract Vector getNormal(Point point);
}
package com.nogenericgames.community.arrays;



import java.util.Arrays;

@Deprecated
public abstract class AbstractMultidimensionalArray implements Dimensional {

    /**
     * List of all the dimensional bounds
     */
    protected final int[] dimensions;

    /**
     * We need to cache what's in the int[] for direct math
     */
    protected final int dim1, dim2, dim3, dim4, dim5, dim6;

    /**
     * This is required so that implementers can create their data array using the precomputed size
     */
    protected final int totalSize;

    protected AbstractMultidimensionalArray(int... dimensions) {
        if (dimensions.length < 2 || dimensions.length > 6) {
            throw new IllegalArgumentException("Dimensions must be between 2 and 6.");
        };
        this.dimensions = dimensions;

        this.dim1 = dimensions[0];
        this.dim2 = dimensions.length > 1 ? dimensions[1] : 1;
        this.dim3 = dimensions.length > 2 ? dimensions[2] : 1;
        this.dim4 = dimensions.length > 3 ? dimensions[3] : 1;
        this.dim5 = dimensions.length > 4 ? dimensions[4] : 1;
        this.dim6 = dimensions.length > 5 ? dimensions[5] : 1;

        totalSize = dim1 * dim2 * dim3 * dim4 * dim5 * dim6;
    }
    @Override
    public int[] getDimensions() {
        return dimensions.clone();
    }

    /**
     * Checks bounds for 2D coordinates.
     *
     * @param x The X-coordinate.
     * @param y The Y-coordinate.
     * @throws IndexOutOfBoundsException if any coordinate is out of bounds.
     */
    protected void checkBounds(int x, int y) {
        if (x < 0 || x >= dimensions[0]) {
            throw new IndexOutOfBoundsException(
                    "Coordinate " + x + " out of bounds for dimension 0 (valid range: 0 to " + (dimensions[0] - 1) + ")."
            );
        }
        if (y < 0 || y >= dimensions[1]) {
            throw new IndexOutOfBoundsException(
                    "Coordinate " + y + " out of bounds for dimension 1 (valid range: 0 to " + (dimensions[1] - 1) + ")."
            );
        }
    }

    /**
     * Checks bounds for 3D coordinates.
     *
     * @param x The X-coordinate.
     * @param y The Y-coordinate.
     * @param z The Z-coordinate.
     * @throws IndexOutOfBoundsException if any coordinate is out of bounds.
     */
    protected void checkBounds(int x, int y, int z) {
        if (x < 0 || x >= dimensions[0]) {
            throw new IndexOutOfBoundsException(
                    "Coordinate " + x + " out of bounds for dimension 0 (valid range: 0 to " + (dimensions[0] - 1) + ")."
            );
        }
        if (y < 0 || y >= dimensions[1]) {
            throw new IndexOutOfBoundsException(
                    "Coordinate " + y + " out of bounds for dimension 1 (valid range: 0 to " + (dimensions[1] - 1) + ")."
            );
        }
        if (z < 0 || z >= dimensions[2]) {
            throw new IndexOutOfBoundsException(
                    "Coordinate " + z + " out of bounds for dimension 2 (valid range: 0 to " + (dimensions[2] - 1) + ")."
            );
        }
    }

    /**
     * Checks bounds for 4D coordinates.
     *
     * @param x The X-coordinate.
     * @param y The Y-coordinate.
     * @param z The Z-coordinate.
     * @param w The W-coordinate.
     * @throws IndexOutOfBoundsException if any coordinate is out of bounds.
     */
    protected void checkBounds(int x, int y, int z, int w) {
        if (x < 0 || x >= dimensions[0]) {
            throw new IndexOutOfBoundsException(
                    "Coordinate " + x + " out of bounds for dimension 0 (valid range: 0 to " + (dimensions[0] - 1) + ")."
            );
        }
        if (y < 0 || y >= dimensions[1]) {
            throw new IndexOutOfBoundsException(
                    "Coordinate " + y + " out of bounds for dimension 1 (valid range: 0 to " + (dimensions[1] - 1) + ")."
            );
        }
        if (z < 0 || z >= dimensions[2]) {
            throw new IndexOutOfBoundsException(
                    "Coordinate " + z + " out of bounds for dimension 2 (valid range: 0 to " + (dimensions[2] - 1) + ")."
            );
        }
        if (w < 0 || w >= dimensions[3]) {
            throw new IndexOutOfBoundsException(
                    "Coordinate " + w + " out of bounds for dimension 3 (valid range: 0 to " + (dimensions[3] - 1) + ")."
            );
        }
    }

    /**
     * Checks bounds for 5D coordinates.
     *
     * @param x The X-coordinate.
     * @param y The Y-coordinate.
     * @param z The Z-coordinate.
     * @param w The W-coordinate.
     * @param u The U-coordinate.
     * @throws IndexOutOfBoundsException if any coordinate is out of bounds.
     */
    protected void checkBounds(int x, int y, int z, int w, int u) {
        if (x < 0 || x >= dimensions[0]) {
            throw new IndexOutOfBoundsException(
                    "Coordinate " + x + " out of bounds for dimension 0 (valid range: 0 to " + (dimensions[0] - 1) + ")."
            );
        }
        if (y < 0 || y >= dimensions[1]) {
            throw new IndexOutOfBoundsException(
                    "Coordinate " + y + " out of bounds for dimension 1 (valid range: 0 to " + (dimensions[1] - 1) + ")."
            );
        }
        if (z < 0 || z >= dimensions[2]) {
            throw new IndexOutOfBoundsException(
                    "Coordinate " + z + " out of bounds for dimension 2 (valid range: 0 to " + (dimensions[2] - 1) + ")."
            );
        }
        if (w < 0 || w >= dimensions[3]) {
            throw new IndexOutOfBoundsException(
                    "Coordinate " + w + " out of bounds for dimension 3 (valid range: 0 to " + (dimensions[3] - 1) + ")."
            );
        }
        if (u < 0 || u >= dimensions[4]) {
            throw new IndexOutOfBoundsException(
                    "Coordinate " + u + " out of bounds for dimension 4 (valid range: 0 to " + (dimensions[4] - 1) + ")."
            );
        }
    }

    /**
     * Checks bounds for 6D coordinates.
     *
     * @param x The X-coordinate.
     * @param y The Y-coordinate.
     * @param z The Z-coordinate.
     * @param w The W-coordinate.
     * @param u The U-coordinate.
     * @param v The V-coordinate.
     * @throws IndexOutOfBoundsException if any coordinate is out of bounds.
     */
    protected void checkBounds(int x, int y, int z, int w, int u, int v) {
        if (x < 0 || x >= dimensions[0]) {
            throw new IndexOutOfBoundsException(
                    "Coordinate " + x + " out of bounds for dimension 0 (valid range: 0 to " + (dimensions[0] - 1) + ")."
            );
        }
        if (y < 0 || y >= dimensions[1]) {
            throw new IndexOutOfBoundsException(
                    "Coordinate " + y + " out of bounds for dimension 1 (valid range: 0 to " + (dimensions[1] - 1) + ")."
            );
        }
        if (z < 0 || z >= dimensions[2]) {
            throw new IndexOutOfBoundsException(
                    "Coordinate " + z + " out of bounds for dimension 2 (valid range: 0 to " + (dimensions[2] - 1) + ")."
            );
        }
        if (w < 0 || w >= dimensions[3]) {
            throw new IndexOutOfBoundsException(
                    "Coordinate " + w + " out of bounds for dimension 3 (valid range: 0 to " + (dimensions[3] - 1) + ")."
            );
        }
        if (u < 0 || u >= dimensions[4]) {
            throw new IndexOutOfBoundsException(
                    "Coordinate " + u + " out of bounds for dimension 4 (valid range: 0 to " + (dimensions[4] - 1) + ")."
            );
        }
        if (v < 0 || v >= dimensions[5]) {
            throw new IndexOutOfBoundsException(
                    "Coordinate " + v + " out of bounds for dimension 5 (valid range: 0 to " + (dimensions[5] - 1) + ")."
            );
        }
    }

    @Override
    public String toString() {
        return "AbstractMultidimensionalArray{" +
            "dimensions=" + Arrays.toString(dimensions) +
            ", totalSize=" + totalSize +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractMultidimensionalArray)) return false;
        AbstractMultidimensionalArray that = (AbstractMultidimensionalArray) o;
        return
            totalSize == that.totalSize &&
            Arrays.equals(dimensions, that.dimensions);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(dimensions);
        result = 31 * result + totalSize;
        return result;
    }

    /**
     * Implementations must provide a copy method.
     */
    public abstract AbstractMultidimensionalArray copy();

}

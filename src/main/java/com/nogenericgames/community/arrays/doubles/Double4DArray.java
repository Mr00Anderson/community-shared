package com.nogenericgames.community.arrays;

import java.util.Arrays;

/**
 * Represents a four-dimensional array of doubles.
 */
public class Double4DArray {

    private final double[] data;
    private final int xSize;
    private final int ySize;
    private final int zSize;
    private final int wSize;
    private final int totalSize;

    /**
     * Constructs a 4D DoubleArray with the specified dimensions.
     *
     * @param xSize Size of the X dimension.
     * @param ySize Size of the Y dimension.
     * @param zSize Size of the Z dimension.
     * @param wSize Size of the W dimension.
     * @throws IllegalArgumentException if any dimension is non-positive.
     */
    public Double4DArray(int xSize, int ySize, int zSize, int wSize) {
        if (xSize <= 0 || ySize <= 0 || zSize <= 0 || wSize <= 0) {
            throw new IllegalArgumentException("Dimensions must be positive.");
        }
        this.xSize = xSize;
        this.ySize = ySize;
        this.zSize = zSize;
        this.wSize = wSize;
        this.totalSize = xSize * ySize * zSize * wSize;
        this.data = new double[totalSize];
    }

    /**
     * Retrieves the element at the specified (x, y, z, w) coordinates with bounds checking.
     *
     * @param x The X-coordinate (dimension 0).
     * @param y The Y-coordinate (dimension 1).
     * @param z The Z-coordinate (dimension 2).
     * @param w The W-coordinate (dimension 3).
     * @return The double value at (x, y, z, w).
     * @throws IndexOutOfBoundsException if coordinates are out of bounds.
     */
    public double get(int x, int y, int z, int w) {
        checkBounds(x, y, z, w);
        return data[(x * ySize * zSize * wSize) + (y * zSize * wSize) + (z * wSize) + w];
    }

    /**
     * Sets the element at the specified (x, y, z, w) coordinates with bounds checking.
     *
     * @param x     The X-coordinate (dimension 0).
     * @param y     The Y-coordinate (dimension 1).
     * @param z     The Z-coordinate (dimension 2).
     * @param w     The W-coordinate (dimension 3).
     * @param value The double value to set.
     * @throws IndexOutOfBoundsException if coordinates are out of bounds.
     */
    public void set(int x, int y, int z, int w, double value) {
        checkBounds(x, y, z, w);
        data[(x * ySize * zSize * wSize) + (y * zSize * wSize) + (z * wSize) + w] = value;
    }

    /**
     * Retrieves the element at the specified (x, y, z, w) coordinates without bounds checking.
     *
     * @param x The X-coordinate (dimension 0).
     * @param y The Y-coordinate (dimension 1).
     * @param z The Z-coordinate (dimension 2).
     * @param w The W-coordinate (dimension 3).
     * @return The double value at (x, y, z, w).
     */
    public double getUnsafe(int x, int y, int z, int w) {
        return data[(x * ySize * zSize * wSize) + (y * zSize * wSize) + (z * wSize) + w];
    }

    /**
     * Sets the element at the specified (x, y, z, w) coordinates without bounds checking.
     *
     * @param x     The X-coordinate (dimension 0).
     * @param y     The Y-coordinate (dimension 1).
     * @param z     The Z-coordinate (dimension 2).
     * @param w     The W-coordinate (dimension 3).
     * @param value The double value to set.
     */
    public void setUnsafe(int x, int y, int z, int w, double value) {
        data[(x * ySize * zSize * wSize) + (y * zSize * wSize) + (z * wSize) + w] = value;
    }

    /**
     * Clears the array by setting all elements to 0.0.
     */
    public void clear() {
        Arrays.fill(data, 0.0);
    }

    /**
     * Retrieves a copy of the underlying data array.
     *
     * @return A new double array containing the data.
     */
    public double[] getData() {
        return data.clone();
    }

    /**
     * Fills the array with the specified double value.
     *
     * @param value The double value to fill the array with.
     */
    public void fill(double value) {
        Arrays.fill(data, value);
    }

    /**
     * Creates a copy of this Double4DArray.
     *
     * @return A new Double4DArray instance with copied data.
     */
    public Double4DArray copy() {
        Double4DArray copy = new Double4DArray(xSize, ySize, zSize, wSize);
        System.arraycopy(this.data, 0, copy.data, 0, this.totalSize);
        return copy;
    }

    /**
     * Returns the size of the X dimension.
     *
     * @return The size of X.
     */
    public int getXSize() {
        return xSize;
    }

    /**
     * Returns the size of the Y dimension.
     *
     * @return The size of Y.
     */
    public int getYSize() {
        return ySize;
    }

    /**
     * Returns the size of the Z dimension.
     *
     * @return The size of Z.
     */
    public int getZSize() {
        return zSize;
    }

    /**
     * Returns the size of the W dimension.
     *
     * @return The size of W.
     */
    public int getWSize() {
        return wSize;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Double4DArray{\n");
        for (int x = 0; x < xSize; x++) {
            sb.append("  Layer ").append(x).append(":\n");
            for (int y = 0; y < ySize; y++) {
                sb.append("    [");
                for (int z = 0; z < zSize; z++) {
                    sb.append(get(x, y, z, 0)); // Placeholder for w loop
                    if (z < zSize - 1) sb.append(", ");
                }
                sb.append("]\n");
            }
        }
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Double4DArray that = (Double4DArray) o;

        if (xSize != that.xSize) return false;
        if (ySize != that.ySize) return false;
        if (zSize != that.zSize) return false;
        if (wSize != that.wSize) return false;
        return Arrays.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(data);
        result = 31 * result + xSize;
        result = 31 * result + ySize;
        result = 31 * result + zSize;
        result = 31 * result + wSize;
        return result;
    }

    /**
     * Checks if the provided (x, y, z, w) coordinates are within bounds.
     *
     * @param x The X-coordinate (dimension 0).
     * @param y The Y-coordinate (dimension 1).
     * @param z The Z-coordinate (dimension 2).
     * @param w The W-coordinate (dimension 3).
     * @throws IndexOutOfBoundsException if coordinates are out of bounds.
     */
    private void checkBounds(int x, int y, int z, int w) {
        if (x < 0 || x >= xSize) {
            throw new IndexOutOfBoundsException(
                    "X-coordinate " + x + " out of bounds for dimension 0 (0 to " + (xSize - 1) + ")."
            );
        }
        if (y < 0 || y >= ySize) {
            throw new IndexOutOfBoundsException(
                    "Y-coordinate " + y + " out of bounds for dimension 1 (0 to " + (ySize - 1) + ")."
            );
        }
        if (z < 0 || z >= zSize) {
            throw new IndexOutOfBoundsException(
                    "Z-coordinate " + z + " out of bounds for dimension 2 (0 to " + (zSize - 1) + ")."
            );
        }
        if (w < 0 || w >= wSize) {
            throw new IndexOutOfBoundsException(
                    "W-coordinate " + w + " out of bounds for dimension 3 (0 to " + (wSize - 1) + ")."
            );
        }
    }
}

package com.nogenericgames.community.arrays.doubles;

import java.util.Arrays;

/**
 * Represents a two-dimensional array of doubles.
 */
public class Double2DArray {

    private final double[] data;
    private final int xSize;
    private final int ySize;
    private final int totalSize;

    /**
     * Constructs a 2D DoubleArray with the specified dimensions.
     *
     * @param xSize Size of the X dimension.
     * @param ySize Size of the Y dimension.
     * @throws IllegalArgumentException if any dimension is non-positive.
     */
    public Double2DArray(int xSize, int ySize) {
        if (xSize <= 0 || ySize <= 0) {
            throw new IllegalArgumentException("Dimensions must be positive.");
        }
        this.xSize = xSize;
        this.ySize = ySize;
        this.totalSize = xSize * ySize;
        this.data = new double[totalSize];
    }

    /**
     * Retrieves the element at the specified (x, y) coordinates with bounds checking.
     *
     * @param x The X-coordinate (dimension 0).
     * @param y The Y-coordinate (dimension 1).
     * @return The double value at (x, y).
     * @throws IndexOutOfBoundsException if coordinates are out of bounds.
     */
    public double get(int x, int y) {
        checkBounds(x, y);
        return data[x * ySize + y];
    }

    /**
     * Sets the element at the specified (x, y) coordinates with bounds checking.
     *
     * @param x     The X-coordinate (dimension 0).
     * @param y     The Y-coordinate (dimension 1).
     * @param value The double value to set.
     * @throws IndexOutOfBoundsException if coordinates are out of bounds.
     */
    public void set(int x, int y, double value) {
        checkBounds(x, y);
        data[x * ySize + y] = value;
    }

    /**
     * Retrieves the element at the specified (x, y) coordinates without bounds checking.
     *
     * @param x The X-coordinate (dimension 0).
     * @param y The Y-coordinate (dimension 1).
     * @return The double value at (x, y).
     */
    public double getUnsafe(int x, int y) {
        return data[x * ySize + y];
    }

    /**
     * Sets the element at the specified (x, y) coordinates without bounds checking.
     *
     * @param x     The X-coordinate (dimension 0).
     * @param y     The Y-coordinate (dimension 1).
     * @param value The double value to set.
     */
    public void setUnsafe(int x, int y, double value) {
        data[x * ySize + y] = value;
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
     * Creates a copy of this Double2DArray.
     *
     * @return A new Double2DArray instance with copied data.
     */
    public Double2DArray copy() {
        Double2DArray copy = new Double2DArray(xSize, ySize);
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Double2DArray{\n");
        for (int x = 0; x < xSize; x++) {
            sb.append(" [");
            for (int y = 0; y < ySize; y++) {
                sb.append(get(x, y));
                if (y < ySize - 1) sb.append(", ");
            }
            sb.append("]\n");
        }
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Double2DArray that = (Double2DArray) o;

        if (xSize != that.xSize) return false;
        if (ySize != that.ySize) return false;
        return Arrays.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(data);
        result = 31 * result + xSize;
        result = 31 * result + ySize;
        return result;
    }

    /**
     * Checks if the provided (x, y) coordinates are within bounds.
     *
     * @param x The X-coordinate (dimension 0).
     * @param y The Y-coordinate (dimension 1).
     * @throws IndexOutOfBoundsException if coordinates are out of bounds.
     */
    private void checkBounds(int x, int y) {
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
    }
}

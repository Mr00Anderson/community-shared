package com.nogenericgames.community.arrays.longs;

import java.util.Arrays;

/**
 * Represents a two-dimensional array of longs.
 */
public class Long2DArray {

    private final long[] data;
    private final int xSize;
    private final int ySize;
    private final int totalSize;

    /**
     * Constructs a 2D LongArray with the specified dimensions.
     *
     * @param xSize Size of the X dimension.
     * @param ySize Size of the Y dimension.
     * @throws IllegalArgumentException if any dimension is non-positive.
     */
    public Long2DArray(int xSize, int ySize) {
        if (xSize <= 0 || ySize <= 0) {
            throw new IllegalArgumentException("Dimensions must be positive.");
        }
        this.xSize = xSize;
        this.ySize = ySize;
        this.totalSize = xSize * ySize;
        this.data = new long[totalSize];
    }

    /**
     * Retrieves the element at the specified (x, y) coordinates with bounds checking.
     *
     * @param x The X-coordinate (dimension 0).
     * @param y The Y-coordinate (dimension 1).
     * @return The long value at (x, y).
     * @throws IndexOutOfBoundsException if coordinates are out of bounds.
     */
    public long get(int x, int y) {
        checkBounds(x, y);
        return data[x * ySize + y];
    }

    /**
     * Sets the element at the specified (x, y) coordinates with bounds checking.
     *
     * @param x     The X-coordinate (dimension 0).
     * @param y     The Y-coordinate (dimension 1).
     * @param value The long value to set.
     * @throws IndexOutOfBoundsException if coordinates are out of bounds.
     */
    public void set(int x, int y, long value) {
        checkBounds(x, y);
        data[x * ySize + y] = value;
    }

    /**
     * Retrieves the element at the specified (x, y) coordinates without bounds checking.
     *
     * @param x The X-coordinate (dimension 0).
     * @param y The Y-coordinate (dimension 1).
     * @return The long value at (x, y).
     */
    public long getUnsafe(int x, int y) {
        return data[x * ySize + y];
    }

    /**
     * Sets the element at the specified (x, y) coordinates without bounds checking.
     *
     * @param x     The X-coordinate (dimension 0).
     * @param y     The Y-coordinate (dimension 1).
     * @param value The long value to set.
     */
    public void setUnsafe(int x, int y, long value) {
        data[x * ySize + y] = value;
    }

    /**
     * Clears the array by setting all elements to 0.
     */
    public void clear() {
        Arrays.fill(data, 0L);
    }

    /**
     * Fills the array with the specified long value.
     *
     * @param value The long value to fill the array with.
     */
    public void fill(long value) {
        Arrays.fill(data, value);
    }

    /**
     * Retrieves a copy of the underlying data array.
     *
     * @return A new long array containing the data.
     */
    public long[] getData() {
        return data.clone();
    }

    /**
     * Creates a copy of this Long2DArray.
     *
     * @return A new Long2DArray instance with copied data.
     */
    public Long2DArray copy() {
        Long2DArray copy = new Long2DArray(xSize, ySize);
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
        StringBuilder sb = new StringBuilder("Long2DArray{\n");
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

        Long2DArray that = (Long2DArray) o;

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

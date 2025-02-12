package com.nogenericgames.community.arrays.longs;

import java.util.Arrays;

/**
 * Represents a three-dimensional array of longs.
 */
public class Long3DArray {

    private final long[] data;
    private final int xSize;
    private final int ySize;
    private final int zSize;
    private final int totalSize;

    /**
     * Constructs a 3D LongArray with the specified dimensions.
     *
     * @param xSize Size of the X dimension.
     * @param ySize Size of the Y dimension.
     * @param zSize Size of the Z dimension.
     * @throws IllegalArgumentException if any dimension is non-positive.
     */
    public Long3DArray(int xSize, int ySize, int zSize) {
        if (xSize <= 0 || ySize <= 0 || zSize <= 0) {
            throw new IllegalArgumentException("Dimensions must be positive.");
        }
        this.xSize = xSize;
        this.ySize = ySize;
        this.zSize = zSize;
        this.totalSize = xSize * ySize * zSize;
        this.data = new long[totalSize];
    }

    /**
     * Retrieves the element at the specified (x, y, z) coordinates with bounds checking.
     *
     * @param x The X-coordinate (dimension 0).
     * @param y The Y-coordinate (dimension 1).
     * @param z The Z-coordinate (dimension 2).
     * @return The long value at (x, y, z).
     * @throws IndexOutOfBoundsException if coordinates are out of bounds.
     */
    public long get(int x, int y, int z) {
        checkBounds(x, y, z);
        return data[(x * ySize * zSize) + (y * zSize) + z];
    }

    /**
     * Sets the element at the specified (x, y, z) coordinates with bounds checking.
     *
     * @param x     The X-coordinate (dimension 0).
     * @param y     The Y-coordinate (dimension 1).
     * @param z     The Z-coordinate (dimension 2).
     * @param value The long value to set.
     * @throws IndexOutOfBoundsException if coordinates are out of bounds.
     */
    public void set(int x, int y, int z, long value) {
        checkBounds(x, y, z);
        data[(x * ySize * zSize) + (y * zSize) + z] = value;
    }

    /**
     * Retrieves the element at the specified (x, y, z) coordinates without bounds checking.
     *
     * @param x The X-coordinate (dimension 0).
     * @param y The Y-coordinate (dimension 1).
     * @param z The Z-coordinate (dimension 2).
     * @return The long value at (x, y, z).
     */
    public long getUnsafe(int x, int y, int z) {
        return data[(x * ySize * zSize) + (y * zSize) + z];
    }

    /**
     * Sets the element at the specified (x, y, z) coordinates without bounds checking.
     *
     * @param x     The X-coordinate (dimension 0).
     * @param y     The Y-coordinate (dimension 1).
     * @param z     The Z-coordinate (dimension 2).
     * @param value The long value to set.
     */
    public void setUnsafe(int x, int y, int z, long value) {
        data[(x * ySize * zSize) + (y * zSize) + z] = value;
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
     * Creates a copy of this Long3DArray.
     *
     * @return A new Long3DArray instance with copied data.
     */
    public Long3DArray copy() {
        Long3DArray copy = new Long3DArray(xSize, ySize, zSize);
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Long3DArray{\n");
        for (int x = 0; x < xSize; x++) {
            sb.append("  Layer ").append(x).append(":\n");
            for (int y = 0; y < ySize; y++) {
                sb.append("    [");
                for (int z = 0; z < zSize; z++) {
                    sb.append(get(x, y, z));
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

        Long3DArray that = (Long3DArray) o;

        if (xSize != that.xSize) return false;
        if (ySize != that.ySize) return false;
        if (zSize != that.zSize) return false;
        return Arrays.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(data);
        result = 31 * result + xSize;
        result = 31 * result + ySize;
        result = 31 * result + zSize;
        return result;
    }

    /**
     * Checks if the provided (x, y, z) coordinates are within bounds.
     *
     * @param x The X-coordinate (dimension 0).
     * @param y The Y-coordinate (dimension 1).
     * @param z The Z-coordinate (dimension 2).
     * @throws IndexOutOfBoundsException if coordinates are out of bounds.
     */
    private void checkBounds(int x, int y, int z) {
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
    }
}

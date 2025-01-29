package com.nogenericgames.community.arrays.longs;

import java.util.Arrays;

/**
 * Represents a six-dimensional array of longs.
 */
public class Long6DArray {

    private final long[] data;
    private final int xSize;
    private final int ySize;
    private final int zSize;
    private final int wSize;
    private final int uSize;
    private final int vSize;
    private final int totalSize;

    /**
     * Constructs a 6D LongArray with the specified dimensions.
     *
     * @param xSize Size of the X dimension.
     * @param ySize Size of the Y dimension.
     * @param zSize Size of the Z dimension.
     * @param wSize Size of the W dimension.
     * @param uSize Size of the U dimension.
     * @param vSize Size of the V dimension.
     * @throws IllegalArgumentException if any dimension is non-positive.
     */
    public Long6DArray(int xSize, int ySize, int zSize, int wSize, int uSize, int vSize) {
        if (xSize <= 0 || ySize <= 0 || zSize <= 0 || wSize <= 0 || uSize <= 0 || vSize <= 0) {
            throw new IllegalArgumentException("Dimensions must be positive.");
        }
        this.xSize = xSize;
        this.ySize = ySize;
        this.zSize = zSize;
        this.wSize = wSize;
        this.uSize = uSize;
        this.vSize = vSize;
        this.totalSize = xSize * ySize * zSize * wSize * uSize * vSize;
        this.data = new long[totalSize];
    }

    /**
     * Retrieves the element at the specified (x, y, z, w, u, v) coordinates with bounds checking.
     *
     * @param x The X-coordinate (dimension 0).
     * @param y The Y-coordinate (dimension 1).
     * @param z The Z-coordinate (dimension 2).
     * @param w The W-coordinate (dimension 3).
     * @param u The U-coordinate (dimension 4).
     * @param v The V-coordinate (dimension 5).
     * @return The long value at (x, y, z, w, u, v).
     * @throws IndexOutOfBoundsException if coordinates are out of bounds.
     */
    public long get(int x, int y, int z, int w, int u, int v) {
        checkBounds(x, y, z, w, u, v);
        return data[(x * ySize * zSize * wSize * uSize * vSize) +
                    (y * zSize * wSize * uSize * vSize) +
                    (z * wSize * uSize * vSize) +
                    (w * uSize * vSize) +
                    (u * vSize) +
                    v];
    }

    /**
     * Sets the element at the specified (x, y, z, w, u, v) coordinates with bounds checking.
     *
     * @param x     The X-coordinate (dimension 0).
     * @param y     The Y-coordinate (dimension 1).
     * @param z     The Z-coordinate (dimension 2).
     * @param w     The W-coordinate (dimension 3).
     * @param u     The U-coordinate (dimension 4).
     * @param v     The V-coordinate (dimension 5).
     * @param value The long value to set.
     * @throws IndexOutOfBoundsException if coordinates are out of bounds.
     */
    public void set(int x, int y, int z, int w, int u, int v, long value) {
        checkBounds(x, y, z, w, u, v);
        data[(x * ySize * zSize * wSize * uSize * vSize) +
             (y * zSize * wSize * uSize * vSize) +
             (z * wSize * uSize * vSize) +
             (w * uSize * vSize) +
             (u * vSize) +
             v] = value;
    }

    /**
     * Retrieves the element at the specified (x, y, z, w, u, v) coordinates without bounds checking.
     *
     * @param x The X-coordinate (dimension 0).
     * @param y The Y-coordinate (dimension 1).
     * @param z The Z-coordinate (dimension 2).
     * @param w The W-coordinate (dimension 3).
     * @param u The U-coordinate (dimension 4).
     * @param v The V-coordinate (dimension 5).
     * @return The long value at (x, y, z, w, u, v).
     */
    public long getUnsafe(int x, int y, int z, int w, int u, int v) {
        return data[(x * ySize * zSize * wSize * uSize * vSize) +
                    (y * zSize * wSize * uSize * vSize) +
                    (z * wSize * uSize * vSize) +
                    (w * uSize * vSize) +
                    (u * vSize) +
                    v];
    }

    /**
     * Sets the element at the specified (x, y, z, w, u, v) coordinates without bounds checking.
     *
     * @param x     The X-coordinate (dimension 0).
     * @param y     The Y-coordinate (dimension 1).
     * @param z     The Z-coordinate (dimension 2).
     * @param w     The W-coordinate (dimension 3).
     * @param u     The U-coordinate (dimension 4).
     * @param v     The V-coordinate (dimension 5).
     * @param value The long value to set.
     */
    public void setUnsafe(int x, int y, int z, int w, int u, int v, long value) {
        data[(x * ySize * zSize * wSize * uSize * vSize) +
             (y * zSize * wSize * uSize * vSize) +
             (z * wSize * uSize * vSize) +
             (w * uSize * vSize) +
             (u * vSize) +
             v] = value;
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
     * Creates a copy of this Long6DArray.
     *
     * @return A new Long6DArray instance with copied data.
     */
    public Long6DArray copy() {
        Long6DArray copy = new Long6DArray(xSize, ySize, zSize, wSize, uSize, vSize);
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

    /**
     * Returns the size of the U dimension.
     *
     * @return The size of U.
     */
    public int getUSize() {
        return uSize;
    }

    /**
     * Returns the size of the V dimension.
     *
     * @return The size of V.
     */
    public int getVSize() {
        return vSize;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Long6DArray{\n");
        for (int x = 0; x < xSize; x++) {
            sb.append("  Hyperlayer ").append(x).append(":\n");
            for (int y = 0; y < ySize; y++) {
                sb.append("    Layer ").append(y).append(":\n");
                for (int z = 0; z < zSize; z++) {
                    sb.append("      [");
                    for (int w = 0; w < wSize; w++) {
                        sb.append(get(x, y, z, w, 0, 0)); // Placeholder for u and v loops
                        if (w < wSize - 1) sb.append(", ");
                    }
                    sb.append("]\n");
                }
            }
        }
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Long6DArray that = (Long6DArray) o;

        if (xSize != that.xSize) return false;
        if (ySize != that.ySize) return false;
        if (zSize != that.zSize) return false;
        if (wSize != that.wSize) return false;
        if (uSize != that.uSize) return false;
        if (vSize != that.vSize) return false;
        return Arrays.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(data);
        result = 31 * result + xSize;
        result = 31 * result + ySize;
        result = 31 * result + zSize;
        result = 31 * result + wSize;
        result = 31 * result + uSize;
        result = 31 * result + vSize;
        return result;
    }

    /**
     * Checks if the provided (x, y, z, w, u, v) coordinates are within bounds.
     *
     * @param x The X-coordinate (dimension 0).
     * @param y The Y-coordinate (dimension 1).
     * @param z The Z-coordinate (dimension 2).
     * @param w The W-coordinate (dimension 3).
     * @param u The U-coordinate (dimension 4).
     * @param v The V-coordinate (dimension 5).
     * @throws IndexOutOfBoundsException if coordinates are out of bounds.
     */
    private void checkBounds(int x, int y, int z, int w, int u, int v) {
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
        if (u < 0 || u >= uSize) {
            throw new IndexOutOfBoundsException(
                    "U-coordinate " + u + " out of bounds for dimension 4 (0 to " + (uSize - 1) + ")."
            );
        }
        if (v < 0 || v >= vSize) {
            throw new IndexOutOfBoundsException(
                    "V-coordinate " + v + " out of bounds for dimension 5 (0 to " + (vSize - 1) + ")."
            );
        }
    }
}

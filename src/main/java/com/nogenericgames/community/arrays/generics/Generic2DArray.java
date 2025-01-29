package com.nogenericgames.community.arrays.generics;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Represents a generic two-dimensional array.
 *
 * @param <T> The type of elements stored in the array.
 */
public class Generic2DArray<T> {

    private final T[] data;
    private final Class<T> type;
    private final int xSize;
    private final int ySize;
    private final int totalSize;

    /**
     * Constructs a 2D GenericArray with the specified type and dimensions.
     *
     * @param type  The Class object of the generic type T.
     * @param xSize Size of the X dimension.
     * @param ySize Size of the Y dimension.
     * @throws IllegalArgumentException if any dimension is non-positive.
     */
    public Generic2DArray(Class<T> type, int xSize, int ySize) {
        if (xSize <= 0 || ySize <= 0) {
            throw new IllegalArgumentException("Dimensions must be positive.");
        }
        this.type = type;
        this.xSize = xSize;
        this.ySize = ySize;
        this.totalSize = xSize * ySize;
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) Array.newInstance(type, totalSize);
        this.data = temp;
    }

    /**
     * Retrieves the element at the specified (x, y) coordinates with bounds checking.
     *
     * @param x The X-coordinate (dimension 0).
     * @param y The Y-coordinate (dimension 1).
     * @return The element at (x, y).
     * @throws IndexOutOfBoundsException if coordinates are out of bounds.
     */
    public T get(int x, int y) {
        checkBounds(x, y);
        return data[x * ySize + y];
    }

    /**
     * Sets the element at the specified (x, y) coordinates with bounds checking.
     *
     * @param x     The X-coordinate (dimension 0).
     * @param y     The Y-coordinate (dimension 1).
     * @param value The value to set.
     * @throws IndexOutOfBoundsException if coordinates are out of bounds.
     */
    public void set(int x, int y, T value) {
        checkBounds(x, y);
        data[x * ySize + y] = value;
    }

    /**
     * Retrieves the element at the specified (x, y) coordinates without bounds checking.
     *
     * @param x The X-coordinate (dimension 0).
     * @param y The Y-coordinate (dimension 1).
     * @return The element at (x, y).
     */
    public T getUnsafe(int x, int y) {
        return data[x * ySize + y];
    }

    /**
     * Sets the element at the specified (x, y) coordinates without bounds checking.
     *
     * @param x     The X-coordinate (dimension 0).
     * @param y     The Y-coordinate (dimension 1).
     * @param value The value to set.
     */
    public void setUnsafe(int x, int y, T value) {
        data[x * ySize + y] = value;
    }

    /**
     * Clears the array by setting all elements to null.
     */
    public void clear() {
        Arrays.fill(data, null);
    }

    /**
     * Retrieves the underlying data array.
     *
     * @return A clone of the data array.
     */
    public T[] getData() {
        return data.clone();
    }

    /**
     * Fills the array with the specified value.
     *
     * @param value The value to fill the array with.
     */
    public void fill(T value) {
        Arrays.fill(data, value);
    }

    /**
     * Creates a copy of this Generic2DArray.
     *
     * @return A new Generic2DArray instance with copied data.
     */
    public Generic2DArray<T> copy() {
        Generic2DArray<T> copy = new Generic2DArray<>(type, xSize, ySize);
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
        StringBuilder sb = new StringBuilder("Generic2DArray{\n");
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

        Generic2DArray<?> that = (Generic2DArray<?>) o;

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

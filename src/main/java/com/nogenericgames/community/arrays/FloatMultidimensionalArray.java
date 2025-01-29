package com.nogenericgames.community.arrays;

import java.util.Arrays;

/**
 * FloatMultidimensionalArray - Provides a flat array structure for multidimensional data with 2D to 6D access methods.
 * <p>
 * This implementation uses individual fields for dimensions to avoid array indirection during index calculation.
 */
@Deprecated
public class FloatMultidimensionalArray extends AbstractMultidimensionalArray {

    private final float[] data;

    public FloatMultidimensionalArray(int... dimensions) {
        super(dimensions);
        if (dimensions.length < 2 || dimensions.length > 6) {
            throw new IllegalArgumentException("Dimensions must be between 2 and 6.");
        }
        this.data = new float[totalSize];
    }

    // 2D Methods
    public float get(int x, int y) {
        checkBounds(x, y);
        return data[x * dim2 + y];
    }

    public void set(int x, int y, float value) {
        checkBounds(x, y);
        data[x * dim2 + y] = value;
    }

    public float getUnsafe(int x, int y) {
        return data[x * dim2 + y];
    }

    public void setUnsafe(int x, int y, float value) {
        data[x * dim2 + y] = value;
    }

    // 3D Methods
    public float get(int x, int y, int z) {
        checkBounds(x, y, z);
        return data[x * dim2 * dim3 + y * dim3 + z];
    }

    public void set(int x, int y, int z, float value) {
        checkBounds(x, y, z);
        data[x * dim2 * dim3 + y * dim3 + z] = value;
    }

    public float getUnsafe(int x, int y, int z) {
        return data[x * dim2 * dim3 + y * dim3 + z];
    }

    public void setUnsafe(int x, int y, int z, float value) {
        data[x * dim2 * dim3 + y * dim3 + z] = value;
    }

    // 4D Methods
    public float get(int x, int y, int z, int w) {
        checkBounds(x, y, z, w);
        return data[x * dim2 * dim3 * dim4 + y * dim3 * dim4 + z * dim4 + w];
    }

    public void set(int x, int y, int z, int w, float value) {
        checkBounds(x, y, z, w);
        data[x * dim2 * dim3 * dim4 + y * dim3 * dim4 + z * dim4 + w] = value;
    }

    public float getUnsafe(int x, int y, int z, int w) {
        return data[x * dim2 * dim3 * dim4 + y * dim3 * dim4 + z * dim4 + w];
    }

    public void setUnsafe(int x, int y, int z, int w, float value) {
        data[x * dim2 * dim3 * dim4 + y * dim3 * dim4 + z * dim4 + w] = value;
    }

    // 5D Methods
    public float get(int x, int y, int z, int w, int u) {
        checkBounds(x, y, z, w, u);
        return data[x * dim2 * dim3 * dim4 * dim5 + y * dim3 * dim4 * dim5 + z * dim4 * dim5 + w * dim5 + u];
    }

    public void set(int x, int y, int z, int w, int u, float value) {
        checkBounds(x, y, z, w, u);
        data[x * dim2 * dim3 * dim4 * dim5 + y * dim3 * dim4 * dim5 + z * dim4 * dim5 + w * dim5 + u] = value;
    }

    public float getUnsafe(int x, int y, int z, int w, int u) {
        return data[x * dim2 * dim3 * dim4 * dim5 + y * dim3 * dim4 * dim5 + z * dim4 * dim5 + w * dim5 + u];
    }

    public void setUnsafe(int x, int y, int z, int w, int u, float value) {
        data[x * dim2 * dim3 * dim4 * dim5 + y * dim3 * dim4 * dim5 + z * dim4 * dim5 + w * dim5 + u] = value;
    }

    // 6D Methods
    public float get(int x, int y, int z, int w, int u, int v) {
        checkBounds(x, y, z, w, u, v);
        return data[x * dim2 * dim3 * dim4 * dim5 * dim6 + y * dim3 * dim4 * dim5 * dim6 + z * dim4 * dim5 * dim6 + w * dim5 * dim6 + u * dim6 + v];
    }

    public void set(int x, int y, int z, int w, int u, int v, float value) {
        checkBounds(x, y, z, w, u, v);
        data[x * dim2 * dim3 * dim4 * dim5 * dim6 + y * dim3 * dim4 * dim5 * dim6 + z * dim4 * dim5 * dim6 + w * dim5 * dim6 + u * dim6 + v] = value;
    }

    public float getUnsafe(int x, int y, int z, int w, int u, int v) {
        return data[x * dim2 * dim3 * dim4 * dim5 * dim6 + y * dim3 * dim4 * dim5 * dim6 + z * dim4 * dim5 * dim6 + w * dim5 * dim6 + u * dim6 + v];
    }

    public void setUnsafe(int x, int y, int z, int w, int u, int v, float value) {
        data[x * dim2 * dim3 * dim4 * dim5 * dim6 + y * dim3 * dim4 * dim5 * dim6 + z * dim4 * dim5 * dim6 + w * dim5 * dim6 + u * dim6 + v] = value;
    }

    public void clear() {
        Arrays.fill(data, 0);
    }

    public float[] getData() {
        return data;
    }

    public FloatMultidimensionalArray copy() {
        FloatMultidimensionalArray copy = new FloatMultidimensionalArray(dimensions);
        System.arraycopy(data, 0, copy.data, 0, data.length);
        return copy;
    }

    @Override
    public String toString() {
        return "FloatMultidimensionalArray{" +
                "dimensions=" + Arrays.toString(dimensions) +
                ", data=" + Arrays.toString(data) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FloatMultidimensionalArray)) return false;
        FloatMultidimensionalArray that = (FloatMultidimensionalArray) o;
        return Arrays.equals(dimensions, that.dimensions) &&
                Arrays.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(dimensions);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }

    public void fill(float value) {
        Arrays.fill(data, value);
    }
}
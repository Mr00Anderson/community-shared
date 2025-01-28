package com.nogenericgames.community.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class GenericMultidimensionalArray<T> extends AbstractMultidimensionalArray {

    private final T[] data;
    private final Class<T> type;

    public GenericMultidimensionalArray(Class<T> type, int... dimensions) {
        super(dimensions);
        this.type = type;
        @SuppressWarnings("unchecked")
        T[] temp = (T[]) Array.newInstance(type, totalSize);
        this.data = temp;
    }

    // 2D Methods
    public T get(int x, int y) {
        checkBounds(x, y);
        return data[x * dim2 + y];
    }

    public void set(int x, int y, T value) {
        checkBounds(x, y);
        data[x * dim2 + y] = value;
    }

    public T getUnsafe(int x, int y) {
        return data[x * dim2 + y];
    }

    public void setUnsafe(int x, int y, T value) {
        data[x * dim2 + y] = value;
    }

    // 3D Methods
    public T get(int x, int y, int z) {
        checkBounds(x, y, z);
        return data[x * dim2 * dim3 + y * dim3 + z];
    }

    public void set(int x, int y, int z, T value) {
        checkBounds(x, y, z);
        data[x * dim2 * dim3 + y * dim3 + z] = value;
    }

    public T getUnsafe(int x, int y, int z) {
        return data[x * dim2 * dim3 + y * dim3 + z];
    }

    public void setUnsafe(int x, int y, int z, T value) {
        data[x * dim2 * dim3 + y * dim3 + z] = value;
    }

    // 4D Methods
    public T get(int x, int y, int z, int w) {
        checkBounds(x, y, z, w);
        return data[x * dim2 * dim3 * dim4 + y * dim3 * dim4 + z * dim4 + w];
    }

    public void set(int x, int y, int z, int w, T value) {
        checkBounds(x, y, z, w);
        data[x * dim2 * dim3 * dim4 + y * dim3 * dim4 + z * dim4 + w] = value;
    }

    public T getUnsafe(int x, int y, int z, int w) {
        return data[x * dim2 * dim3 * dim4 + y * dim3 * dim4 + z * dim4 + w];
    }

    public void setUnsafe(int x, int y, int z, int w, T value) {
        data[x * dim2 * dim3 * dim4 + y * dim3 * dim4 + z * dim4 + w] = value;
    }

    // 5D Methods
    public T get(int x, int y, int z, int w, int u) {
        checkBounds(x, y, z, w, u);
        return data[x * dim2 * dim3 * dim4 * dim5 + y * dim3 * dim4 * dim5 + z * dim4 * dim5 + w * dim5 + u];
    }

    public void set(int x, int y, int z, int w, int u, T value) {
        checkBounds(x, y, z, w, u);
        data[x * dim2 * dim3 * dim4 * dim5 + y * dim3 * dim4 * dim5 + z * dim4 * dim5 + w * dim5 + u] = value;
    }

    public T getUnsafe(int x, int y, int z, int w, int u) {
        return data[x * dim2 * dim3 * dim4 * dim5 + y * dim3 * dim4 * dim5 + z * dim4 * dim5 + w * dim5 + u];
    }

    public void setUnsafe(int x, int y, int z, int w, int u, T value) {
        data[x * dim2 * dim3 * dim4 * dim5 + y * dim3 * dim4 * dim5 + z * dim4 * dim5 + w * dim5 + u] = value;
    }

    // 6D Methods
    public T get(int x, int y, int z, int w, int u, int v) {
        checkBounds(x, y, z, w, u, v);
        return data[x * dim2 * dim3 * dim4 * dim5 * dim6 +
                y * dim3 * dim4 * dim5 * dim6 +
                z * dim4 * dim5 * dim6 +
                w * dim5 * dim6 +
                u * dim6 + v];
    }

    public void set(int x, int y, int z, int w, int u, int v, T value) {
        checkBounds(x, y, z, w, u, v);
        data[x * dim2 * dim3 * dim4 * dim5 * dim6 +
                y * dim3 * dim4 * dim5 * dim6 +
                z * dim4 * dim5 * dim6 +
                w * dim5 * dim6 +
                u * dim6 + v] = value;
    }

    public T getUnsafe(int x, int y, int z, int w, int u, int v) {
        return data[x * dim2 * dim3 * dim4 * dim5 * dim6 +
                y * dim3 * dim4 * dim5 * dim6 +
                z * dim4 * dim5 * dim6 +
                w * dim5 * dim6 +
                u * dim6 + v];
    }

    public void setUnsafe(int x, int y, int z, int w, int u, int v, T value) {
        data[x * dim2 * dim3 * dim4 * dim5 * dim6 +
                y * dim3 * dim4 * dim5 * dim6 +
                z * dim4 * dim5 * dim6 +
                w * dim5 * dim6 +
                u * dim6 + v] = value;
    }

    public void clear() {
        Arrays.fill(data, null);
    }

    public T[] getData() {
        return data;
    }

    public void fill(T value) {
        Arrays.fill(data, value);
    }

    @Override
    public GenericMultidimensionalArray<T> copy() {
        GenericMultidimensionalArray<T> copy = new GenericMultidimensionalArray<>(type, dimensions);
        System.arraycopy(data, 0, copy.data, 0, data.length);
        return copy;
    }

    @Override
    public String toString() {
        return "GenericMultidimensionalArray{" +
                "dimensions=" + Arrays.toString(dimensions) +
                ", data=" + Arrays.toString(data) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GenericMultidimensionalArray)) return false;
        GenericMultidimensionalArray<?> that = (GenericMultidimensionalArray<?>) o;
        return
                Arrays.equals(dimensions, that.dimensions) &&
                Arrays.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(dimensions);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }
}
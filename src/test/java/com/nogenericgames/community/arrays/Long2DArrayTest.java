package com.nogenericgames.community.arrays;

import com.nogenericgames.community.arrays.longs.Long2DArray;

/**
 * JUnit test class for Long2DArray.
 */
public class Long2DArrayTest extends AbstractLongArrayTest {

    @Override
    protected Object createArray(int... dimensions) {
        if (dimensions.length < 2) {
            throw new IllegalArgumentException("Long2DArray requires at least 2 dimensions (x, y).");
        }
        return new Long2DArray(dimensions[0], dimensions[1]);
    }

    @Override
    protected ArrayGetter getMethod() {
        return (array, indices) -> ((Long2DArray) array).get(indices[0], indices[1]);
    }

    @Override
    protected ArraySetter setMethod() {
        return (array, value, indices) -> ((Long2DArray) array).set(indices[0], indices[1], value);
    }

    @Override
    protected ArrayUnsafeGetter getUnsafeMethod() {
        return (array, indices) -> ((Long2DArray) array).getUnsafe(indices[0], indices[1]);
    }

    @Override
    protected ArrayUnsafeSetter setUnsafeMethod() {
        return (array, value, indices) -> ((Long2DArray) array).setUnsafe(indices[0], indices[1], value);
    }

    @Override
    protected ArrayClearer clearMethod() {
        return (array) -> ((Long2DArray) array).clear();
    }

    @Override
    protected ArrayFiller fillMethod() {
        return (array, value) -> ((Long2DArray) array).fill(value);
    }

    @Override
    protected ArrayCopier copyMethod() {
        return (array) -> ((Long2DArray) array).copy();
    }

    @Override
    protected String expectedToString() {
        // After setting indices1 to 1 and indices2 to 2, the expected string should reflect those changes
        return "Long2DArray{\n" +
               " [1, 0, 0]\n" +
               " [0, 2, 0]\n" +
               " [0, 0, 0]\n" +
               "}";
    }

    @Override
    protected int[] getTestDimensions() {
        return new int[]{3, 3, 1, 1, 1, 1}; // Only first two dimensions are used
    }

    @Override
    protected int[][] getInvalidDimensions() {
        return new int[][]{
            {0, 3, 1, 1, 1, 1},  // xSize <= 0
            {3, -1, 1, 1, 1, 1}  // ySize <= 0
        };
    }

    @Override
    protected int[] getSampleIndices1() {
        return new int[]{0, 0, 0, 0, 0, 0}; // x=0, y=0
    }

    @Override
    protected int[] getSampleIndices2() {
        return new int[]{1, 1, 0, 0, 0, 0}; // x=1, y=1
    }

    @Override
    protected int[] getNegativeIndices() {
        return new int[]{-1, 0, 0, 0, 0, 0};
    }

    @Override
    protected int[] getExceedingIndices() {
        return new int[]{3, 3, 0, 0, 0, 0}; // Assuming dimensions are 3,3
    }
}

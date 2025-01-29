package com.nogenericgames.community.arrays;

import com.nogenericgames.community.arrays.longs.Long3DArray;

/**
 * JUnit test class for Long3DArray.
 */
public class Long3DArrayTest extends AbstractLongArrayTest {

    @Override
    protected Object createArray(int... dimensions) {
        if (dimensions.length < 3) {
            throw new IllegalArgumentException("Long3DArray requires at least 3 dimensions (x, y, z).");
        }
        return new Long3DArray(dimensions[0], dimensions[1], dimensions[2]);
    }

    @Override
    protected ArrayGetter getMethod() {
        return (array, indices) -> ((Long3DArray) array).get(indices[0], indices[1], indices[2]);
    }

    @Override
    protected ArraySetter setMethod() {
        return (array, value, indices) -> ((Long3DArray) array).set(indices[0], indices[1], indices[2], value);
    }

    @Override
    protected ArrayUnsafeGetter getUnsafeMethod() {
        return (array, indices) -> ((Long3DArray) array).getUnsafe(indices[0], indices[1], indices[2]);
    }

    @Override
    protected ArrayUnsafeSetter setUnsafeMethod() {
        return (array, value, indices) -> ((Long3DArray) array).setUnsafe(indices[0], indices[1], indices[2], value);
    }

    @Override
    protected ArrayClearer clearMethod() {
        return (array) -> ((Long3DArray) array).clear();
    }

    @Override
    protected ArrayFiller fillMethod() {
        return (array, value) -> ((Long3DArray) array).fill(value);
    }

    @Override
    protected ArrayCopier copyMethod() {
        return (array) -> ((Long3DArray) array).copy();
    }

    @Override
    protected String expectedToString() {
        // Corrected: [0, 2, 0] should be in Layer 1, Row 1
        return "Long3DArray{\n" +
               "  Layer 0:\n" +
               "    [1, 0, 0]\n" +
               "    [0, 0, 0]\n" +
               "    [0, 0, 0]\n" +
               "  Layer 1:\n" +
               "    [0, 0, 0]\n" +
               "    [0, 2, 0]\n" +
               "    [0, 0, 0]\n" +
               "  Layer 2:\n" +
               "    [0, 0, 0]\n" +
               "    [0, 0, 0]\n" +
               "    [0, 0, 0]\n" +
               "}";
    }

    @Override
    protected int[] getTestDimensions() {
        return new int[]{3, 3, 3, 1, 1, 1}; // Only first three dimensions are used
    }

    @Override
    protected int[][] getInvalidDimensions() {
        return new int[][]{
            {0, 3, 3, 1, 1, 1},  // xSize <= 0
            {3, -1, 3, 1, 1, 1}, // ySize <= 0
            {3, 3, 0, 1, 1, 1}   // zSize <= 0
        };
    }

    @Override
    protected int[] getSampleIndices1() {
        return new int[]{0, 0, 0, 0, 0, 0}; // x=0, y=0, z=0
    }

    @Override
    protected int[] getSampleIndices2() {
        return new int[]{1, 1, 1, 0, 0, 0}; // x=1, y=1, z=1
    }

    @Override
    protected int[] getNegativeIndices() {
        return new int[]{-1, 0, 0, 0, 0, 0};
    }

    @Override
    protected int[] getExceedingIndices() {
        return new int[]{3, 3, 3, 0, 0, 0}; // Assuming dimensions are 3,3,3
    }
}

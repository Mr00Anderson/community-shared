package com.nogenericgames.community.arrays;

import com.nogenericgames.community.arrays.longs.Long4DArray;

/**
 * JUnit test class for Long4DArray.
 */
public class Long4DArrayTest extends AbstractLongArrayTest {

    @Override
    protected Object createArray(int... dimensions) {
        if (dimensions.length < 4) {
            throw new IllegalArgumentException("Long4DArray requires at least 4 dimensions (x, y, z, w).");
        }
        return new Long4DArray(dimensions[0], dimensions[1], dimensions[2], dimensions[3]);
    }

    @Override
    protected ArrayGetter getMethod() {
        return (array, indices) -> ((Long4DArray) array).get(indices[0], indices[1], indices[2], indices[3]);
    }

    @Override
    protected ArraySetter setMethod() {
        return (array, value, indices) -> ((Long4DArray) array).set(indices[0], indices[1], indices[2], indices[3], value);
    }

    @Override
    protected ArrayUnsafeGetter getUnsafeMethod() {
        return (array, indices) -> ((Long4DArray) array).getUnsafe(indices[0], indices[1], indices[2], indices[3]);
    }

    @Override
    protected ArrayUnsafeSetter setUnsafeMethod() {
        return (array, value, indices) -> ((Long4DArray) array).setUnsafe(indices[0], indices[1], indices[2], indices[3], value);
    }

    @Override
    protected ArrayClearer clearMethod() {
        return (array) -> ((Long4DArray) array).clear();
    }

    @Override
    protected ArrayFiller fillMethod() {
        return (array, value) -> ((Long4DArray) array).fill(value);
    }

    @Override
    protected ArrayCopier copyMethod() {
        return (array) -> ((Long4DArray) array).copy();
    }

    @Override
    protected String expectedToString() {
        // After setting indices1 to 1 and indices2 to 2, ensure they are placed correctly
        return "Long4DArray{\n" +
               "  Hyperlayer 0:\n" +
               "    Layer 0:\n" +
               "      [1, 0, 0]\n" +
               "      [0, 0, 0]\n" +
               "      [0, 0, 0]\n" +
               "    Layer 1:\n" +
               "      [0, 2, 0]\n" +
               "      [0, 0, 0]\n" +
               "      [0, 0, 0]\n" +
               "    Layer 2:\n" +
               "      [0, 0, 0]\n" +
               "      [0, 0, 0]\n" +
               "      [0, 0, 0]\n" +
               "  Hyperlayer 1:\n" +
               "    Layer 0:\n" +
               "      [0, 0, 0]\n" +
               "      [0, 0, 0]\n" +
               "      [0, 0, 0]\n" +
               "    Layer 1:\n" +
               "      [0, 0, 0]\n" +
               "      [0, 0, 0]\n" +
               "      [0, 0, 0]\n" +
               "    Layer 2:\n" +
               "      [0, 0, 0]\n" +
               "      [0, 0, 0]\n" +
               "      [0, 0, 0]\n" +
               "  Hyperlayer 2:\n" +
               "    Layer 0:\n" +
               "      [0, 0, 0]\n" +
               "      [0, 0, 0]\n" +
               "      [0, 0, 0]\n" +
               "    Layer 1:\n" +
               "      [0, 0, 0]\n" +
               "      [0, 0, 0]\n" +
               "      [0, 0, 0]\n" +
               "    Layer 2:\n" +
               "      [0, 0, 0]\n" +
               "      [0, 0, 0]\n" +
               "      [0, 0, 0]\n" +
               "}";
    }

    @Override
    protected int[] getTestDimensions() {
        return new int[]{3, 3, 3, 3, 1, 1}; // Only first four dimensions are used
    }

    @Override
    protected int[][] getInvalidDimensions() {
        return new int[][]{
            {0, 3, 3, 3, 1, 1},  // xSize <= 0
            {3, -1, 3, 3, 1, 1}, // ySize <= 0
            {3, 3, 0, 3, 1, 1},  // zSize <= 0
            {3, 3, 3, 0, 1, 1}   // wSize <= 0
        };
    }

    @Override
    protected int[] getSampleIndices1() {
        return new int[]{0, 0, 0, 0, 0, 0}; // x=0, y=0, z=0, w=0
    }

    @Override
    protected int[] getSampleIndices2() {
        return new int[]{1, 1, 1, 1, 0, 0}; // x=1, y=1, z=1, w=1
    }

    @Override
    protected int[] getNegativeIndices() {
        return new int[]{-1, 0, 0, 0, 0, 0};
    }

    @Override
    protected int[] getExceedingIndices() {
        return new int[]{3, 3, 3, 3, 0, 0}; // Assuming dimensions are 3,3,3,3
    }
}

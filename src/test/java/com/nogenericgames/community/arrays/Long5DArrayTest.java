package com.nogenericgames.community.arrays;

import com.nogenericgames.community.arrays.longs.Long5DArray;

/**
 * JUnit test class for Long5DArray.
 */
public class Long5DArrayTest extends AbstractLongArrayTest {

    @Override
    protected Object createArray(int... dimensions) {
        if (dimensions.length < 5) {
            throw new IllegalArgumentException("Long5DArray requires at least 5 dimensions (x, y, z, w, u).");
        }
        return new Long5DArray(dimensions[0], dimensions[1], dimensions[2], dimensions[3], dimensions[4]);
    }

    @Override
    protected ArrayGetter getMethod() {
        return (array, indices) -> ((Long5DArray) array).get(indices[0], indices[1], indices[2], indices[3], indices[4]);
    }

    @Override
    protected ArraySetter setMethod() {
        return (array, value, indices) -> ((Long5DArray) array).set(indices[0], indices[1], indices[2], indices[3], indices[4], value);
    }

    @Override
    protected ArrayUnsafeGetter getUnsafeMethod() {
        return (array, indices) -> ((Long5DArray) array).getUnsafe(indices[0], indices[1], indices[2], indices[3], indices[4]);
    }

    @Override
    protected ArrayUnsafeSetter setUnsafeMethod() {
        return (array, value, indices) -> ((Long5DArray) array).setUnsafe(indices[0], indices[1], indices[2], indices[3], indices[4], value);
    }

    @Override
    protected ArrayClearer clearMethod() {
        return (array) -> ((Long5DArray) array).clear();
    }

    @Override
    protected ArrayFiller fillMethod() {
        return (array, value) -> ((Long5DArray) array).fill(value);
    }

    @Override
    protected ArrayCopier copyMethod() {
        return (array) -> ((Long5DArray) array).copy();
    }

    @Override
    protected String expectedToString() {
        // After setting indices1 to 1 and indices2 to 2, ensure they are placed correctly
        return "Long5DArray{\n" +
               "  Hyperlayer 0:\n" +
               "    Layer 0:\n" +
               "      Sublayer 0:\n" +
               "        [1, 0, 0]\n" +
               "        [0, 0, 0]\n" +
               "        [0, 0, 0]\n" +
               "      Sublayer 1:\n" +
               "        [0, 0, 0]\n" +
               "        [0, 0, 0]\n" +
               "        [0, 0, 0]\n" +
               "      Sublayer 2:\n" +
               "        [0, 0, 0]\n" +
               "        [0, 0, 0]\n" +
               "        [0, 0, 0]\n" +
               "    Layer 1:\n" +
               "      Sublayer 0:\n" +
               "        [0, 2, 0]\n" +
               "        [0, 0, 0]\n" +
               "        [0, 0, 0]\n" +
               "      Sublayer 1:\n" +
               "        [0, 0, 0]\n" +
               "        [0, 0, 0]\n" +
               "        [0, 0, 0]\n" +
               "      Sublayer 2:\n" +
               "        [0, 0, 0]\n" +
               "        [0, 0, 0]\n" +
               "        [0, 0, 0]\n" +
               "    Layer 2:\n" +
               "      Sublayer 0:\n" +
               "        [0, 0, 0]\n" +
               "        [0, 0, 0]\n" +
               "        [0, 0, 0]\n" +
               "      Sublayer 1:\n" +
               "        [0, 0, 0]\n" +
               "        [0, 0, 0]\n" +
               "        [0, 0, 0]\n" +
               "      Sublayer 2:\n" +
               "        [0, 0, 0]\n" +
               "        [0, 0, 0]\n" +
               "        [0, 0, 0]\n" +
               "  Hyperlayer 1:\n" +
               "    Layer 0:\n" +
               "      Sublayer 0:\n" +
               "        [0, 0, 0]\n" +
               "        [0, 0, 0]\n" +
               "        [0, 0, 0]\n" +
               "      Sublayer 1:\n" +
               "        [0, 0, 0]\n" +
               "        [0, 0, 0]\n" +
               "        [0, 0, 0]\n" +
               "      Sublayer 2:\n" +
               "        [0, 0, 0]\n" +
               "        [0, 0, 0]\n" +
               "        [0, 0, 0]\n" +
               "    Layer 1:\n" +
               "      Sublayer 0:\n" +
               "        [0, 0, 0]\n" +
               "        [0, 0, 0]\n" +
               "        [0, 0, 0]\n" +
               "      Sublayer 1:\n" +
               "        [0, 0, 0]\n" +
               "        [0, 0, 0]\n" +
               "        [0, 0, 0]\n" +
               "      Sublayer 2:\n" +
               "        [0, 0, 0]\n" +
               "        [0, 0, 0]\n" +
               "        [0, 0, 0]\n" +
               "    Layer 2:\n" +
               "      Sublayer 0:\n" +
               "        [0, 0, 0]\n" +
               "        [0, 0, 0]\n" +
               "        [0, 0, 0]\n" +
               "      Sublayer 1:\n" +
               "        [0, 0, 0]\n" +
               "        [0, 0, 0]\n" +
               "        [0, 0, 0]\n" +
               "      Sublayer 2:\n" +
               "        [0, 0, 0]\n" +
               "        [0, 0, 0]\n" +
               "        [0, 0, 0]\n" +
               "  Hyperlayer 2:\n" +
               "    Layer 0:\n" +
               "      Sublayer 0:\n" +
               "        [0, 0, 0]\n" +
               "        [0, 0, 0]\n" +
               "        [0, 0, 0]\n" +
               "      Sublayer 1:\n" +
               "        [0, 0, 0]\n" +
               "        [0, 0, 0]\n" +
               "        [0, 0, 0]\n" +
               "      Sublayer 2:\n" +
               "        [0, 0, 0]\n" +
               "        [0, 0, 0]\n" +
               "        [0, 0, 0]\n" +
               "}";
    }

    @Override
    protected int[] getTestDimensions() {
        return new int[]{3, 3, 3, 3, 3, 1}; // Only first five dimensions are used
    }

    @Override
    protected int[][] getInvalidDimensions() {
        return new int[][]{
            {0, 3, 3, 3, 3, 1},  // xSize <= 0
            {3, -1, 3, 3, 3, 1}, // ySize <= 0
            {3, 3, 0, 3, 3, 1},  // zSize <= 0
            {3, 3, 3, -1, 3, 1}, // wSize <= 0
            {3, 3, 3, 3, 0, 1}   // uSize <= 0
        };
    }

    @Override
    protected int[] getSampleIndices1() {
        return new int[]{0, 0, 0, 0, 0, 0}; // x=0, y=0, z=0, w=0, u=0
    }

    @Override
    protected int[] getSampleIndices2() {
        return new int[]{1, 1, 1, 1, 1, 0}; // x=1, y=1, z=1, w=1, u=1
    }

    @Override
    protected int[] getNegativeIndices() {
        return new int[]{-1, 0, 0, 0, 0, 0};
    }

    @Override
    protected int[] getExceedingIndices() {
        return new int[]{3, 3, 3, 3, 3, 0}; // Assuming dimensions are 3,3,3,3,3
    }
}

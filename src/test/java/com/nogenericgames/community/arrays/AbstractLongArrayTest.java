package com.nogenericgames.community.arrays;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

/**
 * Abstract base class for testing Long multidimensional arrays.
 */
public abstract class AbstractLongArrayTest {

    // Abstract methods to be implemented by concrete test classes
    protected abstract Object createArray(int... dimensions);
    protected abstract ArrayGetter getMethod();
    protected abstract ArraySetter setMethod();
    protected abstract ArrayUnsafeGetter getUnsafeMethod();
    protected abstract ArrayUnsafeSetter setUnsafeMethod();
    protected abstract ArrayClearer clearMethod();
    protected abstract ArrayFiller fillMethod();
    protected abstract ArrayCopier copyMethod();
    protected abstract String expectedToString();

    // Dimensions required for testing; concrete classes should provide appropriate sizes
    protected abstract int[] getTestDimensions();

    /**
     * Test the constructor with valid dimensions.
     */
    @Test
    public void testConstructorValid() {
        Object array = createArray(getTestDimensions());
        assertNotNull(array, "Array instance should not be null.");
    }

    /**
     * Test the constructor with invalid dimensions.
     */
    @Test
    public void testConstructorInvalid() {
        int[][] invalidDimensions = getInvalidDimensions();
        for (int[] dims : invalidDimensions) {
            assertThrows(IllegalArgumentException.class, () -> createArray(dims),
                    "Constructor should throw IllegalArgumentException for dimensions: " + arrayToString(dims));
        }
    }

    /**
     * Provide invalid dimensions for testing constructor.
     */
    protected abstract int[][] getInvalidDimensions();

    /**
     * Test setting and getting elements with bounds checking.
     */
    @Test
    public void testSetGet() {
        Object array = createArray(getTestDimensions());
        int[] indices = getValidIndices();
        long value = 42L;
        setMethod().set(array, value, indices);
        long retrieved = getMethod().get(array, indices);
        assertEquals(value, retrieved, "Retrieved value should match the set value.");
    }

    /**
     * Test setting and getting elements without bounds checking.
     */
    @Test
    public void testSetGetUnsafe() {
        Object array = createArray(getTestDimensions());
        int[] indices = getValidIndices();
        long value = 99L;
        setUnsafeMethod().setUnsafe(array, value, indices);
        long retrieved = getUnsafeMethod().getUnsafe(array, indices);
        assertEquals(value, retrieved, "Retrieved value from unsafe methods should match the set value.");
    }

    /**
     * Test the clear method.
     */
    @Test
    public void testClear() {
        Object array = createArray(getTestDimensions());
        fillMethod().fill(array, 5L); // Fill with non-zero values
        clearMethod().clear(array);    // Clear the array

        // Verify all elements are zero
        for (int x = 0; x < getTestDimensions()[0]; x++) {
            for (int y = 0; y < getTestDimensions()[1]; y++) {
                for (int z = getTestDimensions().length > 2 ? 0 : 0; z < (getTestDimensions().length > 2 ? getTestDimensions()[2] : 1); z++) {
                    for (int w = getTestDimensions().length > 3 ? 0 : 0; w < (getTestDimensions().length > 3 ? getTestDimensions()[3] : 1); w++) {
                        for (int u = getTestDimensions().length > 4 ? 0 : 0; u < (getTestDimensions().length > 4 ? getTestDimensions()[4] : 1); u++) {
                            for (int v = getTestDimensions().length > 5 ? 0 : 0; v < (getTestDimensions().length > 5 ? getTestDimensions()[5] : 1); v++) {
                                int[] currentIndices = {x, y, z, w, u, v};
                                long retrieved = getMethod().get(array, currentIndices);
                                assertEquals(0L, retrieved, "After clear, all elements should be 0.");
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Test the fill method.
     */
    @Test
    public void testFill() {
        Object array = createArray(getTestDimensions());
        long fillValue = 7L;
        fillMethod().fill(array, fillValue);

        // Verify all elements are filled with fillValue
        for (int x = 0; x < getTestDimensions()[0]; x++) {
            for (int y = 0; y < getTestDimensions()[1]; y++) {
                for (int z = getTestDimensions().length > 2 ? 0 : 0; z < (getTestDimensions().length > 2 ? getTestDimensions()[2] : 1); z++) {
                    for (int w = getTestDimensions().length > 3 ? 0 : 0; w < (getTestDimensions().length > 3 ? getTestDimensions()[3] : 1); w++) {
                        for (int u = getTestDimensions().length > 4 ? 0 : 0; u < (getTestDimensions().length > 4 ? getTestDimensions()[4] : 1); u++) {
                            for (int v = getTestDimensions().length > 5 ? 0 : 0; v < (getTestDimensions().length > 5 ? getTestDimensions()[5] : 1); v++) {
                                int[] currentIndices = {x, y, z, w, u, v};
                                long retrieved = getMethod().get(array, currentIndices);
                                assertEquals(fillValue, retrieved, "After fill, all elements should match the fill value.");
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Test the copy method.
     */
    @Test
    public void testCopy() {
        Object original = createArray(getTestDimensions());
        fillMethod().fill(original, 3L);
        Object copied = copyMethod().copy(original);

        assertNotSame(original, copied, "Copied array should be a different instance.");

        // Verify all elements are identical
        for (int x = 0; x < getTestDimensions()[0]; x++) {
            for (int y = 0; y < getTestDimensions()[1]; y++) {
                for (int z = getTestDimensions().length > 2 ? 0 : 0; z < (getTestDimensions().length > 2 ? getTestDimensions()[2] : 1); z++) {
                    for (int w = getTestDimensions().length > 3 ? 0 : 0; w < (getTestDimensions().length > 3 ? getTestDimensions()[3] : 1); w++) {
                        for (int u = getTestDimensions().length > 4 ? 0 : 0; u < (getTestDimensions().length > 4 ? getTestDimensions()[4] : 1); u++) {
                            for (int v = getTestDimensions().length > 5 ? 0 : 0; v < (getTestDimensions().length > 5 ? getTestDimensions()[5] : 1); v++) {
                                int[] currentIndices = {x, y, z, w, u, v};
                                long originalValue = getMethod().get(original, currentIndices);
                                long copiedValue = getMethod().get(copied, currentIndices);
                                assertEquals(originalValue, copiedValue, "Copied array should have identical elements.");
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Test the equals and hashCode methods.
     */
    @Test
    public void testEqualsAndHashCode() {
        Object array1 = createArray(getTestDimensions());
        Object array2 = createArray(getTestDimensions());
        fillMethod().fill(array1, 10L);
        fillMethod().fill(array2, 10L);

        assertEquals(array1, array2, "Arrays with identical elements should be equal.");
        assertEquals(array1.hashCode(), array2.hashCode(), "Equal arrays should have the same hash code.");

        // Modify array2 and ensure they are no longer equal
        int[] indices = getValidIndices();
        setMethod().set(array2, 5L, indices);
        assertNotEquals(array1, array2, "Arrays with different elements should not be equal.");
    }

    /**
     * Test the toString method.
     */
    @Test
    public void testToString() {
        Object array = createArray(getTestDimensions());
        int[] indices1 = getSampleIndices1();
        int[] indices2 = getSampleIndices2();
        setMethod().set(array, 1L, indices1);
        setMethod().set(array, 2L, indices2);

        String expected = expectedToString();
        assertEquals(expected, array.toString(), "toString method should return the correct string representation.");
    }

    /**
     * Test basic performance by ensuring operations complete within a reasonable time frame.
     */
    @Test
    @Timeout(1) // Test must complete within 1 second
    public void testPerformance() {
        Object array = createArray(getTestDimensions());
        fillMethod().fill(array, 1L);

        // Perform a simple operation
        for (int x = 0; x < getTestDimensions()[0]; x++) {
            for (int y = 0; y < getTestDimensions()[1]; y++) {
                for (int z = getTestDimensions().length > 2 ? 0 : 0; z < (getTestDimensions().length > 2 ? getTestDimensions()[2] : 1); z++) {
                    for (int w = getTestDimensions().length > 3 ? 0 : 0; w < (getTestDimensions().length > 3 ? getTestDimensions()[3] : 1); w++) {
                        for (int u = getTestDimensions().length > 4 ? 0 : 0; u < (getTestDimensions().length > 4 ? getTestDimensions()[4] : 1); u++) {
                            for (int v = getTestDimensions().length > 5 ? 0 : 0; v < (getTestDimensions().length > 5 ? getTestDimensions()[5] : 1); v++) {
                                int[] currentIndices = {x, y, z, w, u, v};
                                long currentValue = getMethod().get(array, currentIndices);
                                setMethod().set(array, currentValue + 1L, currentIndices);
                            }
                        }
                    }
                }
            }
        }

        // Verify a sample value
        int[] sampleIndices = {1, 1, 1, 1, 0, 0};
        long expectedValue = 2L;
        long actualValue = getMethod().get(array, sampleIndices);
        assertEquals(expectedValue, actualValue, "Element at " + formatIndices(sampleIndices) + " should be incremented to " + expectedValue + ".");
    }

    /**
     * Test bounds checking by attempting to access invalid indices.
     */
    @Test
    public void testBoundsChecking() {
        Object array = createArray(getTestDimensions());

        // Negative indices
        int[] negativeIndices = getNegativeIndices();
        assertThrows(IndexOutOfBoundsException.class, () -> getMethod().get(array, negativeIndices),
                "Accessing with negative indices should throw IndexOutOfBoundsException.");

        // Indices exceeding dimensions
        int[] exceedingIndices = getExceedingIndices();
        assertThrows(IndexOutOfBoundsException.class, () -> getMethod().get(array, exceedingIndices),
                "Accessing with indices exceeding dimensions should throw IndexOutOfBoundsException.");
    }

    /**
     * Provide a set of valid indices for testing.
     */
    protected int[] getValidIndices() {
        int[] dimensions = getTestDimensions();
        int[] indices = new int[6];
        for (int i = 0; i < indices.length; i++) {
            indices[i] = (dimensions[i] > 1) ? 1 : 0; // Choose index 1 if possible, else 0
        }
        return indices;
    }

    /**
     * Provide sample indices for toString test.
     */
    protected abstract int[] getSampleIndices1();
    protected abstract int[] getSampleIndices2();

    /**
     * Provide negative indices for bounds checking.
     */
    protected abstract int[] getNegativeIndices();

    /**
     * Provide exceeding indices for bounds checking.
     */
    protected abstract int[] getExceedingIndices();

    /**
     * Helper method to format indices for display.
     */
    protected String formatIndices(int[] indices) {
        StringBuilder sb = new StringBuilder("(");
        for (int i = 0; i < indices.length; i++) {
            sb.append(indices[i]);
            if (i < indices.length - 1) sb.append(", ");
        }
        sb.append(")");
        return sb.toString();
    }

    /**
     * Helper method to convert array to string for error messages.
     */
    protected String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}

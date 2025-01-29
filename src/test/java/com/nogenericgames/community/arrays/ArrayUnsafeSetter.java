package com.nogenericgames.community.arrays;

@FunctionalInterface
public interface ArrayUnsafeSetter {
    void setUnsafe(Object array, long value, int... indices);
}

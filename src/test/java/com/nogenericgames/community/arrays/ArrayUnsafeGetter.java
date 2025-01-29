package com.nogenericgames.community.arrays;

@FunctionalInterface
public interface ArrayUnsafeGetter {
    long getUnsafe(Object array, int... indices);
}

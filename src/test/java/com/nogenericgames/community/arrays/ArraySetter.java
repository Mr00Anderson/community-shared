package com.nogenericgames.community.arrays;

@FunctionalInterface
public interface ArraySetter {
    void set(Object array, long value, int... indices);
}
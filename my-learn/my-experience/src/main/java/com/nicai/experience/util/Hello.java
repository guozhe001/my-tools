package com.nicai.experience.util;

public class Hello {
    private static long count = 0;
    private final long id = count++;

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "id=" + id +
                '}';
    }
}
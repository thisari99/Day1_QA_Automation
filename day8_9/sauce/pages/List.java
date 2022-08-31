package com.rootcodelabs.java.day8_9.sauce.pages;

import java.util.stream.IntStream;

public interface List<T> {
    int size();

    void add(T item);

    IntStream stream();
}

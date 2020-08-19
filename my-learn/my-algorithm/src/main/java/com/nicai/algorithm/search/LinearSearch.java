package com.nicai.algorithm.search;

import java.util.Optional;

/**
 * @author guozhe
 * @date 2020/08/19
 */
public class LinearSearch implements Search {

    @Override
    public Optional<Integer> search(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (value == array[i]) {
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }
}

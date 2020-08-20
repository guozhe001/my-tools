package com.nicai.algorithm.search;

import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

/**
 * @author guozhe
 * @date 2020/08/19
 */
@Slf4j
public class LinearSearch extends AbstractSearch {

    @Override
    void check(int[] array) {
        log.info("i'm LinearSearch, don't need to check...");
    }

    @Override
    Optional<Integer> search(int[] array, int minIndex, int maxIndex, int value) {
        for (int i = minIndex; i <= maxIndex; i++) {
            if (value == array[i]) {
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }
}

package com.nicai.experience.p3c.chapterone.sixth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 成对出现
 *
 * @author nicai
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pair<T, K> {
    private T version;
    private K value;
}
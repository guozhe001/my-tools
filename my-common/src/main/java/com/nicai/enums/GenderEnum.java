package com.nicai.enums;

import lombok.Getter;

/**
 * @author guozhe
 * @date 2019-11-20
 */
public enum GenderEnum {
    /**
     * 男性
     */
    MALE("男性"),
    /**
     * 女性
     */
    FEMALE("女性");
    @Getter
    private final String name;

    GenderEnum(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

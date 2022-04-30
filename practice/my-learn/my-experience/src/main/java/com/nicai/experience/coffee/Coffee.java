package com.nicai.experience.coffee;

/**
 * 咖啡
 *
 * @author guozhe
 */
public class Coffee {

    private static long counter;
    private final long id = counter++;

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                ", id=" + id;
    }

}

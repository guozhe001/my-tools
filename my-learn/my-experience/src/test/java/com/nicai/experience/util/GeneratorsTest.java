package com.nicai.experience.util;

import com.google.common.collect.Lists;
import com.nicai.experience.coffee.Coffee;
import com.nicai.experience.coffee.CoffeeGenerator;
import com.nicai.experience.fibonacci.Fibonacci;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.List;

@Slf4j
public class GeneratorsTest {

    @Test
    public void fillFibonacci() {
        List<Integer> fibs = Generators.fill(Lists.newArrayList(), new Fibonacci(), 18);
        Assert.assertEquals(18, fibs.size());
        for (int i : fibs) {
            System.out.print(i + " ");
        }
    }

    @Test
    public void fillCoffee() {
        Collection<Coffee> fibs = Generators.fill(Lists.newArrayList(), new CoffeeGenerator(), 18);
        Assert.assertEquals(18, fibs.size());
        for (Coffee c : fibs) {
            log.info("{}", c);
        }
    }
}
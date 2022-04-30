package com.nicai.experience.coffee;

import com.nicai.exception.NicaiException;
import com.nicai.util.Generator;
import lombok.extern.slf4j.Slf4j;

import java.util.Iterator;
import java.util.Random;

/**
 * 咖啡生成器
 *
 * @author guozhe
 */
@Slf4j
public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {

    /**
     * 所有的咖啡类型
     */
    private static final Class[] TYPES = {Americano.class, Breve.class, Cappuccino.class, Latte.class, Mocha.class};

    private static final Random random = new Random(47);

    private int size;

    public CoffeeGenerator(int size) {
        this.size = size;
    }

    public CoffeeGenerator() {
    }

    @Override
    public Coffee next() {
        try {
            return (Coffee) TYPES[random.nextInt(TYPES.length)].newInstance();
        } catch (Exception e) {
            log.error("获取下一杯咖啡异常");
            throw new NicaiException(e);
        }
    }

    @Override
    public Iterator<Coffee> iterator() {
        return new CofferIterator();
    }

    class CofferIterator implements Iterator<Coffee> {
        int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffee next() {
            count--;
            return CoffeeGenerator.this.next();
        }
    }

    public static void main(String[] args) {
        CoffeeGenerator coffeeGenerator = new CoffeeGenerator();
        for (int i = 0; i < 5; i++) {
            System.out.println(coffeeGenerator.next());
        }

        for (Coffee coffee : new CoffeeGenerator(5)) {
            System.out.println(coffee);
        }

    }

}

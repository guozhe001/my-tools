package com.nicai.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

@Slf4j
public class BasicGeneratorTest {

    @Test
    public void next() {
        Generator<Hello> helloGenerator = new BasicGenerator<>(Hello.class);
        Assert.assertNotNull(helloGenerator);
        for (int i = 0; i < 5; i++) {
            log.info("{}", helloGenerator.next());
        }
    }


    @Test
    public void create() {
        Generator<Hello> helloGenerator = BasicGenerator.create(Hello.class);
        Assert.assertNotNull(helloGenerator);
        for (int i = 0; i < 5; i++) {
            log.info("{}", helloGenerator.next());
        }
    }


    @Test
    public void psf() {
        BigDecimal phaseServiceFee = new PhaseServiceFee("1000");
        log.info("phaseServiceFee = {}", phaseServiceFee);
        Assert.assertEquals(0, phaseServiceFee.compareTo(BigDecimal.valueOf(1000)));

    }


    public class PhaseServiceFee extends BigDecimal {

        public PhaseServiceFee(char[] in, int offset, int len) {
            super(in, offset, len);
        }

        public PhaseServiceFee(char[] in, int offset, int len, MathContext mc) {
            super(in, offset, len, mc);
        }

        public PhaseServiceFee(char[] in) {
            super(in);
        }

        public PhaseServiceFee(char[] in, MathContext mc) {
            super(in, mc);
        }

        public PhaseServiceFee(String val) {
            super(val);
        }

        public PhaseServiceFee(String val, MathContext mc) {
            super(val, mc);
        }

        public PhaseServiceFee(double val) {
            super(val);
        }

        public PhaseServiceFee(double val, MathContext mc) {
            super(val, mc);
        }

        public PhaseServiceFee(BigInteger val) {
            super(val);
        }

        public PhaseServiceFee(BigInteger val, MathContext mc) {
            super(val, mc);
        }

        public PhaseServiceFee(BigInteger unscaledVal, int scale) {
            super(unscaledVal, scale);
        }

        public PhaseServiceFee(BigInteger unscaledVal, int scale, MathContext mc) {
            super(unscaledVal, scale, mc);
        }

        public PhaseServiceFee(int val) {
            super(val);
        }

        public PhaseServiceFee(int val, MathContext mc) {
            super(val, mc);
        }

        public PhaseServiceFee(long val) {
            super(val);
        }

        public PhaseServiceFee(long val, MathContext mc) {
            super(val, mc);
        }
    }

}
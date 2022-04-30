package com.nicai.validation.constraintvalidators;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.math.BigDecimal;

@Slf4j
public class RangeEnumValidatorTest {

    private static final BigDecimal TOTAL_AMOUNT_PER_MONTH = BigDecimal.valueOf(1440);

    private static final BigDecimal STAGE_ONE_LIMIT = BigDecimal.valueOf(240);
    private static final BigDecimal STAGE_TWO_LIMIT = BigDecimal.valueOf(400);

    private static final BigDecimal STAGE_TWO_TOTAL = STAGE_TWO_LIMIT.subtract(STAGE_ONE_LIMIT);


    private static final BigDecimal STAGE_ONE_PRICE = BigDecimal.valueOf(0.4883);
    private static final BigDecimal STAGE_TWO_PRICE = BigDecimal.valueOf(0.5383);
    private static final BigDecimal STAGE_THREE_PRICE = BigDecimal.valueOf(0.7883);

    @Test
    public void dianfei() {
        BigDecimal stateOneAmount = TOTAL_AMOUNT_PER_MONTH.subtract(STAGE_ONE_LIMIT).compareTo(BigDecimal.ZERO) > 0 ? STAGE_ONE_LIMIT : TOTAL_AMOUNT_PER_MONTH;
        BigDecimal stageOneMoney = stateOneAmount.multiply(STAGE_ONE_PRICE);
        log.info("stateOneAmount={}, stageOneMoney={}", stateOneAmount, stageOneMoney);
        BigDecimal stateTwoAmount = TOTAL_AMOUNT_PER_MONTH.compareTo(STAGE_TWO_LIMIT) > 0 ? STAGE_TWO_TOTAL : max(TOTAL_AMOUNT_PER_MONTH.subtract(STAGE_ONE_LIMIT), BigDecimal.ZERO);
        BigDecimal stageTwoMoney = stateTwoAmount.multiply(STAGE_TWO_PRICE);
        log.info("stateTwoAmount={}, stageTwoMoney={}", stateTwoAmount, stageTwoMoney);
        BigDecimal stateThreeAmount = max(TOTAL_AMOUNT_PER_MONTH.subtract(STAGE_TWO_LIMIT), BigDecimal.ZERO);
        BigDecimal stageThreeMoney = stateThreeAmount.multiply(STAGE_THREE_PRICE);
        log.info("stateThreeAmount={}, stageThreeMoney={}", stateThreeAmount, stageThreeMoney);
        log.info("totalAmount={}, totalMoney={}", TOTAL_AMOUNT_PER_MONTH, sum(stageOneMoney, stageTwoMoney, stageThreeMoney));
    }

    private BigDecimal max(BigDecimal num1, BigDecimal num2) {
        return num1.compareTo(num2) > 0 ? num1 : num2;
    }

    private BigDecimal sum(BigDecimal num1, BigDecimal num2, BigDecimal... nums) {
        BigDecimal sum = num1.add(num2);
        for (BigDecimal num : nums) {
            sum = sum.add(num);
        }
        return sum;
    }

}
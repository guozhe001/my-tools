package com.nicai.ao;

import com.nicai.util.PrintUtil;
import com.nicai.util.ValidatorUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author guozhe
 * @date 2019-12-04
 */
@Slf4j
public class BorrowerAOTest {

    @Test
    public void test() {
        BorrowerAO borrowerAO = new BorrowerAO();
        PrintUtil.print(ValidatorUtil.validate(borrowerAO));
    }

}
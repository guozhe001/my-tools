package com.nicai.ao;

import com.nicai.util.PrintUtil;
import com.nicai.util.ValidatorUtil;
import org.junit.Test;

/**
 * @author guozhe
 * @date 2019-12-04
 */
public class PropertyLevelConstraintsAOTest {

    @Test
    public void getName() {
        PrintUtil.print(ValidatorUtil.validate(new PropertyLevelConstraintsAO()));
    }

}
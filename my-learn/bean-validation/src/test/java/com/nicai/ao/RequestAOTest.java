package com.nicai.ao;

import com.google.common.collect.Lists;
import com.nicai.util.PrintUtil;
import com.nicai.util.ValidatorUtil;
import org.junit.Test;

/**
 * @author guozhe
 * @date 2019-12-04
 */
public class RequestAOTest {

    @Test
    public void test() {
        RequestAO requestAO = new RequestAO();
//        requestAO.setEmail("假的邮箱");
        requestAO.setEmail("");
        requestAO.setTargetSources(Lists.newArrayList("test"));
        requestAO.setAge1(56);
        PrintUtil.print(ValidatorUtil.validate(requestAO));
    }

}
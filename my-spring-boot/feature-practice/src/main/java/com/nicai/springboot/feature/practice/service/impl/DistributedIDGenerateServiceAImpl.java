package com.nicai.springboot.feature.practice.service.impl;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.google.common.collect.Maps;
import com.nicai.constant.Constants;
import com.nicai.constant.RedisConstants;
import com.nicai.springboot.feature.practice.bo.AContext;
import com.nicai.springboot.feature.practice.service.AbstractRedisDistributedIDGenerateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

/**
 * 分布式唯一ID生成-A实现类
 * 编号规则：用途+日期+自增ID，如：A202007310001；A202007310002；A202008070001；
 *
 * @author guozhe
 * @date 2020/08/04
 */
@Slf4j
@Service
public class DistributedIDGenerateServiceAImpl extends AbstractRedisDistributedIDGenerateService<AContext> {

    /**
     * 业务类型
     */
    private static final String BUSINESS_TYPE = "A:";

    /**
     * ID长度不足4位时在前面填充的字符
     */
    private static final char FILLED_CHAR = '0';

    /**
     * 最后的自增ID的长度
     */
    private static final int INCREMENT_LENGTH = 4;

    /**
     * 过期小时数，即在24小时候过期
     */
    private static final int EXPIRATION_HOURS = 24;

    /**
     * 已经使用过的ID
     */
    private static final Map<String, String> USED_ID = Maps.newHashMap();

    public DistributedIDGenerateServiceAImpl(StringRedisTemplate redisTemplate) {
        super(redisTemplate);
    }

    @Override
    protected boolean checkIfDuplicated(String nextId) {
        return false;
    }

    @Override
    protected Long maxIdFromDatabase(String duplicatedId) {
        String voucherNumberDate = getVoucherNumberDate(duplicatedId);

        Optional<Long> max = USED_ID.keySet().stream().filter(key -> key.contains(voucherNumberDate))
                .map(key -> Long.valueOf(StrUtil.subSufByLength(key, INCREMENT_LENGTH))).max(Long::compareTo);
//        Long maxVoucherNumber = max.orElseThrow(() -> new NicaiException("获取凭证编号异常"));
        return max.get();
    }

    @Override
    protected String assemblyNextId(AContext context, Long redisValue) {
        return String.join(Constants.BLANK, context.getBusinessType(), getDatePeriod(),
                StrUtil.fillBefore(String.valueOf(redisValue), FILLED_CHAR, INCREMENT_LENGTH));
    }

    @Override
    protected String getKey() {
        return String.join(RedisConstants.KEY_DELIMITER, RedisConstants.KEY_PREFIX, BUSINESS_TYPE, getDatePeriod());
    }

    @Override
    protected long getTimeOutHours() {
        return EXPIRATION_HOURS;
    }

    /**
     * 获取凭证编号的日期段的值
     */
    private String getDatePeriod() {
        return DateUtil.format(DateUtil.date(), DatePattern.PURE_DATE_FORMAT);
    }

    /**
     * 根据凭证编号获取凭证编号中的日期字符串
     *
     * @param duplicatedId 重复的凭证编号；如：CZ202007310001
     * @return 凭证编号中的日期字符串，如20200731
     */
    private String getVoucherNumberDate(String duplicatedId) {
        // 先取后面的12个字符，然后再从12个字符中取前8位；
        return StrUtil.subPre(StrUtil.subSufByLength(duplicatedId, 12), 8);
    }

}


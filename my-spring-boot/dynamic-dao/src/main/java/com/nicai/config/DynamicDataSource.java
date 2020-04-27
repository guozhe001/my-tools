package com.nicai.config;

import com.nicai.enums.DataSourceEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author guozhe
 */
@Slf4j
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        DataSourceEnum dataSource = DataSourceContextHolder.getDataSource();
        log.debug("determineCurrentLookupKey current dataSource={}", dataSource);
        return dataSource;
    }
}

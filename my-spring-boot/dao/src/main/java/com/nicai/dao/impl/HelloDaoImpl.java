package com.nicai.dao.impl;

import com.nicai.annotations.DataSource;
import com.nicai.dao.HelloDao;
import com.nicai.enums.DataSourceEnum;
import org.springframework.stereotype.Repository;

/**
 * @author guozhe
 * @date 2020-02-28
 */
@DataSource(DataSourceEnum.READONLY_DATASOURCE)
@Repository
public class HelloDaoImpl implements HelloDao {

    @Override
    public Long getById(Long id) {
        return id;
    }
}


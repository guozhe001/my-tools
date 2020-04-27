package com.nicai.dao.impl;

import com.nicai.annotations.DataSource;
import com.nicai.dao.MyTable1Dao;
import com.nicai.entity.MyTable1;
import com.nicai.enums.DataSourceEnum;
import com.nicai.mapper.MyTable1Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @author guozhe
 * @date 2020-04-27
 */
@Repository
@DataSource(DataSourceEnum.READONLY_DATASOURCE)
public class MyTable1DaoImpl implements MyTable1Dao {

    private final MyTable1Mapper mapper;

    public MyTable1DaoImpl(MyTable1Mapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Long save(String name) {
        MyTable1 myTable1 = new MyTable1();
        myTable1.setName(name);
        myTable1.setCreateTime(new Date());
        myTable1.setUpdateTime(new Date());
        mapper.insert(myTable1);
        return myTable1.getId();
    }

    @Override
    public MyTable1 getById(Long id) {
        return mapper.selectByPrimaryKey(id);
    }
}

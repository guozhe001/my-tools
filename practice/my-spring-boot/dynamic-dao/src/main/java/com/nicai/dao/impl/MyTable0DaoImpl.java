package com.nicai.dao.impl;

import com.nicai.dao.MyTable0Dao;
import com.nicai.entity.MyTable0;
import com.nicai.mapper.MyTable0Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @author guozhe
 * @date 2020-04-27
 */
@Repository
public class MyTable0DaoImpl implements MyTable0Dao {

    private final MyTable0Mapper mapper;

    public MyTable0DaoImpl(MyTable0Mapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Long save(String name) {
        MyTable0 myTable0 = new MyTable0();
        myTable0.setName(name);
        myTable0.setCreateTime(new Date());
        myTable0.setUpdateTime(new Date());
        mapper.insert(myTable0);
        return myTable0.getId();
    }

    @Override
    public MyTable0 getById(Long id) {
        return mapper.selectByPrimaryKey(id);
    }
}

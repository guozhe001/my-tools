package com.nicai.dao;

import com.nicai.entity.MyTable1;

/**
 * @author guozhe
 * @date 2020-04-27
 */
public interface MyTable1Dao {

    /**
     * 保存一条数据并把id返回
     *
     * @param name 名称
     * @return id
     */
    Long save(String name);

    /**
     * 根据id查询
     *
     * @param id ID
     * @return 实体
     */
    MyTable1 getById(Long id);
}

package com.hyx.springmvc.dao;

import org.springframework.stereotype.Repository;

import com.hyx.springmvc.bean.City;

@Repository
public interface CityDao {
    int deleteByPrimaryKey(Integer fid);

    int insert(City record);

    int insertSelective(City record);

    City selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);
}
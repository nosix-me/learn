package com.hyx.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hyx.springmvc.bean.City;
import com.hyx.springmvc.dao.CityDao;

@Service(value="cityService")
public class CityServiceImpl implements CityService{
	
	@Autowired
	private CityDao cityDao;

	@Override
	public City getCityById(Long id) {
		// TODO Auto-generated method stub
		return cityDao.selectByPrimaryKey(id.intValue());
	}
	
	
}

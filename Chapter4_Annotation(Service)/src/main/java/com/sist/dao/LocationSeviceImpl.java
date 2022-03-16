package com.sist.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.mapper.LocationMapper;
import com.sist.vo.LocationVO;

@Service
public class LocationSeviceImpl implements LocationService{
	@Autowired
	private LocationMapper mapper;
	@Override
	public List<LocationVO> locationListData() {
		return mapper.locationListData();
	}
}

package com.sist.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.vo.*;
import com.sist.mapper.*;
import java.util.*;

@Repository
public class HotelDAO {
	// 구현된 클래스 읽기
	@Autowired
	private HotelMapper mapper;
	
	public List<HotelVO> hotelListData(Map map) {
		return mapper.hotelListData(map);
	}
	
	public int hotelTotalPage() {
		return mapper.hotelTotalPage();
	}
	
	public HotelVO hotelDetailData(int no) {
		return mapper.hotelDetailData(no);
	}
}

package com.sist.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.vo.*;
import com.sist.dao.*;

// DAO여러개 통합 BI
@Service
public class FoodService implements Food {
	@Autowired
	private CategoryDAO cDao;
	@Autowired
	private FoodDAO fDao;

	@Override
	public List<CategoryVO> categoryAllData() {

		return cDao.categoryAllData();
	}

	@Override
	public CategoryVO categoryInfodata(int cno) {

		return cDao.categoryInfodata(cno);
	}

	@Override
	public List<FoodVO> categoryFoodListData(int cno) {

		return cDao.categoryFoodListData(cno);
	}

}

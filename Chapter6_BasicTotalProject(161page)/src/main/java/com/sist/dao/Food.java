package com.sist.dao;

import java.util.List;

import com.sist.vo.*;

public interface Food {
	public List<CategoryVO> categoryAllData();
	public CategoryVO categoryInfodata(int cno);
	public List<FoodVO> categoryFoodListData(int cno);
}

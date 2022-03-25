package com.sist.dao;
import java.util.*;
import com.sist.mapper.*;
import com.sist.vo.*;
public class BooksDAO {
	private BooksMapper mapper;

	public void setMapper(BooksMapper mapper) {
		this.mapper = mapper;
	}
	public List<BooksVO> booksFindData(String title) {
		return mapper.booksFindData(title);
	}
	public List<BooksVO> booksListData(){
		return mapper.booksListData();
	}
}

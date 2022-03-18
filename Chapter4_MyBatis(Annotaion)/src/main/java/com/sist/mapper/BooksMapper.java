package com.sist.mapper;
import java.util.*;
import com.sist.dao.*;

import org.apache.ibatis.annotations.Select;
public interface BooksMapper {
	@Select("SELECT title,content FROM books")
	public List<BooksVO> booksListData();	// 구현완료
	// <bean id="" resultType="" parameterType="">
	
	@Select("SELECT title, content FROM books "
			+"WHERE title LIKE '%'||#{title}||'%'")
	public List<BooksVO> booksFindData(String title);
}

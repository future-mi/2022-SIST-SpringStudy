package com.sist.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.sist.mapper.*;

@Repository
public class MemberDAO {
	@Autowired
	private MemberMapper mapper;
	
	public int idCount(String id) {
		return mapper.idCount(id);
	}
	public String getPassword(String id) {
		return mapper.getPassword(id);
	}
	public String memberGetName(String id) {
		return mapper.memberGetName(id);
	}
}

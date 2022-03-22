package com.sist.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import java.util.*;
public class EmpDAO extends SqlSessionDaoSupport{
	public List<EmpVO> empListData() {
		
		return getSqlSession().selectList("empListData");
		// getSqlSession()
	}
	public EmpVO empDetailData(int empno) {
		
		return getSqlSession().selectOne("empDetailData", empno);
	}
	public List<EmpVO> empDeptJoinData(){
		
		return getSqlSession().selectList("empDeptJoinData");
	}
	public EmpVO empDeptDetailData(int empno){
		
		return getSqlSession().selectOne("empDeptDetailData", empno);
	}
}

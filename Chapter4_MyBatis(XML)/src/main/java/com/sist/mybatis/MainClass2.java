package com.sist.mybatis;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao2.EmpVO;
import com.sist.dao2.EmpDAO;

public class MainClass2 {
	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("app2.xml");
		// DAO를 스프링으로부터 가지고 온다
		// 스프링에 등록된 DAO만 셋팅이 완료 → new (null 이다)
		EmpDAO dao=(EmpDAO)app.getBean("dao");
		//
		List<EmpVO> list=dao.empListData();
		for(EmpVO vo:list) {
			System.out.println(vo.getEmpno()+" "
							+vo.getEname()+" "
							+vo.getJob()+" "
							+vo.getSal());
		}
		
		System.out.println("=====================");
		List<EmpVO> jList=dao.empdeptJoinData();
		for(EmpVO vo:jList) {
			System.out.println(vo.getEmpno()+" "
					+vo.getEname()+" "
					+vo.getJob()+" "
					+vo.getSal()+" "	
					+vo.getDvo().getDname()+" "
					+vo.getDvo().getLoc());			
		}
	}
}

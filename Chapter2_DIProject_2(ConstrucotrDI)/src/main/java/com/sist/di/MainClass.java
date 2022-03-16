package com.sist.di;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		// 1. XMLÆÄ½Ì
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		EmpDAO dao=(EmpDAO)app.getBean("dao");
		List<EmpVO> list=dao.empListData();
		// Ãâ·Â
		for(EmpVO vo:list) {
			System.out.println(vo.getEmpno()+" "
							+vo.getName()+" "
							+vo.getJob()+" "
							+vo.getHiredate().toString()+" "
							+vo.getSal());
		}
	}
}

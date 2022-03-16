package com.sist.di;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app=new AnnotationConfigApplicationContext(EmpConfig.class);
		EmpDAO dao=app.getBean("dao",EmpDAO.class);
		// 형변환 없이 사용
		List<EmpVO> list=dao.empListData();
		for(EmpVO vo:list) {
			System.out.println(vo.getEmpno()+" "
							+vo.getName()+" "
							+vo.getJob());
		}
	}
}

package com.sist.anno;
import java.util.*;
import com.sist.dao.*;
import com.sist.vo.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component("mc")
// 스프링에 메모리 할당 요청 → 프로그램 종료시까지 저장
public class MainClass {
	@Autowired
	private LocationService sevice;
	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		MainClass mc=(MainClass)app.getBean("mc");
		List<LocationVO> list=mc.sevice.locationListData();
		for(LocationVO vo:list) {
			System.out.println(vo.getTitle());
			System.out.println(vo.getAddress());
			System.out.println(vo.getMsg());
			System.out.println("=========================================");
		}
	}
}

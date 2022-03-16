package com.sist.di3;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		HotelDAO dao=(HotelDAO)app.getBean("dao3");
        List<HotelVO> list=dao.hotelListData();
		for(HotelVO vo:list) {
			System.out.println(vo.getName()+" "
							+vo.getScore()+" "
							+vo.getAddress());
		}
	}
}

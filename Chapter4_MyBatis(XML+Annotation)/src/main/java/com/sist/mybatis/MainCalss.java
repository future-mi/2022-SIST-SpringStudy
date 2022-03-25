package com.sist.mybatis;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.sist.vo.*;

import com.sist.dao.*;
// 89page~100page(�ٽ�)
// MyBatis �� Basic(���� SQL)
/*
 * [ XML ]
 * MyBatis �� Config(1), mapper, Mapper(������)
 * Spring �� ���������� ������ ó�� (�л� =��ɺ� �л�)
 *      
 * [ Basic ] 
 * <select> : id, resultType, parameterType
 *            JOIN / Subquery 
 * <insert> : id, parameterType
 * <update> : id, parameterType
 * <delete> : id, parameterType
 * <sql> : �ߺ��� SQL������ ��Ƽ� ó�� 
 * <resultMap> : ResultSet�� �ִ� �����͸� VO�� ���ؼ� �޴� ���
 *               default(VO�� ���鶧 �÷���� �����ϰ� ����� ������ �ʿ� ����)
 *               �ǹ��� �÷���� VO�� �������� Ʋ���� (resultMap)
 */
public class MainCalss {
	public static void main(String[] args) {
		// 1. ���������� XML�� �д´�
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		// ��ϵ� Ŭ������ �޸� �Ҵ� �� setXxx()�� ���� ����
		BooksDAO dao=(BooksDAO)app.getBean("dao");
		// �������� ��ϵ� DAO�� ���� ������ �ȴ�
		List<BooksVO> list=dao.booksListData();
		for(BooksVO vo:list) {
			System.out.println(vo.getTitle()+" "+vo.getPrice());
		}
		System.out.println("=====================================");
		list=dao.booksFindData("����");
		for(BooksVO vo:list) {
			System.out.println(vo.getTitle()+" "+vo.getPrice());
		}	
		System.out.println("==================��=================");
	}
}

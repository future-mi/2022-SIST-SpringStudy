package com.sist.container;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * 1. 관리대상 클래스를 XML에 등록
 * 	- ~VO를 제외한 모든 클래스는 스프링에서 관리(기능) → 데이터형(프로그래머가 관리)
 * 2. 스프링에서 사용자가 등록한 클래스를 어떤 클래스에서 관리하는지 여부  
 * 
 * [컨테이너에 등록하는 방식]
 * 1) XML(4chapter)
 * 2) 자바로등록(5chapter) → Spring - Boot
 * 
 * - 기본목적 : 의존성이 낮은 프로그램을 목적으로 한다(결합성이 낮은 프로그램)
 * 			→ 클래스의 영향력이 없는 프로그램
 */
public class MainClass {
	public static void main(String[] args) {
		// 1. 컨테이너에 등록
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		// → 파싱(XML을 읽어서 등록된 클래스의 메모리 할당이 완료)
		// 2. 프로그램에 필요한 객체를 얻어서 사용
		Sawon s=(Sawon)app.getBean("sa"); // 객체생성, 소멸담당
		// 변수에 대한 초기값 담당
		s.setName("홍길동");
		s.setDept("개발부");
		s.setJob("사원");
		
		System.out.println("이름: "+s.getName());
		System.out.println("부서: "+s.getDept());
		System.out.println("직위: "+s.getJob());
		
		// 싱글턴 → 메모리를 한개만 생성 → 재사용해서 사용
		// 3. 객체를 얻어온다
		// 4. 객체 요청시마다 따로 메모리를 저장할 때 : scope="prototype"
		Sawon s1=(Sawon)app.getBean("sa"); // 필요시마다 스프링에 등록된 클래스를 얻어서 사용시에(getBean())
		// 변수에대한 초기값 담당
		s1.setName("심청이");
		s1.setDept("기획부");
		s1.setJob("대리");
		
		System.out.println("s="+s);
		System.out.println("s1="+s1);
		
		System.out.println("이름: "+s.getName());
		System.out.println("부서: "+s.getDept());
		System.out.println("직위: "+s.getJob());		
		
		System.out.println("이름: "+s.getName());
		System.out.println("부서: "+s.getDept());
		System.out.println("직위: "+s.getJob());
	}
}

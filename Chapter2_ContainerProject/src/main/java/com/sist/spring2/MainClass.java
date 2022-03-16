package com.sist.spring2;
/*
 * 가급적이면 new를 사용하지 않는다
 * new를 사용하면 의존성이 높은 프로그램으로 변경 → 유지보수가 어렵다(스프링은 유지보수가 편한 프로그램)
 */
public class MainClass {
	public static void main(String[] args) {
		Hello h=new HelloImple();
		String msg=h.sayHello("심청이");
		System.out.println(msg);
	}
}

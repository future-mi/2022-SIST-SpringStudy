package com.sist.spring2;
// 결합성이 낮은 상태
public class HelloImple implements Hello{

	@Override
	public String sayHello(String name) {
		return name+"님 환영합니다";
	}
	
}

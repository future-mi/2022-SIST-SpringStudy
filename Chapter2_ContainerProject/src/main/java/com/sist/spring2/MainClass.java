package com.sist.spring2;
/*
 * �������̸� new�� ������� �ʴ´�
 * new�� ����ϸ� �������� ���� ���α׷����� ���� �� ���������� ��ƴ�(�������� ���������� ���� ���α׷�)
 */
public class MainClass {
	public static void main(String[] args) {
		Hello h=new HelloImple();
		String msg=h.sayHello("��û��");
		System.out.println(msg);
	}
}
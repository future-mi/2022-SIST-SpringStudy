package com.sist.container;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * 1. ������� Ŭ������ XML�� ���
 * 	- ~VO�� ������ ��� Ŭ������ ���������� ����(���) �� ��������(���α׷��Ӱ� ����)
 * 2. ���������� ����ڰ� ����� Ŭ������ � Ŭ�������� �����ϴ��� ����  
 * 
 * [�����̳ʿ� ����ϴ� ���]
 * 1) XML(4chapter)
 * 2) �ڹٷε��(5chapter) �� Spring - Boot
 * 
 * - �⺻���� : �������� ���� ���α׷��� �������� �Ѵ�(���ռ��� ���� ���α׷�)
 * 			�� Ŭ������ ������� ���� ���α׷�
 */
public class MainClass {
	public static void main(String[] args) {
		// 1. �����̳ʿ� ���
		ApplicationContext app=new ClassPathXmlApplicationContext("app.xml");
		// �� �Ľ�(XML�� �о ��ϵ� Ŭ������ �޸� �Ҵ��� �Ϸ�)
		// 2. ���α׷��� �ʿ��� ��ü�� �� ���
		Sawon s=(Sawon)app.getBean("sa"); // ��ü����, �Ҹ���
		// ������ ���� �ʱⰪ ���
		s.setName("ȫ�浿");
		s.setDept("���ߺ�");
		s.setJob("���");
		
		System.out.println("�̸�: "+s.getName());
		System.out.println("�μ�: "+s.getDept());
		System.out.println("����: "+s.getJob());
		
		// �̱��� �� �޸𸮸� �Ѱ��� ���� �� �����ؼ� ���
		// 3. ��ü�� ���´�
		// 4. ��ü ��û�ø��� ���� �޸𸮸� ������ �� : scope="prototype"
		Sawon s1=(Sawon)app.getBean("sa"); // �ʿ�ø��� �������� ��ϵ� Ŭ������ �� ���ÿ�(getBean())
		// ���������� �ʱⰪ ���
		s1.setName("��û��");
		s1.setDept("��ȹ��");
		s1.setJob("�븮");
		
		System.out.println("s="+s);
		System.out.println("s1="+s1);
		
		System.out.println("�̸�: "+s.getName());
		System.out.println("�μ�: "+s.getDept());
		System.out.println("����: "+s.getJob());		
		
		System.out.println("�̸�: "+s.getName());
		System.out.println("�μ�: "+s.getDept());
		System.out.println("����: "+s.getJob());
	}
}

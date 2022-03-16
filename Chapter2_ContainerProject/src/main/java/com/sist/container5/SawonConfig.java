package com.sist.container5;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
/*
 * ������ 5 �� Ŭ���� ��Ͻÿ� XML�� ����ϴ� ���� �ƴ϶� �����ϰ� �ڹٷθ� ���
 * ���� �� XML(����) �� �ڹٴ� �����ϵ� ���ϸ� ����(�ҽ������� ����)
 * �ǹ� �� 4, ������ ���� �� 5
 */
@Configuration
public class SawonConfig {
	/*
	 * <bean id="sa" class="com.sist.container.Sawon" scope="prototype">
	 */
	@Bean("sa")
	@Scope("singleton")	// ������ ����� ����(�޸� �ּҰ� ����)
	// ������ �ϸ� singleton�̴�
	public Sawon sawon() {
		return new Sawon(); // class
	}
}

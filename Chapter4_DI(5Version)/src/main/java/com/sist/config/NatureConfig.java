package com.sist.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.builder.MapperBuilderAssistant;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//app.xml을 대신 사용 (XML을 최대한 제거) => 형식 (Spring-Boot)
//Spring-Boot(서버) => VueJS , ReactJS (우대) (JSP없이 사용이 가능)
@Configuration
//메모리 할당 요청  (설정파일)
@ComponentScan(basePackages = {"com.sist.*"})
// <context:component-scan base-package="com.sist.*">
public class NatureConfig {
  // 라이브러리 클래스(직접등록)
  // <bean id="ds">
  @Bean("ds")
  public BasicDataSource dataSource() {
	  BasicDataSource ds=new BasicDataSource();
	  // setXxx() 값을 채운다
	  ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	  ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
	  ds.setUsername("hr");
	  ds.setPassword("happy");
	  return ds;
  }

  @Bean("ssf")
  public SqlSessionFactory sqlSessionFactory() throws Exception {
	  SqlSessionFactoryBean ssf=new SqlSessionFactoryBean();
	  ssf.setDataSource(dataSource());
	  return ssf.getObject();
  }

  @Bean("mapper")
  public MapperFactoryBean mapperFactoryBean() throws Exception
  {
	  MapperFactoryBean mapper=new MapperFactoryBean();
	  mapper.setSqlSessionFactory(sqlSessionFactory());
	  mapper.setMapperInterface(com.sist.mapper.NatureMapper.class);
	  return mapper;
  }
  
}








package com.sist.di;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
public class EmpConfig  {
	@Bean("ds")
	public BasicDataSource basicDataSource() {
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ds.setUsername("hr");
		ds.setPassword("happy");
		return ds;
	}
	
	@Bean("ssf")
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean ssf=new SqlSessionFactoryBean();
		ssf.setDataSource(basicDataSource());
		Resource res=new ClassPathResource("Config.xml");
		ssf.setConfigLocation(res);
		return ssf.getObject();
	}
	@Bean("dao")
	public EmpDAO empDao() throws Exception{
		EmpDAO dao=new EmpDAO();
		dao.setSqlSessionFactory(sqlSessionFactory());
		return dao;
	}
}

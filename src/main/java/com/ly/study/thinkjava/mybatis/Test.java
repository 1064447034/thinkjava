package com.ly.study.thinkjava.mybatis;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test {
	InputStream inputStream = this.getClass().getResourceAsStream("");
	SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	
	SqlSession sqlSession = sqlSessionFactory.openSession();
	
}

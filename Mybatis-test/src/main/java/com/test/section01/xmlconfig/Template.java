package com.test.section01.xmlconfig;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Template {

    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSession getSqlSession(){

        if(sqlSessionFactory == null){
            String recource = "mybatis.config.xml";
            try {
                InputStream inputStream = Resources.getResourceAsStream(recource);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } SqlSession sqlSession = sqlSessionFactory.openSession(false);
        System.out.println("sqlSession.hashCode() = " + sqlSession.hashCode());
        System.out.println("sqlSessionFactory = " + sqlSessionFactory.hashCode());

        java.util.Date date = sqlSession.selectOne("mapper.selectSysdate");
        java.util.Date dates = sqlSession.selectOne("mapper.menudb");

        System.out.println("date = " + date);
        System.out.println("dates = " + dates);



        return sqlSession;

    }

}

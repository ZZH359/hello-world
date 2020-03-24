package com.aistar.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * 用于提供SqlSession的获得与关闭
 * SqlSession作用： 用于执行SQL语句（insert,update,delete,select等） + 一级缓存 【轻量级】
 * SqlSessionFactory 【重量级】一次
 */
public class MyBatisUtil {


    private static SqlSession sqlSession = null;
    private static SqlSessionFactory sqlSessionFactory = null;
    private static InputStream inputStream = MyBatisUtil.class.getClassLoader().getResourceAsStream("config/mybatis-config.xml");


    static {

            sqlSessionFactory =new SqlSessionFactoryBuilder().build(inputStream);

    }

    /**
     * 获得SqlSession对象
     * @return
     */
    public static SqlSession getSqlSession(){
        sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }


    /**
     * 关闭SqlSession
     */
    public static void closeSqlSession(){
        if(sqlSession != null)
            sqlSession.close();
    }


    public static void main(String[] args) {
       SqlSession sqlSession =    MyBatisUtil.getSqlSession();

        System.out.println(sqlSession);
    }
}

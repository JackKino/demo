package com.example.demo.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory=null;
    //初始化SqlSessionFactory对象
    static {
        try {
            //使用MyBatis提供的Resoures类加载Mybatis的配置文件
            Reader reader= Resources.getResourceAsReader("mybatis-config.xml");
            //根据配置文件构建SQLSessionFactory
             sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获取Sqlsession对象的静态方法
    public static SqlSession getSession(){
        return sqlSessionFactory.openSession();
    }
}

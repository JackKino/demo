package com.example.demo;

import com.example.demo.mybatis.po.PersonInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    @Test
    public void findPersonByIdTest()throws Exception{
        //读取配置文件
        String resource="mybatis-config.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        //根据配置文件构建SQLSessionFactory
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        //通过sqlSessionFactory创建sqlSession
        SqlSession sqlSession=sqlSessionFactory.openSession();
       //sqlsession执行映射文件中定义的sql,并返回映射结果
        List<PersonInfo> list = sqlSession.selectList("PersonInfo.getInfo");
        //打印返回值信息
        for (PersonInfo user : list) {
            System.out.println(user.toString());
        }
        //提交会话
        sqlSession.commit();
        sqlSession.close();
    }
}

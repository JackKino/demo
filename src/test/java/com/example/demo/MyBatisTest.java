package com.example.demo;

import com.example.demo.mybatis.mapper.PersonInfoMapper;
import com.example.demo.mybatis.po.PersonInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MyBatisTest {
    private List<PersonInfo> personInfos=new ArrayList<>();
    @Test
    public void findPersonByIdTest() throws Exception {
        //读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //根据配置文件构建SQLSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //通过sqlSessionFactory创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //sqlsession执行映射文件中定义的sql,并返回映射结果
        List<PersonInfo> list = sqlSession.selectList("com.example.demo.mybatis.mapper.PersonInfoMapper.getInfo");
        //打印返回值信息
        for (PersonInfo user : list) {
            System.out.println(user.toString());
        }
        //提交会话
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void findPersonByIdTest2() throws Exception {
        //读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //根据配置文件构建SQLSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //通过sqlSessionFactory创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //sqlsession执行映射文件中定义的sql,并返回映射结果
        //List<PersonInfo> list = sqlSession.selectList("PersonInfo.getInfo");

        try {
            PersonInfoMapper personMapper = sqlSession.getMapper(PersonInfoMapper.class);
            List<PersonInfo> list = personMapper.getInfo2();
            //打印返回值信息
            for (PersonInfo user : list) {
                System.out.println(user.toString());
            }
            //提交会话
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void insertUser() throws Exception {
        //读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //根据配置文件构建SQLSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //通过sqlSessionFactory创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //sqlsession执行映射文件中定义的sql,并返回映射结果
        PersonInfo info = new PersonInfo();
        info.setUsername("Mirtha");
        info.setScore(88);
        info.setAddress("NewYork");


        try {
            sqlSession.insert("com.example.demo.mybatis.mapper.PersonInfoMapper.insertUser", info);
            //提交会话
            sqlSession.commit();
        }finally {
            sqlSession.close();
        }

    }
    @Test
    public void insertBatchUser() throws Exception {
        //读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //根据配置文件构建SQLSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //通过sqlSessionFactory创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //sqlsession执行映射文件中定义的sql,并返回映射结果
        PersonInfo info = new PersonInfo();
        info.setUsername("Mirtha2");
        info.setScore(90);
        info.setAddress("NewYork");
        PersonInfo info2 = new PersonInfo();
        info2.setUsername("Mirtha3");
        info2.setScore(60);
        info2.setAddress("NewYork");
        PersonInfo info3 = new PersonInfo();
        info3.setUsername("Mirtha4");
        info3.setScore(80);
        info3.setAddress("NewYork");
        personInfos.add(info);
        personInfos.add(info2);
        personInfos.add(info3);
        try {
            sqlSession.insert("com.example.demo.mybatis.mapper.PersonInfoMapper.insertBatchUser", personInfos);
            //提交会话
            sqlSession.commit();
        }catch (Exception e){

        }
        finally {
            sqlSession.close();
        }
    }
    @Test
    public void queryInfo() throws Exception {
        //读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //根据配置文件构建SQLSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //通过sqlSessionFactory创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //sqlsession执行映射文件中定义的sql,并返回映射结果
        //List<PersonInfo> list = sqlSession.selectList("PersonInfo.getInfo");

        try {
            PersonInfoMapper personMapper = sqlSession.getMapper(PersonInfoMapper.class);
            PersonInfo personInfo=personMapper.queryInfo(11,"NewYork");
            System.out.println(personInfo.toString());
            //提交会话
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            sqlSession.close();
        }
    }
}

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
    public void createPerson() throws Exception{
        //读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //根据配置文件构建SQLSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //通过sqlSessionFactory创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.insert("com.example.demo.mybatis.mapper.PersonInfoMapper.createPersonInfo");
            //提交会话
            sqlSession.commit();
            System.out.println("数据库表prerson创建成功");
        }catch (Exception e){

        }
        finally {
            sqlSession.close();
        }
    }

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
        info.setUsername("Jack2");
        info.setScore(88);
        info.setAddress("深圳");


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

    @Test
    public void createTable() throws Exception {
        //读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //根据配置文件构建SQLSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //通过sqlSessionFactory创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //sqlsession执行映射文件中定义的sql,并返回映射结果
        try {
            sqlSession.update("com.example.demo.mybatis.mapper.PersonInfoMapper.createTable");
            //提交会话
            sqlSession.commit();
            System.out.println("账户表info创建成功！");
        }catch (Exception e){
            System.out.println(e.toString());
        }
        finally {
            sqlSession.close();
        }
    }
    @Test
    public void deleteTable() throws Exception {
        //读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //根据配置文件构建SQLSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //通过sqlSessionFactory创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //sqlsession执行映射文件中定义的sql,并返回映射结果
        try {
            sqlSession.update("com.example.demo.mybatis.mapper.PersonInfoMapper.deleteTable");
            //提交会话
            sqlSession.commit();
            System.out.println("账户表info删除成功！");
        }catch (Exception e){
            System.out.println(e.toString());
        }
        finally {
            sqlSession.close();
        }
    }


    @Test
    public void findPersonById() throws Exception {
        //读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //根据配置文件构建SQLSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //通过sqlSessionFactory创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //sqlsession执行映射文件中定义的sql,并返回映射结果

        //提交会话
        try {
            PersonInfo personInfo = sqlSession.selectOne("com.example.demo.mybatis.mapper.PersonInfoMapper.getInfoById",5);
            //打印返回值信息
            //提交会话
            sqlSession.commit();
            System.out.println(personInfo.toString());

        }catch (Exception e){
            System.out.println(e.toString());
        }
        finally {
            sqlSession.close();
        }
    }

}

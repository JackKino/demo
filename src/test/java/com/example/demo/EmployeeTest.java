package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.mybatis.mapper.*;
import com.example.demo.mybatis.po.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class EmployeeTest {
    @Test
    public void getTaskById() throws IOException {
        //读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //根据配置文件构建SQLSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //通过sqlSessionFactory创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();

        try {
            TaskMapper taskMapper=sqlSession.getMapper(TaskMapper.class);
            Task task=taskMapper.getTask(102);            //提交会话
            // 注意，当我们使用二级缓存时候，sqlSession需要使用commit时候才会生效
            sqlSession.commit();
           // System.out.println("再次调用不同的sqlsession");
           /* TaskMapper taskMapper2=sqlSession2.getMapper(TaskMapper.class);
            Task task2=taskMapper2.getTask(101);            //提交会话
            sqlSession2.commit();*/
            System.out.println("Task=="+ JSON.toJSONString(task));
        }catch (Exception e){
            System.out.println(e.toString());
        }
        finally {
            sqlSession.close();
        }
    }

    @Test
    public void getEmployeeTaskByEmpId() throws IOException {
        //读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //根据配置文件构建SQLSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //通过sqlSessionFactory创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            EmployeeTaskMapper employeeTaskMapper=sqlSession.getMapper(EmployeeTaskMapper.class);
            EmployeeTask employeeTask=employeeTaskMapper.getEmployeeTaskByEmpId(1001);            //提交会话
            sqlSession.commit();
            System.out.println("EmployeeTask=="+ JSON.toJSONString(employeeTask));
        }catch (Exception e){
            System.out.println(e.toString());
        }
        finally {
            sqlSession.close();
        }
    }

    @Test
    public void getMaleById() throws IOException {
        //读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //根据配置文件构建SQLSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //通过sqlSessionFactory创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            MaleHealthFormMapper MaleHealthFormMapper=sqlSession.getMapper(MaleHealthFormMapper.class);
            MaleHealthForm maleHealthForm=MaleHealthFormMapper.getMale(1001);            //提交会话
            // 注意，当我们使用二级缓存时候，sqlSession需要使用commit时候才会生效
            sqlSession.commit();
            System.out.println("Task=="+ JSON.toJSONString(maleHealthForm));
        }catch (Exception e){
            System.out.println(e.toString());
        }
        finally {
            sqlSession.close();
        }
    }
    @Test
    public void getFeMaleById() throws IOException {
        //读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //根据配置文件构建SQLSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //通过sqlSessionFactory创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            FeMaleHealthFormMapper feMaleHealthFormMapper=sqlSession.getMapper(FeMaleHealthFormMapper.class);
            FeMaleHealthForm femaleHealthForm=feMaleHealthFormMapper.getFeMale(1002);            //提交会话
            // 注意，当我们使用二级缓存时候，sqlSession需要使用commit时候才会生效
            sqlSession.commit();
            System.out.println("femaleHealthForm=="+ JSON.toJSONString(femaleHealthForm));
        }catch (Exception e){
            System.out.println(e.toString());
        }
        finally {
            sqlSession.close();
        }
    }
    @Test
    public void getWorkCardById() throws IOException {
        //读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //根据配置文件构建SQLSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //通过sqlSessionFactory创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            WorkCardMapper workCardMapper=sqlSession.getMapper(WorkCardMapper.class);
            WorkCard workCard=workCardMapper.getWorkCard(1001);            //提交会话
            // 注意，当我们使用二级缓存时候，sqlSession需要使用commit时候才会生效
            sqlSession.commit();
            System.out.println("WorkCardMapper=="+ JSON.toJSONString(workCard));
        }catch (Exception e){
            System.out.println(e.toString());
        }
        finally {
            sqlSession.close();
        }
    }

    @Test
    public void getEmployeeByEmpId() throws IOException {
        //读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //根据配置文件构建SQLSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //通过sqlSessionFactory创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            EmployeeMapper employeeMapper=sqlSession.getMapper(EmployeeMapper.class);
            Employee employee=employeeMapper.getEmployeeByEmpId(1001);            //提交会话
            // 注意，当我们使用二级缓存时候，sqlSession需要使用commit时候才会生效
            sqlSession.commit();
            System.out.println("WorkCardMapper=="+ JSON.toJSONString(employee));
        }catch (Exception e){
            System.out.println(e.toString());
        }
        finally {
            sqlSession.close();
        }
    }

    @Test
    public void getWorkCardByNameOrMobile() throws IOException {
        //读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //根据配置文件构建SQLSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //通过sqlSessionFactory创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            WorkCardMapper workCardMapper=sqlSession.getMapper(WorkCardMapper.class);
            WorkCard workCard=new WorkCard();
            workCard.setRealName("");
            workCard.setMobile("");

            List<WorkCard> workCard2=workCardMapper.getWorkCardByNameOrMobile(workCard);            //提交会话
            // 注意，当我们使用二级缓存时候，sqlSession需要使用commit时候才会生效
            sqlSession.commit();
            System.out.println("WorkCardMapper=="+ JSON.toJSONString(workCard2));
        }catch (Exception e){
            System.out.println(e.toString());
        }
        finally {
            sqlSession.close();
        }
    }

    @Test
    public void updateWorkCardById() throws IOException {
        //读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //根据配置文件构建SQLSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //通过sqlSessionFactory创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            WorkCardMapper workCardMapper=sqlSession.getMapper(WorkCardMapper.class);
            WorkCard workCard=new WorkCard();
            workCard.setEmpId(1002L);
            workCard.setMobile("13660308942");

            int rows=workCardMapper.updateWorkCardById(workCard);            //提交会话
            // 注意，当我们使用二级缓存时候，sqlSession需要使用commit时候才会生效
            sqlSession.commit();
            System.out.println("成功更新=="+rows);
        }catch (Exception e){
            System.out.println(e.toString());
        }
        finally {
            sqlSession.close();
        }
    }


    @Test
    public void getWorkCarByForEach() throws IOException {
        //读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //根据配置文件构建SQLSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //通过sqlSessionFactory创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        try {
            WorkCardMapper workCardMapper=sqlSession.getMapper(WorkCardMapper.class);
           List<Long> workCards=new ArrayList<>();
           workCards.add(1001L);
           workCards.add(1003L);

            List<WorkCard> workCardList=workCardMapper.getWorkCarByForEach(workCards);            //提交会话
            // 注意，当我们使用二级缓存时候，sqlSession需要使用commit时候才会生效
            sqlSession.commit();
            System.out.println("workCardList=="+JSON.toJSONString(workCardList));
        }catch (Exception e){
            System.out.println(e.toString());
        }
        finally {
            sqlSession.close();
        }
    }
}

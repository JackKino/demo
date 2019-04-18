package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.mybatis.mapper.EmployeeTaskMapper;
import com.example.demo.mybatis.mapper.TaskMapper;
import com.example.demo.mybatis.po.EmployeeTask;
import com.example.demo.mybatis.po.Task;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

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

        try {
            TaskMapper taskMapper=sqlSession.getMapper(TaskMapper.class);
            Task task=taskMapper.getTask(101);            //提交会话
            sqlSession.commit();
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
}

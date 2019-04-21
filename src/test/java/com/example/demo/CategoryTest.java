package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.mybatis.po.Category;
import com.example.demo.mybatis.po.Product;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class CategoryTest {
    @Test
    public void createProduct() throws Exception{
        //读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //根据配置文件构建SQLSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //通过sqlSessionFactory创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.insert("com.example.demo.mybatis.mapper.CategoryMapper.createProduct");
            //提交会话
            sqlSession.commit();
            System.out.println("数据库表product创建成功");
        }catch (Exception e){
            System.out.println(e.toString());
        }
        finally {
            sqlSession.close();
        }
    }

    @Test
    public void createCategory() throws Exception{
        //读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //根据配置文件构建SQLSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //通过sqlSessionFactory创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.insert("com.example.demo.mybatis.mapper.CategoryMapper.createCategory");
            //提交会话
            sqlSession.commit();
            System.out.println("数据库表category创建成功");
        }catch (Exception e){
            System.out.println(e.toString());
        }
        finally {
            sqlSession.close();
        }
    }

    @Test
    public void queryCategory() throws Exception{
        //读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //根据配置文件构建SQLSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //通过sqlSessionFactory创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<Category> categories=sqlSession.selectList("com.example.demo.mybatis.mapper.CategoryMapper.queryProductList");
            //提交会话
            sqlSession.commit();
          //  System.out.println("categories.size()=="+categories.size());
            System.out.println(JSON.toJSONString(categories));



        }catch (Exception e){
            System.out.println(e.toString());
        }
        finally {
            sqlSession.close();
        }
    }

    @Test
    public void queryProduct() throws Exception{
        //读取配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //根据配置文件构建SQLSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //通过sqlSessionFactory创建sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<Product> products=sqlSession.selectList("com.example.demo.mybatis.mapper.CategoryMapper.queryProductTable");
            //提交会话
            sqlSession.commit();
            System.out.println(JSON.toJSON(products));
        }catch (Exception e){
            System.out.println(e.toString());
        }
        finally {
            sqlSession.close();
        }
    }
}
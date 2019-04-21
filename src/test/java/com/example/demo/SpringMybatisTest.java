package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.mybatis.mapper.EmployeeMapper;
import com.example.demo.mybatis.mapper.WorkCardMapper;
import com.example.demo.mybatis.po.Employee;
import com.example.demo.mybatis.po.WorkCard;
import com.example.demo.service.WorkCardService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class SpringMybatisTest {
    @Test
    public  void mainTest() {
        ApplicationContext act=new ClassPathXmlApplicationContext("applicationContext.xml");
        WorkCardMapper workCardMapper=act.getBean(WorkCardMapper.class);
        WorkCard employee=workCardMapper.getWorkCard(1002);            //提交会话
        System.out.println("WorkCardMapper=="+ JSON.toJSONString(employee));
    }

    @Test
    public  void mainTest2() {
        ApplicationContext act=new ClassPathXmlApplicationContext("applicationContext.xml");
        WorkCardService workCardService=act.getBean(WorkCardService.class);
        WorkCard employee=workCardService.getWorkCard(1002);            //提交会话
        System.out.println("WorkCardMapper=="+ JSON.toJSONString(employee));
    }
}

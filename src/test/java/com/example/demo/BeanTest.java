package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.example.demo.bean.PojoConfig;
import com.example.demo.bean.Role;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanTest {
    @Test
    public void getRole(){
        ApplicationContext act=new AnnotationConfigApplicationContext(PojoConfig.class);
        Role role=act.getBean(Role.class);
        System.out.println(JSON.toJSONString(role));

    }
}

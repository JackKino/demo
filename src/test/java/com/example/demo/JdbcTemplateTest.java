package com.example.demo;

import com.example.demo.jdbc.bean.Account;
import com.example.demo.jdbc.dao.AccountDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcTemplateTest {
    @Test
    public  void mainTest() {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        //创建JdbcTemplate实例
        JdbcTemplate jdbcTemplate= (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
        //使用excute()方法执行sql语句，创建表account
        jdbcTemplate.execute("create table account("+
                "id int primary key auto_increment,"+
                "username varchar(50),"+"balance double)");
        System.out.println("账户表account创建成功！");
    }

    @Test
    public  void addAccount(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        //创建JdbcTemplate实例
        AccountDao accountDao= (AccountDao) applicationContext.getBean("accountDao");
        Account account=new Account();
        account.setUsername("Mike");
        account.setBalance(1888.00);
        int num=accountDao.addAccount(account);
        if(num>0){
            System.out.println("成功插入"+num+"条数据！");
        }else{
            System.out.println("插入操作执行失败！");
        }
    }

    @Test
    public  void delAccount(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        //创建JdbcTemplate实例
        AccountDao accountDao= (AccountDao) applicationContext.getBean("accountDao");

        int num=accountDao.deleteAccount(5);
        if(num>0){
            System.out.println("成功删除"+num+"条数据！");
        }else{
            System.out.println("删除操作执行失败！");
        }
    }


    @Test
    public void getAllAccount(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        //创建JdbcTemplate实例
        AccountDao accountDao= (AccountDao) applicationContext.getBean("accountDao");

        List<Account>  accounts=accountDao.findAllAccount();
        if(accounts.size()>0){
            for (Account account:accounts){
                System.out.println(account.toString());
            }
        }else{
            System.out.println("数据库没有数据");
        }
    }
    @Test
    public  void annotationTest(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext-annotation.xml");
        //创建JdbcTemplate实例
        AccountDao accountDao= (AccountDao) applicationContext.getBean("accountDao");
        accountDao.transfer("Jack","Tom",666);
        System.out.println("转账成功！");
    }
}

package com.example.demo.jdbc.impl;

import com.example.demo.jdbc.bean.Account;
import com.example.demo.jdbc.dao.AccountDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class AccountDaoImpl implements AccountDao {
    //声明JdbcTemplate属性及setter方法
    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }
    //添加
    @Override
    public int addAccount(Account account) {
        //定义sql
        String sql="insert into account(username,balance) value(?,?)";
        Object[] objects=new Object[]{account.getUsername(),account.getBalance()};
        //执行添加操作，返回受sql语句影响的记录条数
        int num=jdbcTemplate.update(sql,objects);
        return num;
    }

    @Override
    public int updateAccount(Account account) {
        //定义sql
        String sql="update account set username=?,balance=? where id=? ";
        Object[] objects=new Object[]{account.getUsername(),account.getBalance(),account.getId()};
        //执行添加操作，返回受sql语句影响的记录条数
        int num=jdbcTemplate.update(sql,objects);
        return num;
    }

    @Override
    public int deleteAccount(int id) {
        //定义sql
        String sql="delete  from account where id=?";
        //执行添加操作，返回受sql语句影响的记录条数
        int num=jdbcTemplate.update(sql,id);
        return num;
    }

    @Override
    public Account findAccountById(int id) {
        return null;
    }

    @Override
    public List<Account> findAllAccount() {
        String sql="select * from account";
        RowMapper<Account> rowMapper=new BeanPropertyRowMapper<Account>(Account.class);

        return jdbcTemplate.query(sql,rowMapper);
    }

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly = false)
    @Override
    public void transfer(String outUser, String inUser, double money) {
        //收款时，收款用户金额=现有金额+所汇金额
        jdbcTemplate.update("update account set balance=balance+?"+"where username = ?",money,inUser);
        //int i=1/0;
        //汇款时，收款用户金额=现有金额-所汇金额
        jdbcTemplate.update("update account set balance=balance-?"+"where username = ?",money,outUser);
    }


}

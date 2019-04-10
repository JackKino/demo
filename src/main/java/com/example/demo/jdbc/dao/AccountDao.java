package com.example.demo.jdbc.dao;

import com.example.demo.jdbc.bean.Account;

import java.util.List;

public interface AccountDao {
    public int addAccount(Account account);
    public int updateAccount(Account account);
    public int deleteAccount(int id);
    public Account findAccountById(int id);
    public List<Account> findAllAccount();
    //转账
    public void transfer(String outUser,String inUser,double money);
}

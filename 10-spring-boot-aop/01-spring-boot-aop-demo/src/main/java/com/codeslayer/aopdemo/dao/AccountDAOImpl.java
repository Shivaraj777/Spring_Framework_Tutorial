package com.codeslayer.aopdemo.dao;

import com.codeslayer.aopdemo.entity.Account;
import org.springframework.stereotype.Repository;

@Repository  // make the class available for component scanning -> sub-annotation of component
public class AccountDAOImpl implements AccountDAO{

    @Override
    public void addAccount(Account theAccount, boolean vipFlag) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }


    @Override
    public boolean doWork() {
        System.out.println(getClass() + ": doWork()");
        return false;
    }
}

package com.codeslayer.aopdemo.dao;

import com.codeslayer.aopdemo.entity.Account;

public interface AccountDAO {

    void addAccount(Account theAccount, boolean vipFlag);

    boolean doWork();
}

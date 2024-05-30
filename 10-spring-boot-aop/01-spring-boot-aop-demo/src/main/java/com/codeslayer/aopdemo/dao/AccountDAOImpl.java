package com.codeslayer.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository  // make the class available for component scanning -> sub-annotation of component
public class AccountDAOImpl implements AccountDAO{

    @Override
    public void addAccount() {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }
}

package com.codeslayer.aopdemo.dao;

import com.codeslayer.aopdemo.entity.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository  // make the class available for component scanning -> sub-annotation of component
public class AccountDAOImpl implements AccountDAO{
    private String name;

    private String serviceCode;

    public AccountDAOImpl() { }

    public AccountDAOImpl(String name, String serviceCode) {
        this.name = name;
        this.serviceCode = serviceCode;
    }

    public String getName() {
        System.out.println(getClass() + ": in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": in setServiceCode()");
        this.serviceCode = serviceCode;
    }


    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {
        // for academic purpose.... simulate an exception
        if(tripWire){
            throw new RuntimeException("No soup for you...");
        }

        List<Account> theAccounts = new ArrayList<>();

        // create sample accounts and add it to list
        Account tempAccount1 = new Account("Daren Mitchel", "1");
        Account tempAccount2 = new Account("Kane Mama", "2");
        Account tempAccount3 = new Account("Taylor Mama", "3");
        theAccounts.add(tempAccount1);
        theAccounts.add(tempAccount2);
        theAccounts.add(tempAccount3);

        return theAccounts;
    }


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

package com.codeslayer.aopdemo.dao;

import org.springframework.stereotype.Repository;

@Repository  // make the class available for component scanning -> sub-annotation of component
public class MembershipDAOImpl implements MembershipDAO{

    @Override
    public void addAccount() {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING A MEMBERSHIP ACCOUNT");
    }


    @Override
    public void addMember() {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING A SILLY MEMBER");
    }
}

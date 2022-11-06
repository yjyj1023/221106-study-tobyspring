package com.db.dao;

import java.sql.Connection;

public class DaoFactory {

    public ConnectionMaker connectionMaker(){
        return new AWSConnectionMaker();
    }
    public UserDao userDao(){
        UserDao userDao = new UserDao(connectionMaker());
        return userDao;
    }
}

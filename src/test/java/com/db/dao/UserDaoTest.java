package com.db.dao;

import com.db.domain.User;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.sql.SQLException;

class UserDaoTest {
    @Test
    public void addAndSelect() throws SQLException, ClassNotFoundException {
        ConnectionMaker c = new AWSConnectionMaker();
        UserDao userDao = new UserDao(c);

        String id = "1";

        User user = new User(id,"YeonJae","1234");
        userDao.add(user);

        User seletedUser = userDao.get(id);

        Assertions.assertEquals("1", seletedUser.getId());
        Assertions.assertEquals("YeonJae", seletedUser.getName());
        Assertions.assertEquals("1234", seletedUser.getPassword());
    }
}
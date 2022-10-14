package com.db;

import com.db.dao.UserDao05Interface;
import com.db.dao.UserDaoFactory2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(UserDaoFactory2.class);
        UserDao05Interface userDao = ctx.getBean("userDao05Interface", UserDao05Interface.class);

    }
}

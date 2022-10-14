package com.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao05Interface {

    private ConnectionMaker connectionMaker;

    public UserDao05Interface(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

    public void add() throws ClassNotFoundException, SQLException {

        Connection c = connectionMaker.getConnection();

        PreparedStatement ps = c.prepareStatement(
                "insert into users(id, name, password) values(?, ?, ?)");
        ps.setString(1, "01");
        ps.setString(2, "Kyeongrok");
        ps.setString(3, "password");

        ps.executeUpdate();

        ps.close();
        c.close();

    }

    public static void main (String[]args) throws SQLException, ClassNotFoundException {
        UserDao05Interface dao = new UserDao05Interface(() -> {
            return null;
        });
        dao.add();
    }
}

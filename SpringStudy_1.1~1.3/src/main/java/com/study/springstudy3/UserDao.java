package com.study.springstudy3;

import com.study.springstudy2.User;

import java.sql.*;

public abstract class UserDao {
    public void add(User user) throws ClassNotFoundException, SQLException{
        Connection c = getConnection();

        PreparedStatement ps = c.prepareStatement(
                "insert into users(id, name, password) values(?, ?, ?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();
        c.close();
    }
    public User get(String id) throws ClassNotFoundException, SQLException{
        Connection c = getConnection();
        PreparedStatement ps = c.prepareStatement(
                "insert into users(id, name, password) values(?, ?, ?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();
        c.close();
    }
    public abstract Connection getConnection() throws ClassNotFoundException, SQLException;
}

public class NUserDao extends UserDao{
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        return DriverManager.getConnection("jdbc:mariadb://localhost:3306/springbook","root","qwer");
    }
}

public class DUserDao extends UserDao{
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        return DriverManager.getConnection("jdbc:mariadb://localhost:3306/springbook","root","qwer");
    }
}

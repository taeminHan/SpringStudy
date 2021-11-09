package com.study.springstudy2;

import java.sql.*;

public class UserDao {
    public void add(User user) throws ClassNotFoundException, SQLException{
        Class.forName("org.mariadb.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mariadb://localhost:3306/springbook","root","qwer");

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
        Class.forName("org.mariadb.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mariadb://localhost/springbook","root","qwer");

        PreparedStatement ps = c.prepareStatement("select * from users where id = ?");

        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        c.close();

        return user;
    }
}
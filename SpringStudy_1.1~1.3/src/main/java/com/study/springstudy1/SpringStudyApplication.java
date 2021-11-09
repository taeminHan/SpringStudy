package com.study.springstudy1;

import java.sql.SQLException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringStudyApplication {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        SpringApplication.run(SpringStudyApplication.class, args);

        UserDao dao = new UserDao();
        User user = new User();

        user.setId("taemin9705");
        user.setName("한태민");
        user.setPassword("1q2w3e4r");

        dao.add(user);

        System.out.println(user.getId() + "등록성공");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());

        System.out.println(user2.getId() + "조회 성공");

    }
}

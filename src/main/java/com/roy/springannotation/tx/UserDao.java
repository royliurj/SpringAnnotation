package com.roy.springannotation.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class UserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void insert(){
        String sql = "insert into tbl_user (username,age) values(?,?)";

        String name = UUID.randomUUID().toString();
        Integer age = 10;
        jdbcTemplate.update(sql,name,age);
    }

}

package com.you.dao;

import com.you.model.User;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

/**
 * Created by zhiyou on 15-12-1.
 */
public class UserDao {
    private SimpleJdbcTemplate jdbcTemplate;

    public SimpleJdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(SimpleJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    String sql = "insert into user(username,password) values(?,?)";
    public void addUser(User user){
        jdbcTemplate.update(sql,
                user.getUsername(),
                user.getPassword());
    }
    public int findtotal(String username,String password){
        String sql = "select count(*) from user where username=? and password=?";
       int total =   jdbcTemplate.queryForInt(sql,username,password);
        return total;
    }
}

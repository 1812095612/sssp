package com.qiaosoftware.sssp.repository.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.qiaosoftware.sssp.entities.User;
import com.qiaosoftware.sssp.repository.UserRepositoryExt;

public class UserRepositoryImpl implements UserRepositoryExt {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @PersistenceContext
    private EntityManager entityManager;

    public List<User> queryListByBirthday(Date birthday) {
        
        String sql = "SELECT t.* FROM `t_user` t WHERE t.`birthday` = ?";
        
        RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class) ;
        
        return jdbcTemplate.query(sql, rowMapper, birthday);
    }

}

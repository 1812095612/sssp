package com.qiaosoftware.sssp.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.qiaosoftware.sssp.base.service.BaseService;
import com.qiaosoftware.sssp.entities.User;

public interface UserService extends BaseService<User, Integer> {

    User findByUsernameAndPassword(String username, String password);
    
    Page<User> findByBirthday(Date birthday, Pageable pageable);
    
    List<User> findByBirthday(Date birthday, Sort sort);
    
    List<User> queryListByBirthday(Date birthday);
    
    List<User> queryListByUsernameLike(String username);
    
    List<User> queryListByEmail(String email);
    
    int updateUsername(String username, Integer id);

}

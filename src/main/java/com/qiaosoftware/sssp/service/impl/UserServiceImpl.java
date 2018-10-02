package com.qiaosoftware.sssp.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qiaosoftware.sssp.base.service.impl.BaseServiceImpl;
import com.qiaosoftware.sssp.entities.User;
import com.qiaosoftware.sssp.repository.UserRepository;
import com.qiaosoftware.sssp.service.UserService;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User, Integer> 
                implements UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Transactional(readOnly=true)
    public User findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    public Page<User> findByBirthday(Date birthday, Pageable pageable) {
        return userRepository.findByBirthday(birthday, pageable);
    }

    public List<User> findByBirthday(Date birthday, Sort sort) {
        return userRepository.findByBirthday(birthday, sort);
    }

    public List<User> queryListByBirthday(Date birthday) {
        return userRepository.queryListByBirthday(birthday);
    }

    public List<User> queryListByUsernameLike(String username) {
        return userRepository.queryListByUsernameLike(username);
    }

    public List<User> queryListByEmail(String email) {
        return userRepository.queryListByEmail(email);
    }

    public int updateUsername(String username, Integer id) {
        return userRepository.updateUsername(username, id);
    }

}

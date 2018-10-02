package com.qiaosoftware.sssp.repository;

import java.util.Date;
import java.util.List;

import com.qiaosoftware.sssp.entities.User;

public interface UserRepositoryExt {
    
    List<User> queryListByBirthday(Date birthday);
    
}

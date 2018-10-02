package com.qiaosoftware.sssp.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.qiaosoftware.sssp.base.repository.BaseRepository;
import com.qiaosoftware.sssp.entities.User;

public interface UserRepository extends BaseRepository<User, Integer>, UserRepositoryExt {

    User findByUsernameAndPassword(String username, String password);

    List<User> findByBirthday(Date birthday, Sort sort);

    Page<User> findByBirthday(Date birthday, Pageable pageable);

    @Query("select u from User u where u.username like %:username%")
    List<User> queryListByUsernameLike(@Param("username") String username);

    @Query(value = "SELECT t.* FROM `t_user` t WHERE t.`email`= :email", nativeQuery = true)
    List<User> queryListByEmail(@Param("email") String email);
    
    @Modifying
    @Query("update User u set u.username = ?1 where u.id = ?2")
    int updateUsername(String username, Integer id);

}

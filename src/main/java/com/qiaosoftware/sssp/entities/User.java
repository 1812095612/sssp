package com.qiaosoftware.sssp.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "t_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "username", unique = true, updatable=true)
    private String username;

    private String password;

    private String email;

    private String telephone;

    @Temporal(TemporalType.DATE)        // 1990-09-30
    private Date birthday;

    @Temporal(TemporalType.TIME)        // 09:15:02
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)   // 2018-09-28 09:15:02
    private Date lastModified;

}

package com.qiaosoftware.sssp.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
@Table(name = "t_persons")
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
    @GeneratedValue(generator = "paymentableGenerator")
    private String id;

    private String lastName;

    @Column(name="email",unique=true)
    private String email;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    
    public Person() {
        super();
    }

    public Person(String id, String lastName, String email, Date birthday) {
        super();
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.birthday = birthday;
    }
    
}

package com.qiaosoftware.sssp.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qiaosoftware.sssp.base.service.impl.BaseServiceImpl;
import com.qiaosoftware.sssp.entities.Person;
import com.qiaosoftware.sssp.service.PersonService;

@Service
@Transactional
public class PersonServiceImpl extends BaseServiceImpl<Person, Integer> implements PersonService {

}

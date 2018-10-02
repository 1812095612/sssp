package com.qiaosoftware.sssp.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qiaosoftware.sssp.base.service.impl.BaseServiceImpl;
import com.qiaosoftware.sssp.entities.Employee;
import com.qiaosoftware.sssp.repository.EmployeeRepository;
import com.qiaosoftware.sssp.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl extends BaseServiceImpl<Employee, Integer> implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void saveOrUpdate(Employee employee) {
        if (employee.getId() == null) {
            employee.setCreateTime(new Date());
        }
        employeeRepository.saveAndFlush(employee);
    }

}

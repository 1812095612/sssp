package com.qiaosoftware.sssp.service;

import com.qiaosoftware.sssp.base.service.BaseService;
import com.qiaosoftware.sssp.entities.Employee;

public interface EmployeeService extends BaseService<Employee, Integer> {

    void saveOrUpdate(Employee employee);
    
}

package com.qiaosoftware.sssp.service;

import java.util.List;

import com.qiaosoftware.sssp.base.service.BaseService;
import com.qiaosoftware.sssp.entities.Department;

public interface DepartmentService extends BaseService<Department, Integer> {
    
    List<Department> getAll();
    
}

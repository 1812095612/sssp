package com.qiaosoftware.sssp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qiaosoftware.sssp.base.service.impl.BaseServiceImpl;
import com.qiaosoftware.sssp.entities.Department;
import com.qiaosoftware.sssp.repository.DepartmentRepository;
import com.qiaosoftware.sssp.service.DepartmentService;

@Service
@Transactional
public class DepartmentServiceImpl extends BaseServiceImpl<Department, Integer> implements DepartmentService {
    
    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional(readOnly=true)
    public List<Department> getAll() {
        return departmentRepository.getAll();
    }

}

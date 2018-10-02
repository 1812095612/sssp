package com.qiaosoftware.sssp.repository;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import com.qiaosoftware.sssp.base.repository.BaseRepository;
import com.qiaosoftware.sssp.entities.Department;

public interface DepartmentRepository extends BaseRepository<Department, Integer> {

    @QueryHints({ @QueryHint(name = org.hibernate.annotations.QueryHints.CACHEABLE, value = "true") })
    @Query("SELECT d FROM Department d")
    List<Department> getAll();

}

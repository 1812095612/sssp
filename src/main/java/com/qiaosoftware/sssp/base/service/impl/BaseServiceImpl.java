package com.qiaosoftware.sssp.base.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import com.qiaosoftware.sssp.base.repository.BaseRepository;
import com.qiaosoftware.sssp.base.service.BaseService;
import com.qiaosoftware.sssp.utils.DynamicSpecifications;
import com.qiaosoftware.sssp.utils.PropertyFilter;

public class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T, ID> {
    
    @Autowired
    private BaseRepository<T, ID> baseRepository;

    public T save(T entity) {
        return baseRepository.save(entity);
    }

    public T findById(ID id) {
        return baseRepository.findOne(id);
    }

    public boolean exists(ID id) {
        return baseRepository.exists(id);
    }

    public long count() {
        return baseRepository.count();
    }

    public void delete(ID id) {
        baseRepository.delete(id);
    }

    public void delete(T entity) {
        baseRepository.delete(entity);
    }

    public void deleteAll() {
        baseRepository.deleteAll();
    }

    public List<T> findAll() {
        return baseRepository.findAll();
    }

    public List<T> findAll(Sort sort) {
        return baseRepository.findAll(sort);
    }

    public <S extends T> List<S> save(Iterable<S> entities) {
        return baseRepository.save(entities);
    }

    public void flush() {
        baseRepository.flush();
    }

    public T saveAndFlush(T entity) {
        return baseRepository.saveAndFlush(entity);
    }

    public void deleteInBatch(Iterable<T> entities) {
        baseRepository.deleteInBatch(entities);
    }

    public Page<T> findPage(Pageable pageable) {
        return baseRepository.findAll(pageable);
    }

    public List<T> findAllByIds(Iterable<ID> ids) {
        return baseRepository.findAll(ids);
    }

    public void deleteAllInBatch() {
        baseRepository.deleteAllInBatch();
    }

    public void delete(Iterable<? extends T> entities) {
        baseRepository.delete(entities);
    }

    public Page<T> findConditionPage(Pageable pageable, Map<String, Object> requestParams) {
        //1. 调用方法把传入的 requestParams 转为 Specification 对象
        Specification<T> specification = buildSpecification(requestParams);
        //2. 调用底层的 Repository 方法获取 Page 对象. 
        Page<T> page = baseRepository.findAll(specification, pageable); 
        //3. 返回 Page
        return page; 
    }
    
    protected Specification<T> buildSpecification(Map<String, Object> requestParams){
        //1. 把请求条件对应的参数的 Map 转为 PropertyFilter 的 Map
        List<PropertyFilter> filters = PropertyFilter.parseRequestParamsToPropertyFilters(requestParams);
        //2. 把 PropertyFilter 的集合转为 Specification 对象
        Specification<T> specification = DynamicSpecifications.byPropertyFilter(filters);
        return specification;
    }
    
    /**
     * Specification 封装了 JPA 的查询条件. 
                               多数情况下, 需要在方法内创建 Specification 的匿名内部类对象.
            //Predicate: 实际上是一个查询条件. 
            //CriteriaBuilder: JPA Criteria API 的工厂类. 可以从中得到 Predicate 对象. 
            //Root: 根. 可以调用其 get 方法导航到其属性. 而 get 方法的返回值是 Expression 的子接口. 
    */
    @SuppressWarnings({"unused","rawtypes","unchecked"})
    public void testSpecification() {
        Pageable pageable = new PageRequest(1 - 1, 5);  //第1页，每页5条
        Specification<T> specification = new Specification<T>() {
            public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query,
                    CriteriaBuilder builder) {
                Expression expression = root.get("id");
                Predicate predicate = builder.gt(expression, 2);
                return predicate;
            }
        };
        Page<T> page = baseRepository.findAll(specification, pageable);
    }

}

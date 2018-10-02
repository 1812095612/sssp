package com.qiaosoftware.sssp.base.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * 通用的CRUD服务接口
 * 
 * @author Administrator
 */
public interface BaseService<T, ID extends Serializable> {
    
    /**
     * 根据id判断实体是否存在
     * @param id
     * @return
     */
    boolean exists(ID id);

    /**
     * 保存单个实体 
     * @param entity
     * @return
     */
    T save(T entity);
    
    /**
     * 保存集合
     * @param entities
     * @return
     */
    <S extends T> List<S> save(Iterable<S> entities);
    
    /**
     * 执行缓存与数据库同步
     */
    void flush();
    
    /**
     * 强制执行持久化  
     * @param entity
     * @return
     */
    T saveAndFlush(T entity);

    /**
     * 根据id查找实体
     * @param id
     * @return
     */
    T findById(ID id);

    /**
     * 查询实体数量
     * @return
     */
    long count();

    /**
     * 根据Id删除实体
     * @param id
     */
    void delete(ID id);

    /**
     * 删除一个实体 
     * @param entity
     */
    void delete(T entity);
    
    /**
     * 删除一个实体集合
     * @param entities
     */
    void delete(Iterable<? extends T> entities);
    
    /**
     * 删除一个实体集合
     * @param entities
     */
    void deleteInBatch(Iterable<T> entities);

    /**
     * 删除所有实体,不用或慎用! 
     */
    void deleteAll();
    
    /**
     * 删除所有实体,不用或慎用! 
     */
    void deleteAllInBatch();

    /**
     * 查询所有实体,不用或慎用!
     * @return
     */
    List<T> findAll();

    /**
     * 排序 、查找所有实体
     * @param sort
     * @return
     */
    List<T> findAll(Sort sort);
    
    /**
     * 查询ids的所有实体
     * @param ids
     * @return
     */
    List<T> findAllByIds(Iterable<ID> ids);

    /**
     * 分页查询（含排序功能）
     * @param pageable
     * @return
     */
    Page<T> findPage(Pageable pageable);
    
    /**
     * 带查询条件的分页查询（含排序功能）
     * @param pageable  分页(含排序)
     * @param requestParams  查询条件类似
     * search_EQD_birth=2000-02-12&search_LIKES_department.departmentName=市场部
     *                            &search_LIKES_email=zhangsan@163.com&search_LIKES_lastName=张三

     * @return
     */
    Page<T> findConditionPage(Pageable pageable, Map<String, Object> requestParams);

}

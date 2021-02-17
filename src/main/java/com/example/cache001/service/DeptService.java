package com.example.cache001.service;

import com.example.cache001.bean.Department;
import com.example.cache001.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;


@Service
public class DeptService {

    //注解方式
    @Autowired
    DepartmentMapper departmentMapper;

    //编码方式
 /*   @Autowired
    RedisCacheManager CacheManager;*/


    /**  注解方式
     *
     *  缓存的数据能存入redis；
     *  第二次从缓存中查询就不能反序列化回来；
     *  存的是dept的json数据;CacheManager默认使用RedisTemplate<Object, Employee>操作Redis
     *
     *
     * @param id
     * @return
     */


    //注解方式
   // @Cacheable(cacheNames = "dept")
    public Department getDeptById(Integer id){
        System.out.println("查询部门"+id);
        Department department = departmentMapper.getDeptById(id);
        return department;
    }


    //编码方式
// 使用缓存管理器得到缓存，进行api调用
//public Department getDeptById(Integer id){
//    System.out.println("查询部门"+id);
//    Department department = departmentMapper.getDeptById(id);
//
//    //获取某个缓存dept
//    Cache dept = CacheManager.getCache("dept");
//    dept.put("1",department);
//
//    return department;



}

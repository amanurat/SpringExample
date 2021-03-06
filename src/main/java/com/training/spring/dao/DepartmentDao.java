package com.training.spring.dao;

import com.hibernate.annotation.entity.Department;

import java.util.List;

/**
 * User: assanai.manurat
 * Date: 4/21/2014
 * Time: 10:23 AM
 */
public interface DepartmentDao {

    List<Department> findAll2();

    List<Department> findAll();

    Department findById(Integer id);

    void remove(Department department);

    void insert(Department department);

}

package com.training.spring.dao;

import com.hibernate.annotation.entity.Department;

/**
 * User: assanai.manurat
 * Date: 4/21/2014
 * Time: 10:23 AM
 */
public interface DepartmentDao {
    Department findById(Integer id);

    void remove(Department department);
}

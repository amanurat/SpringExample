package com.training.spring.dao;

import com.hibernate.annotation.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 * User: assanai.manurat
 * Date: 4/21/2014
 * Time: 10:23 AM
 */
@Repository("departmentDao")
public class DepartmentDaoImpl implements DepartmentDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public Department findById(Integer id) {
        return hibernateTemplate.get(Department.class, id);
    }



}

package com.training.spring.dao.hibernate;

import com.hibernate.annotation.entity.Department;
import com.training.spring.dao.DepartmentDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User: assanai.manurat
 * Date: 4/21/2014
 * Time: 10:23 AM
 */
@Repository("departmentDao")
public class DepartmentDaoImpl implements DepartmentDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public List<Department> findAll2() {
        return sessionFactory.getCurrentSession().createQuery("from Department ").list();

    }


    @Override
    public List<Department> findAll() {
        return hibernateTemplate.find("from Department");
    }


    @Override
    @Transactional(readOnly = true)
    public Department findById(Integer id) {
        return hibernateTemplate.get(Department.class, id);
    }

    @Override
    @Transactional
    public void remove(Department department) {
        hibernateTemplate.delete(department);
    }

    @Override
    public void insert(Department department) {
        hibernateTemplate.save(department);
    }


}

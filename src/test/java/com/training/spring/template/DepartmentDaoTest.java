package com.training.spring.template;

import com.hibernate.annotation.entity.Department;
import com.training.spring.dao.DepartmentDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hibernate.annotation.entity.Employee;
import com.training.spring.dao.EmployeeDao;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * User: assanai.manurat
 * Date: 4/25/2014
 * Time: 8:50 AM
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:beans.xml"})
@TransactionConfiguration
public class DepartmentDaoTest {

    @Autowired
    private DepartmentDao departmentDao;


    @Autowired
    HibernateTemplate hibernateTemplate;

    @Test
    public void testConnectDataBase() throws Exception {
        Department department = departmentDao.findById(1);
        System.out.println("id : " + department.getId() + ", name: " + department.getDepartmentName());
    }

    @Test
    public void testDeleteShouldBeDeletedCascade() throws Exception {

//        Department department = hibernateTemplate.get(Department.class, 1);
        Department department = departmentDao.findById(1);
        departmentDao.remove(department);


    }
}

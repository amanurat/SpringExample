package com.training;

import com.hibernate.annotation.entity.Department;
import com.hibernate.annotation.entity.Employee;
import com.training.spring.Hello;
import com.training.spring.dao.DepartmentDao;
import com.training.spring.dao.EmployeeDao;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * User: assanai.manurat
 * Date: 4/20/2014
 * Time: 4:24 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml"})
@TransactionConfiguration
public class AppTest {

    @Autowired
    private Hello hello;

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private SessionFactory sessionFactory;


    @Test
    public void testLoadBeanAnnotation() throws Exception {

        System.out.println("Display load bean by annotation : "+ hello);

    }

    @Test
    public void testLoadSessionFactory() throws Exception {
        System.out.println("Display sessionFactory : "+ sessionFactory);
        Session session = sessionFactory.openSession();

        Employee employee = (Employee) session.get(Employee.class, 1);
        System.out.println("Display employee is : "+ employee);
    }

    @Test
    @Transactional
    public void testCallEmployeeDao() throws Exception {

        Employee employee = employeeDao.findById(1);

        System.out.println("Display employee using hibernate template : "+ employee);

        Department department = employee.getDepartment();

        System.out.println("Display employ has department :"+ department);

    }

    @Test
    public void testCallBySessionFactory() throws Exception {

        Department department = departmentDao.findById(1);

        System.out.println("Display department using hibernate template : "+ department);

    }


}

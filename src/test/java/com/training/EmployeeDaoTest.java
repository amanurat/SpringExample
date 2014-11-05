package com.training;

import com.hibernate.annotation.entity.Department;
import com.hibernate.annotation.entity.Employee;
import com.training.spring.dao.EmployeeDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * User: assanai.manurat
 * Date: 4/25/2014
 * Time: 8:50 AM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:beans.xml"})
public class EmployeeDaoTest {

    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

    @Autowired
    HibernateTemplate hibernateTemplate;

    @Test
    public void testConnectDataBase() throws Exception {
        EmployeeDao employeeDao = (EmployeeDao) context.getBean("employeeDao");
        Employee employee = employeeDao.findById(1);
        System.out.println("First Name : "+ employee.getFirstName() + ", Last Name: "+ employee.getLastName());
    }


}

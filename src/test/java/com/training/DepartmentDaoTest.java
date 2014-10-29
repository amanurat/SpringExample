package com.training;

import com.hibernate.annotation.entity.Department;
import com.training.spring.dao.DepartmentDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hibernate.annotation.entity.Employee;
import com.training.spring.dao.EmployeeDao;

/**
 * User: assanai.manurat
 * Date: 4/25/2014
 * Time: 8:50 AM
 */

public class DepartmentDaoTest {

    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");


    
    @Test
    public void testConnectDataBase() throws Exception {
        DepartmentDao departmentDao = (DepartmentDao) context.getBean("departmentDao");
        Department department = departmentDao.findById(1);
        System.out.println("id : " + department.getId() + ", name: " + department.getDepartmentName());


    }

}

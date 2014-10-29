package com.training;

import com.hibernate.annotation.entity.Employee;
import com.training.spring.Hello;
import com.training.spring.dao.EmployeeDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: assanai.manurat
 * Date: 4/25/2014
 * Time: 8:50 AM
 */

public class EmployeeDaoTest {

    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

    @Test
    public void testConnectDataBase() throws Exception {
        EmployeeDao employeeDao = (EmployeeDao) context.getBean("employeeDao");
        Employee employee = employeeDao.findById(1);
        System.out.println("First Name : "+ employee.getFirstName() + ", Last Name: "+ employee.getLastName());
    }

}

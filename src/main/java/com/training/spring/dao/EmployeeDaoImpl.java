package com.training.spring.dao;

import com.hibernate.annotation.entity.Employee;
import com.training.spring.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * User: assanai.manurat
 * Date: 4/20/2014
 * Time: 4:41 PM
 */
//@Repository(value = "employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    /*
     * Can use sessionFactory but you must to open and close session manually
     */
    //@Autowired private SessionFactory sessionFactory;

    @Autowired
    private HibernateTemplate hibernateTemplate;


    @Override
    @Transactional(readOnly = true)
    public Employee findById(Integer id) throws RuntimeException {
//        return (Employee) sessionFactory.openSession().get(Employee.class, id);

        logger.debug("> find employee by Id:[{}]", id);
        Employee employee = hibernateTemplate.get(Employee.class, id);

        logger.debug("> show hibernate template object : "+ hibernateTemplate);
        return employee;
    }


}

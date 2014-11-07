package com.training.spring.template;

import com.hibernate.annotation.entity.Department;
import com.hibernate.annotation.entity.Employee;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.impl.CriteriaImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

/**
 * User: assanai.manurat
 * Date: 4/25/2014
 * Time: 5:32 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:beans.xml"})
@Transactional
public class EmployeeSessionFactoryTest {

    @Autowired
    private SessionFactory sessionFactory;

    @Before
    public void setUp() throws Exception {
        sessionFactory.openSession();

    }

    @Test
    public void testFindEmployee() {

        Session session = sessionFactory.getCurrentSession();
        Employee employee = (Employee) session.get(Employee.class, 1);
        System.out.println(employee);

    }

    @Test
    public void testFindEmployeeByCriteria() {

        Session session = sessionFactory.getCurrentSession();
        List<Employee> employeeList = session.createCriteria(Employee.class).add(Restrictions.like("lastName", "Sutton")).list();

        System.out.println(employeeList);

    }

    @Test
    public void testInsertEmployeeShouldBeSucces() throws Exception {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = new Employee("David", "Henry");
        employee.setDepartment(new Department("IT"));

        session.save(employee);

    }

}

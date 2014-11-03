package com.training;

import com.hibernate.annotation.entity.Department;
import com.hibernate.annotation.entity.Employee;
import com.training.spring.bean.Hello;
import com.training.spring.dao.DepartmentDao;
import com.training.spring.dao.EmployeeDao;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User: assanai.manurat
 * Date: 4/20/2014
 * Time: 4:24 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:beans.xml"})
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

    @Autowired
    private HibernateTemplate hibernateTemplate;


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

    @Test
    public void testCalLHibernateTemplate() throws Exception {

        Department department = hibernateTemplate.get(Department.class, 1);
        System.out.println("get : " + department);

        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Department.class);
        detachedCriteria.add(Restrictions.eq("departmentName", "HR"));

        List<Department> byCriteria = hibernateTemplate.findByCriteria(detachedCriteria);
        System.out.println("criteria : " + byCriteria);

        List<Department> byNamedParam = hibernateTemplate.findByNamedParam("from Department where departmentName = :DEPARTMENTNAME ",
                "DEPARTMENTNAME", new String[]{"HRs"});
        System.out.println("nameParam : " + byNamedParam);

        List<Department> byNamedQuery = hibernateTemplate.findByNamedQuery("department.findByName()");
        System.out.println("byNamedQuery : " + byNamedQuery);
    }


}

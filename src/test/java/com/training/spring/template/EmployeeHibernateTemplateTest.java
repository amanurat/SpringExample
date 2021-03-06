package com.training.spring.template;

import java.sql.SQLException;
import java.util.List;

import com.hibernate.annotation.entity.Department;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hibernate.annotation.entity.Employee;
import org.springframework.transaction.annotation.Transactional;

/**
 * User: assanai.manurat
 * Date: 4/25/2014
 * Time: 5:32 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:beans.xml"})
@Transactional
public class EmployeeHibernateTemplateTest {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Test
    public void testFindEmployee() {

        Employee employee = hibernateTemplate.get(Employee.class, 1);
        System.out.println(employee);


        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Employee.class);
        detachedCriteria.add(Restrictions.eq("firstName", "John" ));

        List<Employee> byCriteria = hibernateTemplate.findByCriteria(detachedCriteria);
        System.out.println(byCriteria);

    }

    @Test
    public void testInsertEmployeeShouldBeSuccess() throws Exception {
//        Department department = hibernateTemplate.get(Department.class, 1);

        Employee employee = new Employee("David", "Henry");
        employee.setDepartment(new Department("IT"));
//        employee.setDepartment(department);
        hibernateTemplate.save(employee);

    }


    @Test
    public void testGetShouldLoadEmployeeByPk() throws Exception {
        Employee employee = hibernateTemplate.get(Employee.class, 1);
        System.out.println(employee);
    }

    @Test
    public void testFindBydHQLShouldFoundData() throws Exception {
        List<Employee> employeeList = hibernateTemplate.find("from Employee ");
        System.out.println(employeeList);
        display(employeeList);
    }

    @Test
    public void testindBydNameQueryShouldFoundData() throws Exception {
        List<Employee> byNamedQuery = hibernateTemplate.findByNamedQuery("employee.findAll");
        System.out.println(byNamedQuery);
        display(byNamedQuery);
    }

    @Test
    public void testindBydNameQueryAndParamShouldFoundData() throws Exception {
        List<Employee> byNamedQuery = hibernateTemplate.findByNamedQueryAndNamedParam("employee.findByFirstName", "FIRST_NAME", "John");
        System.out.println(byNamedQuery);
        display(byNamedQuery);
    }

    @Test
    public void testDeleteShouldBeCascadeDeleted() throws Exception {

        try {
            Employee employee = hibernateTemplate.get(Employee.class, 1);
            hibernateTemplate.delete(employee);

        } catch (DataAccessException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testDeleteEmployeeByCallHSQLWithCallbackShouldBeNotCascadeDeleted() throws Exception {

        try {
            hibernateTemplate.execute(new HibernateCallback<Object>() {
                @Override
                public Object doInHibernate(Session session) throws HibernateException, SQLException {

                    return session.createQuery("delete from Employee where id = 2").executeUpdate();
                }
            });
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

    }


    private void display(List<Employee> resultList) {
        for (Employee employeeModel : resultList) {
            Integer id = employeeModel.getId();
            String firstName = employeeModel.getFirstName();
            String lastName = employeeModel.getLastName();
            System.out.println("ID: "+ id + ", First Name : "+ firstName +", Last Name : "+lastName);
        }
    }


}

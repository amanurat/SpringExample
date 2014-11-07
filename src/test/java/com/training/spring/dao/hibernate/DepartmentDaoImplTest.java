package com.training.spring.dao.hibernate;

import com.hibernate.annotation.entity.Department;
import com.training.spring.dao.DepartmentDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:beans.xml"})
//@Transactional
public class DepartmentDaoImplTest  {


    @Autowired
    private DepartmentDao departmentDao;


    @Test
    public void testFindAllSholdFoundData() throws Exception {

        List<Department> result = departmentDao.findAll();
        assertEquals(true, !result.isEmpty());

    }

    @Test
    public void testFindByIdShouldFoundData() throws Exception {

        Department department = departmentDao.findById(1);
        assertNotNull(department);


    }

    @Test
    public void testRemoveShouldBeRemovedSuccess() throws Exception {

        Department department = departmentDao.findById(6);
        departmentDao.remove(department);

    }

    @Test
    public void testInsertShouldBeInsertedSuccess() throws Exception {

        try {
            Department department = new Department("AA");
            departmentDao.insert(department);
        } catch (Exception e) {
            fail();
        }


    }
}
package com.training.spring.dao.jdbc;

import com.hibernate.annotation.entity.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:beans.xml"})
@TransactionConfiguration
public class JdbcDepartmentDaoTest {


    @Autowired JdbcDepartmentDao jdbcDepartmentDao;


    @Test
    public void countShouldFoundData() throws Exception {
        int count = jdbcDepartmentDao.count();
        assertEquals(1, count);
    }

    @Test
    public void findDepartmentNameByIdShouldFoundData() throws Exception {
        String result = jdbcDepartmentDao.findDepartmentNameById(1);
        assertEquals("IT", result);
    }

    @Test
    public void findAllShouldFoundData() throws Exception {
        List<Department> result = jdbcDepartmentDao.findAll();
        assertNotNull(result);
    }

    @Test
    public void findByNameShouldFoundData() throws Exception {
        Department result = jdbcDepartmentDao.findByDepartmentName("IT");
        assertNotNull(result);
    }


    @Test
    public void insertShouldSuccess() throws Exception {
        int result = jdbcDepartmentDao.insertDepartment("Database");
        assertEquals("1", result);
    }

}
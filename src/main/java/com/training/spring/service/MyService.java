package com.training.spring.service;

import com.hibernate.annotation.entity.Department;
import com.training.spring.dao.DepartmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User: assanai.manurat
 * Date: 4/24/2014
 * Time: 10:45 PM
 */
@Service
public class MyService {

    @Autowired
    DepartmentDao departmentDao;


    @Transactional
    public List<Department> findAllDepartment() {

        return departmentDao.findAll();

    }

    private String message;


    private String firstname;
    private String lastname;


    public void message(String message) {

        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MyService{");
        sb.append("message='").append(message).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

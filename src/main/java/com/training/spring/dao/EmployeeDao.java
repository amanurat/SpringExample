package com.training.spring.dao;

import com.hibernate.annotation.entity.Department;
import com.hibernate.annotation.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * User: assanai.manurat
 * Date: 4/20/2014
 * Time: 5:02 PM
 */
public interface EmployeeDao {

    List<Employee> findAll();

    Employee findById(Integer id);

    void remove(Employee employee);

    void insert(Employee employee);

}

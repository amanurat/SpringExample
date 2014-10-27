package com.training.spring.dao;

import com.hibernate.annotation.entity.Employee;
import org.springframework.stereotype.Repository;

/**
 * User: assanai.manurat
 * Date: 4/20/2014
 * Time: 5:02 PM
 */
public interface EmployeeDao {
    Employee findById(Integer id) throws RuntimeException;
}

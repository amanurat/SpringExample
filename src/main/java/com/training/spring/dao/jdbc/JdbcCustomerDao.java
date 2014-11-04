package com.training.spring.dao.jdbc;

import com.hibernate.annotation.entity.Department;
import com.training.spring.bean.Customer;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by amanurat on 11/3/14 AD.
 */
@Repository
public class JdbcCustomerDao {

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public String findCustomerNameById(int custId){

        String sql = "SELECT NAME FROM CUSTOMER WHERE CUST_ID = ?";

        String name = (String)jdbcTemplate.queryForObject(
                sql, new Object[]{custId}, String.class);

        return name;

    }

    public Customer findByCustomerId2(int custId){

        String sql = "SELECT * FROM CUSTOMER WHERE CUST_ID = ?";

        Customer customer = (Customer)jdbcTemplate.queryForObject(
                sql, new Object[]{custId},
                new BeanPropertyRowMapper(Customer.class));

        return customer;
    }

    public List<Customer> findAll(){

        String sql = "SELECT * FROM CUSTOMER";

        List<Customer> customers = new ArrayList<Customer>();

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for (Map row : rows) {
            Customer customer = new Customer();
            customer.setCustId((Integer)row.get("CUST_ID"));
            customer.setName((String)row.get("NAME"));
            customer.setAge((Integer)row.get("AGE"));
            customers.add(customer);
        }

        return customers;
    }
}

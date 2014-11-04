package com.training.spring.dao.jdbc;

import com.hibernate.annotation.entity.Department;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by amanurat on 11/3/14 AD.
 */
@Repository
public class JdbcDepartmentDao {

//    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
//        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int count() {
        return jdbcTemplate.queryForObject("select count(*) from department where DEPARTMENT_NAME = ?", Integer.class, "HR");
    }

    //using NamedParameterJdbcTemplate
   /* public String findLastNameById(Long id) {
        String sql = "select last_name from contact where id = :contactId";
        Map<String, Object> namedParameters = new HashMap<String, Object>(); namedParameters.put("contactId", id);
        return namedParameterJdbcTemplate.queryForObject(sql, namedParameters, String.class); }

    public int countOfActorsByFirstName(String firstName) {

        String sql = "select count(*) from T_ACTOR where first_name = :first_name";

        Map<String, String> namedParameters = Collections.singletonMap("first_name", firstName);

        return this.namedParameterJdbcTemplate.queryForObject(sql, namedParameters,  Integer.class);
    }*/



    public String findDepartmentNameById(Integer id) {
        String departmentName = jdbcTemplate.queryForObject("SELECT DEPARTMENT_NAME FROM DEPARTMENT WHERE DEPARTMENT_ID = ?", new Object[]{id}, String.class);

        return departmentName;
    }


    public Department findByDepartmentName(String departmentName) {

        return this.jdbcTemplate.queryForObject("SELECT * FROM DEPARTMENT WHERE DEPARTMENT_NAME = ? ", new String[]{ departmentName},
                new RowMapper<Department>() {
                    @Override
                    public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Department department = new Department();
                        department.setId(rs.getInt("DEPARTMENT_ID"));
                        department.setDepartmentName(rs.getString("DEPARTMENT_NAME"));
                        return department;
                    }
                });


    }

    public List<Department> findAll() {
        List<Department> result = this.jdbcTemplate.query("SELECT * FROM DEPARTMENT",
                new RowMapper<Department>() {
                    public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Department department = new Department();
                        department.setId(rs.getInt("DEPARTMENT_ID"));
                        department.setDepartmentName(rs.getString("DEPARTMENT_NAME"));
                        return department;
                    }
                });

        return result;

    }


    @Transactional
    public int insertDepartment(String departmentName) {
        try {
            this.jdbcTemplate.update("insert into department (department_name) values (?)", new String[]{ departmentName });


        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        return 1;
    }
}

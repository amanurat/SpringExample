package com.training.spring.dao.jdbc;

import com.hibernate.annotation.entity.Department;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by amanurat on 11/3/14 AD.
 */
public class JdbcDepartmentDao {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    //using NamedParameterJdbcTemplate
    public String findLastNameById(Long id) {
        String sql = "select last_name from contact where id = :contactId";
        Map<String, Object> namedParameters = new HashMap<String, Object>(); namedParameters.put("contactId", id);
        return namedParameterJdbcTemplate.queryForObject(sql, namedParameters, String.class); }

    public int countOfActorsByFirstName(String firstName) {

        String sql = "select count(*) from T_ACTOR where first_name = :first_name";

        Map<String, String> namedParameters = Collections.singletonMap("first_name", firstName);

        return this.namedParameterJdbcTemplate.queryForObject(sql, namedParameters,  Integer.class);
    }

    public int count() {
        int countOfActorsNamedJoe = this.jdbcTemplate.queryForObject(
                "select count(*) from t_actor where first_name = ?", Integer.class, "Joe");
        return countOfActorsNamedJoe;
    }

    public String queryString() {
        String lastName = this.jdbcTemplate.queryForObject(
                "select last_name from t_actor where id = ?",
                new Object[]{1212L}, String.class);

        return lastName;
    }

    public Department queryDepartmentList() {
        Department department = this.jdbcTemplate.queryForObject(
                "select id, department_name from department where id = ?",
                new Object[]{1},
                new RowMapper<Department>() {
                    public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Department department = new Department();
                        department.setId(rs.getInt("id"));
                        department.setDepartmentName(rs.getString("department_name"));
                        return department;
                    }
                });

        return department;

    }
}

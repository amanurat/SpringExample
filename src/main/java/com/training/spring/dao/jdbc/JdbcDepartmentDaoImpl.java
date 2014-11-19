package com.training.spring.dao.jdbc;

import com.hibernate.annotation.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by amanurat on 11/3/14 AD.
 */
@Repository("JdbcDepartmentDao")
public class JdbcDepartmentDaoImpl{

//    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Department findById(Integer id) {

        return jdbcTemplate.queryForObject("select * from Department where department_id = ?", new Integer[]{id }, Department.class) ;

    }


    public int count() {
        return jdbcTemplate.queryForObject("select count(*) from department where DEPARTMENT_NAME = ?", Integer.class, "HR");
    }

    public String findDepartmentNameById(Integer id) {
        String departmentName = jdbcTemplate.queryForObject("SELECT DEPARTMENT_NAME FROM DEPARTMENT WHERE DEPARTMENT_ID = ?", new Object[]{id}, String.class);

        return departmentName;
    }


    public Department findByDepartmentByName(String departmentName) {

        return this.jdbcTemplate.queryForObject("SELECT * FROM DEPARTMENT WHERE DEPARTMENT_NAME = ? ", new String[]{ departmentName},
                DepartmentRowMapper());


    }

    public List<Department> findAll() {
        List<Department> result = this.jdbcTemplate.query("SELECT * FROM DEPARTMENT",
                DepartmentRowMapper());

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


    private RowMapper<Department> DepartmentRowMapper() {
        return new RowMapper<Department>() {
            @Override
            public Department mapRow(ResultSet rs, int rowNum) throws SQLException {
                Department department = new Department();
                department.setId(rs.getInt("DEPARTMENT_ID"));
                department.setName(rs.getString("DEPARTMENT_NAME"));
                return department;
            }
        };
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

}

package com.training.spring.dao.jdbc;

import com.hibernate.annotation.entity.Department;
import com.training.spring.dao.DepartmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Date: 11/3/2014
 * Time: 10:16 AM
 *
 * @author assanai.manurat
 */
@Repository
public class DepartmentJdbcDaoImpl implements DepartmentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Department findById(Integer id) {

        List<Object> query = jdbcTemplate.query("select * from Department where DEPARTMENT_ID = ?", new RowMapper<Object>() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

                Department department = new Department();
                department.setId(rs.getInt("DEPARTMENT_ID"));
                department.setDepartmentName(rs.getString("DEPARTMENT_NAME"));

                return department;
            }
        }, new Integer[] { id });

        return null;
    }
}

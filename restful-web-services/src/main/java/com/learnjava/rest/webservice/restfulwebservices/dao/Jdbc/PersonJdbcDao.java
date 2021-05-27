package com.learnjava.rest.webservice.restfulwebservices.dao.Jdbc;


import com.learnjava.rest.webservice.restfulwebservices.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PersonJdbcDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Person> findAll(){
        return jdbcTemplate.query("select * from Person",new BeanPropertyRowMapper<>(Person.class));
    }

    public Person findById(int id){
        String sql="select * from person where id=?";
        Person person = jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Person.class));
        return person;
    }

}

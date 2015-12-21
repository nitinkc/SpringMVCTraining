package com.flags.dao.implement;

import java.sql.Timestamp;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import com.flags.dao.entity.PersonsDataEntity;
import com.flags.dao.PersonsDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by Nitin C on 12/17/2015.
 * 
 */

@Repository("IPersonDao")
public class IPersonDao implements PersonsDao {

	@Autowired
	@Qualifier(value = "personDataSource")
	private DataSource datasource;

    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void anyMethodName(){
        this.jdbcTemplate = new JdbcTemplate(datasource);
    }
    @Override
    public String addPerson(PersonsDataEntity entity) {
        // Time Stamp from java.sql package
        String query = "insert into mvc_person_details(email, password,dob,tob,country,ethnicity,isHappy,entryDate) values(?,?,?,?,?,?,?,?)";
        Object data[] = new Object[]{entity.getEmail(), entity.getPassword(), entity.getDob(), entity.getTob(), entity.getCountry(), entity.getEthnicity(), entity.getIsHappy(), new Timestamp(new Date().getTime())};
        System.out.println(entity.getEmail(), entity.getPassword(), entity.getDob(), entity.getTob(), entity.getCountry(), entity.getEthnicity(), entity.getIsHappy(), new Timestamp(new Date().getTime());

        jdbcTemplate.update(query, data);
        return "success";
    }
}

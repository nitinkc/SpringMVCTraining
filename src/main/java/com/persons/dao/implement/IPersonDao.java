package com.persons.dao.implement;

import java.sql.Timestamp;
import java.util.Date;

import javax.activation.DataSource;

import com.persons.dao.entity.PersonsDataEntity;
import com.persons.dao.PersonsDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * Created by Nitin C on 12/17/2015.
 * 
 */

@Repository("IPersonDao")
public class IPersonDao implements PersonsDao {
	
	@Autowired
	@Qualifier("personDataSource")
	private DataSource datasource;

    @Override
    public String addPerson(PersonsDataEntity entity) {
        System.out.println(entity);
        
        // Time Stamp from java.sql package
        Object query = new Object[]{entity.getEmail(), entity.getPassword(), entity.getDob(), entity.getTob(), entity.getCountry(), entity.getEthnicity(), entity.getIsHappy(), new Timestamp(new Date().getTime())};
        return "success";
    }
}

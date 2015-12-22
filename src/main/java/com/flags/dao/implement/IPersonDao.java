package com.flags.dao.implement;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import com.flags.dao.entity.PersonsDataEntity;
import com.flags.dao.PersonsDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;
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
        String query = "insert into mvc_person_details(email, password,dob,tob,country,ethinicity,isHappy,entryDate,image) values(?,?,?,?,?,?,?,?,?)";
        
        LobHandler lobHandler = new DefaultLobHandler();
        SqlLobValue sqlLobValue=new SqlLobValue(entity.getImage(),lobHandler);
        //Types from java.sql Package
        int[] dataType=new int[] { Types.VARCHAR, Types.VARCHAR,Types.VARCHAR,Types.VARCHAR,
                        Types.VARCHAR, Types.VARCHAR,Types.VARCHAR,
                        Types.TIMESTAMP,Types.BLOB };
        
        Object data[] = new Object[]{entity.getEmail(), entity.getPassword(), 
        		entity.getDob(), entity.getTob(), entity.getCountry(), 
        		entity.getEthinicity(), entity.getIsHappy(), 
        		new Timestamp(new Date().getTime()), entity.getImage()};
        System.out.println(entity.getEmail() +":"+ entity.getPassword() +": " + entity.getDob() +" "+ entity.getTob() + ":" +  entity.getCountry() + ":" + entity.getEthinicity() + ": "+  entity.getIsHappy() + ": " + new Timestamp(new Date().getTime()));

        jdbcTemplate.update(query, data, dataType);
        return "success";
    }
    
	@Override
	public List<PersonsDataEntity> findPersons() {
		String query="select * from mvc_person_details";
		List<PersonsDataEntity> fruitList=jdbcTemplate.query(query, new BeanPropertyRowMapper(PersonsDataEntity.class));
		return fruitList;
	}

	@Override
	public byte[] findImageByUID(String uId) {
		String query="select * from mvc_person_details where UID="+uId;
		PersonsDataEntity personEntity=jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper(PersonsDataEntity.class));
		return personEntity.getImage();
	}
	
}

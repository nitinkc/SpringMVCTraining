package com.flags.dao.implement;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import com.flags.controller.model.PersonsFormData;
import com.flags.dao.entity.PersonDataPaginationEntity;
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
	private int noOfRecords;

	@PostConstruct
	public void anyMethodName() {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public String addPerson(PersonsDataEntity entity) {
		// Time Stamp from java.sql package

		String query = "";
		Object[] data = {};
		int[] dataType = {};

		if (entity.getUID() == 0) {
			query = "insert into mvc_person_details(email, password,dob,tob,country,ethinicity,isHappy,entryDate,image) values(?,?,?,?,?,?,?,?,?)";
			data = new Object[] { entity.getEmail(), entity.getPassword(),
					entity.getDob(), entity.getTob(), entity.getCountry(),
					entity.getEthinicity(), entity.getIsHappy(),
					new Timestamp(new Date().getTime()), entity.getImage() };
			dataType = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
					Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
					Types.TIMESTAMP, Types.BLOB };

		} else {
			query = "update mvc_person_details set email=?,password=?,dob=?,tob=?, country=?,isHAppy=?,ethinicity=?, image=?  where UID=?";
			data = new Object[] { entity.getEmail(), entity.getPassword(),
					entity.getDob(), entity.getTob(), entity.getCountry(),
					entity.getEthinicity(), entity.getIsHappy(),
					entity.getImage(), entity.getUID() };

			dataType = new int[] { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
					Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
					Types.BLOB, Types.VARCHAR };
		}

		jdbcTemplate.update(query, data, dataType);
		return "success";
	}

	@Override
	public List<PersonsDataEntity> findPersons() {
		String query = "select * from mvc_person_details";
		List<PersonsDataEntity> personList = (List<PersonsDataEntity>) jdbcTemplate
				.query(query,
						new BeanPropertyRowMapper(PersonsDataEntity.class));
		return personList;
	}

	// Offset = , noOf Records = Total records in the database
	@Override
	public PersonDataPaginationEntity findPersonsWithPagination(int start, int noOfRecords) {
		/*
		 * A SELECT statement may include a LIMIT clause to restrict the number
		 * of rows the server returns to the client. In some cases, it is
		 * desirable to know how many rows the statement would have returned
		 * without the LIMIT, but without running the statement again. To obtain
		 * this row count, include a SQL_CALC_FOUND_ROWS option in the SELECT
		 * statement, and then invoke FOUND_ROWS() afterward:
		 */
		System.out.println("###################### DEBUG: IPersonDao############### ");
		System.out.println(noOfRecords);
		String query = "select SQL_CALC_FOUND_ROWS * from mvc_person_details limit "
				+ start + ", " + noOfRecords;

		List<PersonsDataEntity> personsDataEntityList = (List<PersonsDataEntity>) jdbcTemplate
				.query(query, new BeanPropertyRowMapper(PersonsDataEntity.class));

		// To obtain this row count, include a SQL_CALC_FOUND_ROWS option in the
		// SELECT statement, and then invoke FOUND_ROWS() afterward

		PersonDataPaginationEntity personDataPaginationEntity = new PersonDataPaginationEntity();
		int tNoOfRecords = jdbcTemplate.queryForInt("select FOUND_ROWS()");
		/* query a total number of rows from database. */
		personDataPaginationEntity.setNoOfRecords(tNoOfRecords);
		System.out.println(tNoOfRecords);
		personDataPaginationEntity.setPersonList(personsDataEntityList);

		return personDataPaginationEntity;
	}

	@Override
	public byte[] findImageByUID(String uId) {
		String query = "select * from mvc_person_details where UID=" + uId;
		PersonsDataEntity personEntity = (PersonsDataEntity)jdbcTemplate.queryForObject(query,
				new BeanPropertyRowMapper(PersonsDataEntity.class));
		return personEntity.getImage();
	}

	@Override
	public String deletePersonByUID(String uId) {
		String query = "delete from mvc_person_details where UID=" + uId;
		int p = jdbcTemplate.update(query);
		// WHERE WOULD THIS BE PRINTED??? In the COntroller, Finally
		return p == 0 ? "Data could not be deleted"
				: "Data is deleted successfully.";
	}

	@Override
	//returns only one row, thus no list is returned
	public PersonsDataEntity findPersonByUID(String uId) {
		String query = "select * from mvc_person_details where UID=" + uId;
		PersonsDataEntity personsEntity = (PersonsDataEntity)jdbcTemplate.queryForObject(query,
				new BeanPropertyRowMapper(PersonsDataEntity.class));
		return personsEntity;
	}

	@Override
	public List<PersonsDataEntity> findData(String columnName,
			String searchString) {
		// Form a search String with column name and search String
		// Can use where name like "nitin%"
		String query = "select * from mvc_person_details where " + columnName
				+ "=?";
		Object[] dataFromForm = { searchString };
		List<PersonsDataEntity> personList = jdbcTemplate.query(query,
				dataFromForm, new BeanPropertyRowMapper(PersonsDataEntity.class));
		
		
		System.out
				.println("##### DEBUG #####: " + personList.get(0).getEmail());
		return personList;
	}

	@Override
	public int getNoOfRecords() {
		return this.noOfRecords;
	}

}

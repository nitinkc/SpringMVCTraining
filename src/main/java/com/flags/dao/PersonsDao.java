package com.flags.dao;

import java.util.List;

import com.flags.controller.model.PersonsFormData;
import com.flags.dao.entity.PersonDataPaginationEntity;
import com.flags.dao.entity.PersonsDataEntity;

/**
 * Created by Nitin C on 12/17/2015.
 *
 * Taking the data from the entity class especially created for the database
 */

public interface PersonsDao {
	public String addPerson(PersonsDataEntity entity);
	List<PersonsDataEntity> findPersons();
	
	byte[] findImageByUID(String uId);
	String deletePersonByUID(String uId);
	PersonsDataEntity findPersonByUID(String uId);
	
	List<PersonsDataEntity> findData(String columnName, String searchString);
	PersonDataPaginationEntity findPersonsWithPagination(int offset, int noOfRecords);
	
	int getNoOfRecords();
}

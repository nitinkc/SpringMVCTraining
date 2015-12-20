package com.persons.dao;

import com.persons.dao.entity.PersonsDataEntity;

/**
 * Created by Nitin C on 12/17/2015.
 *
 * Taking the data from the entity class especially created for the database
 */

public interface PersonsDao {
	public String addPerson(PersonsDataEntity entity);
}

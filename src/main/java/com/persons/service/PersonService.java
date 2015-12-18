package com.persons.service;

import com.persons.dao.entity.PersonsDataEntity;
import com.persons.model.controller.PersonsFormData;

/**
 * Created by Nitin C on 12/17/2015.
 */
public interface PersonService {
    // Taking the data from the controller.model
    public String addPerson(PersonsFormData entity);
}

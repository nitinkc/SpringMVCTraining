package com.flags.service;

import com.flags.controller.model.PersonsFormData;

import java.util.List;

/**
 * 
 * Created by Nitin C on 12/17/2015.
 */

public interface PersonService {
    // Taking the data from the model.model
    public String addPerson(PersonsFormData personsFormData);
    public List<PersonsFormData> findPersons();
    public byte[] findImageByPid(String pid);
}

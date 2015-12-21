package com.flags.service.implementation;

import com.flags.dao.PersonsDao;
import com.flags.dao.entity.PersonsDataEntity;
import com.flags.controller.model.PersonsFormData;
import com.flags.service.PersonService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Nitin C on 12/17/2015.
 */

@Service("IPersonService")
public class IPersonService implements PersonService {

    @Autowired
    @Qualifier("IPersonDao")
    private PersonsDao personsDao;
    
    @Override
    public String addPerson(PersonsFormData personsFormData) {
        PersonsDataEntity entity = new PersonsDataEntity();

        // Copying the data from the form into the entity that interacts with the DB
        BeanUtils.copyProperties(personsFormData, entity);
        String result = personsDao.addPerson(entity);
        return result;
    }

    @Override
    public List<PersonsFormData> findPersons() {
        return null;
    }

    @Override
    public byte[] findImageByPid(String pid) {
        return new byte[0];
    }
}

package com.persons.service.implementation;

import com.persons.dao.PersonDao;
import com.persons.dao.entity.PersonsDataEntity;
import com.persons.model.controller.PersonsFormData;
import com.persons.service.PersonService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by Nitin C on 12/17/2015.
 */

@Service("IPersonService")
public class IPersonService implements PersonService {

    @Autowired
    @Qualifier("IPersonDao")
    private PersonDao pd;
    @Override
    public String addPerson(PersonsFormData personsFormData) {
        PersonsDataEntity entity = new PersonsDataEntity();

        // Copying the data from the form into the entity that interacts with the DB
        BeanUtils.copyProperties(personsFormData, entity);

        String result = pd.addPerson(entity);
        return result;
    }
}

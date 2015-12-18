package com.persons.dao.implement;

import com.persons.dao.entity.PersonsDataEntity;
import com.persons.dao.PersonDao;
import org.springframework.stereotype.Repository;

/**
 * Created by Nitin C on 12/17/2015.
 */

@Repository("IPersonDao")
public class IPersonDao implements PersonDao {

    @Override
    public String addPerson(PersonsDataEntity entity) {
        System.out.println(entity);
        return "success";
    }
}

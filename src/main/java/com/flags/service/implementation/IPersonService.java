package com.flags.service.implementation;

import com.flags.dao.PersonsDao;
import com.flags.dao.entity.PersonsDataEntity;
import com.flags.controller.model.PersonsFormData;
import com.flags.service.PersonService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    	List<PersonsFormData> personsFormList=new ArrayList<PersonsFormData>();
		List<PersonsDataEntity> personsEntities=personsDao.findPersons();
		for(PersonsDataEntity pde:personsEntities){
			PersonsFormData form=new PersonsFormData();
			  BeanUtils.copyProperties(pde, form);
			  personsFormList.add(form);
		}
		return personsFormList;
    }
    
    @Override
	public List<PersonsFormData> findData(String columnName, String searchString) {
		List<PersonsFormData> personsFormList=new ArrayList<PersonsFormData>();
		List<PersonsDataEntity> personsEntities=personsDao.findData(columnName, searchString);
		for(PersonsDataEntity pde:personsEntities){
			PersonsFormData form=new PersonsFormData();
			  BeanUtils.copyProperties(pde, form);
			  personsFormList.add(form);
		}
		return personsFormList;
	}
    
    @Override
    public List<PersonsFormData> findPersonsWithPagination(int start,
			int noOfRecords){
    	List<PersonsFormData> personsFormList=new ArrayList<PersonsFormData>();
		List<PersonsDataEntity> personsEntities=personsDao.findPersonsWithPagination(start, noOfRecords);
		for(PersonsDataEntity pde:personsEntities){
			PersonsFormData form=new PersonsFormData();
			  BeanUtils.copyProperties(pde, form);
			  personsFormList.add(form);
		}
		return personsFormList;
    }
    
    public int getNoOfRecords(){
    	return personsDao.getNoOfRecords();
    }
    
    @Override
    public byte[] findImageByUID(String uId) {
		return personsDao.findImageByUID(uId);
    }
    
    @Override
	  public String deletePersonByUID(String uId) {
		  return personsDao.deletePersonByUID(uId);
	  }
	  
	  @Override
	  public PersonsFormData findPersonByUID(String uId) {
		  PersonsDataEntity entity=personsDao.findPersonByUID(uId);
		  PersonsFormData personsForm = new PersonsFormData();
		  BeanUtils.copyProperties(entity, personsForm);
		  return personsForm;
	  }
}

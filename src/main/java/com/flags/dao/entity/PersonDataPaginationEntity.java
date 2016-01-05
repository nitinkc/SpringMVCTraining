package com.flags.dao.entity;

import java.util.List;

public class PersonDataPaginationEntity {
	//

	private int noOfRecords;
	private List<PersonsDataEntity> personList;

	public int getNoOfRecords() {
		return noOfRecords;
	}

	public void setNoOfRecords(int noOfRecords) {
		this.noOfRecords = noOfRecords;
	}

	public List<PersonsDataEntity> getPersonList() {
		return personList;
	}

	public void setPersonList(List<PersonsDataEntity> personList) {
		this.personList = personList;
	}

	@Override
	public String toString() {
		return "PersonDataPaginationEntity [noOfRecords=" + noOfRecords
				+ ", personList=" + personList + "]";
	}

}

package com.flags.controller.model;

import java.util.List;

/**
 * Created by Nitin C on 1/4/2016.
 */
public class PersonDataPaginationForm {

    private int currentPage;
    private int noOfRecords;
    private List<PersonsFormData> personsFormDataList;
    private int recordsPerPage = 7;
    private int noOfPages;

    public void initPagination(){
        noOfPages=(int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getNoOfRecords() {
        return noOfRecords;
    }

    public void setNoOfRecords(int noOfRecords) {
        this.noOfRecords = noOfRecords;
    }

    public List<PersonsFormData> getPersonsFormDataList() {
        return personsFormDataList;
    }

    public void setPersonsFormDataList(List<PersonsFormData> personsFormDataList) {
        this.personsFormDataList = personsFormDataList;
    }

    public int getRecordsPerPage() {
        return recordsPerPage;
    }

    public void setRecordsPerPage(int recordsPerPage) {
        this.recordsPerPage = recordsPerPage;
    }

    public int getNoOfPages() {
        return noOfPages;
    }

    public void setNoOfPages(int noOfPages) {
        this.noOfPages = noOfPages;
    }
}

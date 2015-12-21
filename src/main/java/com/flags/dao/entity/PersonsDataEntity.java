package com.flags.dao.entity;

/**
 * Created by Nitin C on 12/17/2015.
 *
 * Entity for inserting into database
 * Same as PersonaFormData!! Extra layer
 */

public class PersonsDataEntity {

    /* UID and TimeStamp to be generated from the database */
    private String email;
    private String password;
    private String dob;
    private String tob;
    private String country;
    private String ethnicity ;
    private String isHappy;

    // For creating a new Object in the IPersonService
    public PersonsDataEntity() {

    }

    // Name Constructor
    public PersonsDataEntity(String email, String password, String dob, String tob, String country, String ethnicity, String isHappy) {
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.tob = tob;
        this.country = country;
        this.ethnicity = ethnicity;
        this.isHappy = isHappy;
    }

    @Override
    public String toString() {
        String ret = "From PersonsDataEntiry : [email: " + email +
                ", password: " + password + ", Date Of Birth: " + dob + ", Time of Birth: " +
                tob + ", Country: " + country + ", ethnicity: " + ethnicity + ", isHappy? " + isHappy;

        return ret;
    }
    // ACCESSORS AND MUTATORS
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getTob() {
        return tob;
    }

    public void setTob(String tob) {
        this.tob = tob;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getIsHappy() {
        return isHappy;
    }

    public void setIsHappy(String isHappy) {
        this.isHappy = isHappy;
    }
}

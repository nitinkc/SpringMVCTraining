package com.flags.controller.model;

import java.sql.Time;
import java.sql.Date;

/**
 * 
 * Created by Nitin C on 12/17/2015.
 */
public class PersonsFormData {

    /* UID and TimeStamp to be generated from the database */
	private int UID;
    private String email;
    private String password;
    private String dob;
    private String tob;
    private String country;
    private String ethinicity ;
    private String isHappy;
    private byte[] image;

    @Override
    public String toString() {
        String ret = "From PersonsDataEntiry : [email: " + email +
                ", password: " + password + ", Date Of Birth: " + dob + ", Time of Birth: " +
                tob + ", Country: " + country + ", ethnicity: " + ethinicity + ", isHappy? " + isHappy;

        return ret;
    }

    public PersonsFormData() {
        // System.out.println("###### DEBUG ######: Person Form Data initiated");
    }

    // Name Constructor
    public PersonsFormData(String email, String password, String dob, String tob, String country, String ethnicity, String isHappy, byte[] image) {
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.tob = tob;
        this.country = country;
        this.ethinicity = ethnicity;
        this.isHappy = isHappy;
        this.setImage(image);
    }

    //    ACCESSORS AND MUTATORS
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

	public String getEthinicity() {
		return ethinicity;
	}

	public void setEthinicity(String ethinicity) {
		this.ethinicity = ethinicity;
	}

	public String getIsHappy() {
		return isHappy;
	}

	public void setIsHappy(String isHappy) {
		this.isHappy = isHappy;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public int getUID() {
		return UID;
	}

	public void setUID(int uID) {
		UID = uID;
	}  
}

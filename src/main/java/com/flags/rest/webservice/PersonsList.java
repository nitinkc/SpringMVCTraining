package com.flags.rest.webservice;

import com.flags.controller.model.PersonsFormData;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Nitin C on 1/3/2016.
 *
 * Wrapper Class
 */

// Done in order to have the XML Response on the Postman
@XmlRootElement
public class PersonsList {
    private List<PersonsFormData> personsFormData;

    public List<PersonsFormData> getPersonsFormData() {
        return personsFormData;
    }

    public void setPersonsFormData(List<PersonsFormData> personsFormData) {
        this.personsFormData = personsFormData;
    }
}

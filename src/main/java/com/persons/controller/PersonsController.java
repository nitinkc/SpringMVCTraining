package com.persons.controller;

import com.flags.service.CountryNameReverseService;
import com.persons.model.controller.PersonsFormData;
import com.persons.service.PersonService;
import com.persons.service.implementation.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Nitin C on 12/17/2015.
 */

@Controller
public class PersonsController {
    @Autowired
    @Qualifier("IPersonService")
    protected PersonService personService;

    @RequestMapping(value="uploadPersonData.do", method = RequestMethod.POST)
    public String uploadPersonsData(HttpServletRequest request, Model model){
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String dob = request.getParameter("dob");
        String tob = request.getParameter("tob");
        String country = request.getParameter("country");
        String ethnicity = request.getParameter("ethnicity");
        String isHappy = request.getParameter("isHappy");

        PersonsFormData pfd = new PersonsFormData(email,password,dob,tob,country,ethnicity,isHappy);

        model.addAttribute("message", "Success!!!");
        return "personAddSuccess";
    }
}

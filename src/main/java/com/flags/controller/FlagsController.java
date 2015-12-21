package com.flags.controller;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flags.controller.model.PersonsFormData;
import com.flags.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.flags.service.CountryNameReverseService;

import java.io.IOException;
import java.util.List;

@Controller
public class FlagsController {
	
	/* If you create Listener with the help of ContextLoader Listener, 
	 * whatever bean is managed by ContainerLoader Listener can be autowired here*/
	@Autowired()
	@Qualifier("reverseNameService")
	private CountryNameReverseService cnrs;

	@Autowired
	@Qualifier("IPersonService")
	protected PersonService personService;

    public FlagsController(){
        System.out.println("@@@@@ CONTROLLER INSTANTIATED @@@@@@@@@");
    }

	@RequestMapping(value="uploadPersonData.do", method = RequestMethod.GET)
	public String getPersonPage(Model model){
		PersonsFormData pd = new PersonsFormData();
		model.addAttribute("cform",pd);
		return "inputPerson";
	}
//    Upload persson data is the action name from the form
	@RequestMapping(value="uploadPersonData.do", method = RequestMethod.POST)
	public String uploadPersonsData(@ModelAttribute("cform")PersonsFormData pfd, Model model) {// cform from jsp and creating an obj of personsFormData
		/*String email = request.getParameter("email");
		String password = request.getParameter("password");
		String dob = request.getParameter("dob");
		String tob = request.getParameter("tob");
		String country = request.getParameter("country");
		String ethnicity = request.getParameter("ethnicity");
		String isHappy = request.getParameter("isHappy");*/

        //PersonsFormData pfd = new PersonsFormData(email, password, dob, tob, country, ethnicity, isHappy);

        // Spring Form Passing all the data
        personService.addPerson(pfd);
		model.addAttribute("message", "Success!!!");
		//Call the personAddSuccess.jsp
		return "personAddSuccess";
	}


	//Maps the forms Action to this method in Model (In Spring = "Controller")
	@RequestMapping(value="searchFlag.do", method=RequestMethod.POST)
	public String showFlag(HttpServletRequest request, Model model){
		// Pick the name out of the HTTPRequest
		// Flag name ends with .png e.g. India.jpg
		String countryName= request.getParameter("country");
		String flagAddress = "img/flags_medium/"+ countryName + ".png"; 
		
		/* Reversing the name of the Country */
		String revName = cnrs.nameReverse(countryName);

		// MODEL >>>> HashMAp that carry data from Controller to View >>>> Same Request Scope
		model.addAttribute("flag", flagAddress);
		model.addAttribute("revCountryName", revName);
		
		// Dispatch the result to the same Page
		return "searchFlag"; // View name without extension.... searchedFlag.html
	}
}

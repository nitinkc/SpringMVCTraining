package com.flags.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flags.controller.model.PersonsFormData;
import com.flags.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import com.flags.service.CountryNameReverseService;

@Controller
public class FlagsController {

	/*
	 * If you create Listener with the help of ContextLoader Listener, whatever
	 * bean is managed by ContainerLoader Listener can be autowired here
	 */
	@Autowired()
	@Qualifier("reverseNameService")
	private CountryNameReverseService cnrs;

	@Autowired
	@Qualifier("IPersonService")
	protected PersonService personService;

	public FlagsController() {
		System.out.println("@@@@@ CONTROLLER INSTANTIATED @@@@@@@@@");
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// to actually be able to convert Multi-part instance to byte[]
		// we have to register a custom editor
		binder.registerCustomEditor(byte[].class,
				new ByteArrayMultipartFileEditor());
		// now Spring knows how to handle multi-part object and convert them
	}
	
	/**
	 * REQUEST MAPPINGS
	 */
	
	@RequestMapping(value = "searchDb.do", method = RequestMethod.POST)
	public String searchDb(HttpServletRequest req,
			Model model){
		//The searchString here is the name from the jsp page
		String searchString = req.getParameter("searchString");
		String columnName = req.getParameter("column");
		
		System.out.println("Column name is: " + columnName + 
				" && searchString is " + searchString  );
		
		List<PersonsFormData> personsFormData = personService.findData(columnName, searchString);
		System.out.println("###### DEBUG ####### ");
		for(PersonsFormData pfd : personsFormData){
			System.out.println(pfd.getDob());
			
		}
		model.addAttribute("personForms",personsFormData);
		return "persons";
	}

	@RequestMapping(value = "findImageByUID.do", method = RequestMethod.GET)
	public void findImageByUID(HttpServletRequest req,
			HttpServletResponse response) {
		String uId = req.getParameter("uId");
		System.out.println(uId);
		byte[] image = personService.findImageByUID(uId);
		// writing byte array into response
		ServletOutputStream outputStream;
		try {
			outputStream = response.getOutputStream();
			outputStream.write(image);
			outputStream.flush();
		} catch (IOException e) {
			// Write something useful
			System.out.println("Cought Exception!!");
		}
	}
	
	@RequestMapping(value="editPersonByUID.do", method=RequestMethod.GET)
	public String editPersonByUID(@RequestParam("uId") String uId,Model model) {
		System.out.println(uId);
		PersonsFormData result=personService.findPersonByUID(uId);
		//System.out.println("Result get UID : " + result.getUID());
		model.addAttribute("cform", result);
		return "inputPerson";
	}
	
	@RequestMapping(value="deletePersonByUID.do",method=RequestMethod.GET)
	public String deletePersonByUID(@RequestParam("uId") String uId,Model model) {
		String result = personService.deletePersonByUID(uId);
		List<PersonsFormData>  personsForms = personService.findPersons();
		
		// This result is the result returning from the deletePersonByUID from the IPersonDao
		System.out.println("DEBUG: From DeletePersonwithUID@@@@@ CAME HERE @@@@@@    "+ result);
		//model.addAttribute("result", result);
		
		model.addAttribute("personForms", personsForms);
		return "persons";
	}
	
	@RequestMapping(value = "persons.do", method = RequestMethod.GET)
	public String showPersons(Model model) {
		List<PersonsFormData> personForms = personService.findPersons();
		model.addAttribute("personForms", personForms);
		return "persons";
	}
	
	@RequestMapping(value = "personsPagination.do", method = RequestMethod.GET)
	public String showPersonInPagination(HttpServletRequest request,
			HttpServletResponse response,Model model){
		int page = 1;
        int recordsPerPage = 3;
        if(request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));
		List<PersonsFormData> personForms = personService.
				findPersonsWithPagination((page-1)*recordsPerPage, recordsPerPage);
		
        int noOfRecords = personService.getNoOfRecords();
        int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
        
        request.setAttribute("personForms", personForms);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        request.setAttribute("noOfRecords",personService.getNoOfRecords());
        model.addAttribute("personForms", personForms);
        
        return "persons";
	}
	
	@RequestMapping(value = "uploadPersonData.do", method = RequestMethod.GET)
	public String getPersonPage(Model model) {
		PersonsFormData pd = new PersonsFormData();
		model.addAttribute("cform", pd);
		return "inputPerson";
	}

	// Upload persson data is the action name from the form
	@RequestMapping(value = "uploadPersonData.do", method = RequestMethod.POST)
	public String uploadPersonsData(@ModelAttribute("cform") PersonsFormData pfd, Model model) {
		// Spring Form Passing all the data
		personService.addPerson(pfd);
		//Check where this message goes
		model.addAttribute("message", "Success!!!");
		
		if(pfd.getUID()!=0){
			return "redirect:/persons.do";
		}
		// Call the personAddSuccess.jsp
		//give view name with out extension.
		return "personAddSuccess";
		
		// cform from jsp and creating an obj of personsFormData
				/*
				 * String email = request.getParameter("email"); String password =
				 * request.getParameter("password"); String dob =
				 * request.getParameter("dob"); String tob =
				 * request.getParameter("tob"); String country =
				 * request.getParameter("country"); String ethnicity =
				 * request.getParameter("ethnicity"); String isHappy =
				 * request.getParameter("isHappy");
				 */

				// PersonsFormData pfd = new PersonsFormData(email, password, dob, tob,
				// country, ethnicity, isHappy);
	}

	// Maps the forms Action to this method in Model (In Spring = "Controller")
	@RequestMapping(value = "searchFlag.do", method = RequestMethod.POST)
	public String showFlag(HttpServletRequest request, Model model) {
		// Pick the name out of the HTTPRequest
		// Flag name ends with .png e.g. India.jpg
		String countryName = request.getParameter("country");
		String flagAddress = "img/flags_medium/" + countryName + ".png";

		/* Reversing the name of the Country */
		String revName = cnrs.nameReverse(countryName);

		// MODEL >>>> HashMAp that carry data from Controller to View >>>> Same
		// Request Scope
		model.addAttribute("flag", flagAddress);
		model.addAttribute("revCountryName", revName);

		// Dispatch the result to the same Page
		return "searchFlag"; // View name without extension....
								// searchedFlag.html
	}
}

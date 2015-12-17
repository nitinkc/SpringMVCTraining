package com.flags.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.flags.service.CountryNameReverseService;

@Controller
public class FlagsController {
	
	/* If you create Listener with the help of ContextLoader Listener, 
	 * whatever bean is managed by ContainerLoader Listener can be autowored here*/
	@Autowired()
	@Qualifier("reverseNameService")
	private CountryNameReverseService cnrs;
	
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

package com.flags.soap.webservice;

import javax.jws.WebService;


@WebService
public class SoapHelloWorld {
	public void poke(String message){	
		Welcome welcome = new Welcome();
		welcome.setmCode("#1234");
		welcome.setMessage("Testing The SOAP Service");
	}
}

package com.flags.soap.webservice;

import javax.jws.WebService;


@WebService
public class SoapHelloWorld {
	
	public void poke(String message){	
		Welcome welcome = new Welcome();
		welcome.setmCode("#1234");
		welcome.setMessage("Testing The SOAP Service");
	}
	
	public String oddEven(int p){
		if(p%2 == 0)
			return "Even Number";
		else
			return "Odd Number";
	}
}



package com.flags.soap.webservice;

import javax.jws.WebService;


@WebService
public class SoapHelloWorld {
	public void poke(String message) throws MessageException {
		if("Nitin".equalsIgnoreCase(message)){
			Message detail=new Message();
			detail.setmCode("E3939");
			detail.setMessage("Hey you cannot sent me this message");
			MessageException exception=new MessageException("Message is not correct!",detail);
			throw exception;
			/*Throwing the User Defined Exception*/
			/*try {
				throw exception;
			} catch (MessageException e) {
				e.printStackTrace();
			}*/
		}

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



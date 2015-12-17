package com.flags.service;

import org.springframework.stereotype.Service;

@Service("reverseNameService")
public class CountryNameReverseService {
	
	public String nameReverse(String country){
		String ret="";
		
		for (int i = country.length() - 1; i >= 0 ; i--) {
			ret = ret + country.charAt(i);			
		}
		return ret;
	}
}

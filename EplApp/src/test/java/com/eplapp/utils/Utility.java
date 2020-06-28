package com.eplapp.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Utility {
	
	public String getDateTime() {
		
		Date date = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("MMDDYYYYhhmmsszzz");  
	    String strDate = formatter.format(date);  
	    
		return strDate;
	}
	
	public String genarateRandomString() {
		Random random = new Random();
		int num = random.nextInt(100000);
		return Integer.toString(num) + "new";
	}

}

package com.he.study.java8.day02;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatThreadLocal {
	
	private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>(){
		
		@Override
		protected DateFormat initialValue(){
			return new SimpleDateFormat("yyyyMMdd");
		}
		
	};
	
	public static final Date convert(String source) throws ParseException{
		return df.get().parse(source);
	}

}

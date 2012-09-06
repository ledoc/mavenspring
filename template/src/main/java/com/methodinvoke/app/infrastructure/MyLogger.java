package com.methodinvoke.app.infrastructure;

import org.apache.log4j.Logger;

/*
 * Logger this application
 * @Author Prakash Sapkota
 */
public class MyLogger {
	private static final Logger logger = Logger.getLogger("com.methodinvoke");
	
	public static void debug(String message){
		logger.debug(message);
		System.out.println(message);
	}
	
	public static void warn(String message){
		logger.warn(message);
	}
	
	public static void info(String message){
		logger.info(message);
	}
}

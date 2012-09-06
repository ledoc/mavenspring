package com.methodinvoke.app.infrastructure;

import java.io.IOException;
import java.util.Properties;

/*
 * Retrives property of any properties file in Classpath.
 */
public class MyProperties {
	static String getProperty(String name){
		Properties prop = new Properties();
		try{
			prop.load(ClassLoader.getSystemResourceAsStream("app.properties"));
			return prop.getProperty(name);
		}catch(IOException e){
			throw new RuntimeException("Could not find resource!");
		}
	}

}

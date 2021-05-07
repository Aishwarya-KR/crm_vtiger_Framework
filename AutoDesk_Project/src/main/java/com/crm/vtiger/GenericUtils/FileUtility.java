package com.crm.vtiger.GenericUtils;

import java.io.FileInputStream;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class FileUtility {

	/*
	 * This method used to read data from properties and return the value based on key specified
	 * @param key
	 */
	
	public String getPropertyKeyValue(String key) throws Throwable
	{
		FileInputStream file=new FileInputStream(IPathConstant.PROPERTY_FILEPATH);
		Properties prop=new Properties();
		prop.load(file);
		return prop.getProperty(key);
	}
	
	/*
	 * This method will return json value based on json key
	 * 
	 */
	public String getDataFromJson(String jsonkey)throws Throwable
	{
		FileReader reader=new FileReader(IPathConstant.JSON_FILEPATH);
		JSONParser parser=new JSONParser();
		Object object=parser.parse(reader);
		JSONObject jsonObject=(JSONObject) object;
		String value=jsonObject.get(jsonkey).toString();
		return value;
		
		
		
	}
	

}

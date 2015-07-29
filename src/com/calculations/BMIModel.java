package com.calculations;

import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Entity;


public class BMIModel 
{
	void addUsers(String name,String password)
	{
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Entity users = new Entity("Users");		
		users.setProperty("Name", name);
		users.setProperty("Password", password);
		datastore.put(users);
	}
	
	boolean checkUser(String name,String password)
	{
		DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
		Query query = new Query("Users");
		PreparedQuery preparedQuery = datastore.prepare(query);

		boolean isUserPresent=false;

		for(Entity users : preparedQuery.asIterable())
		{
			  String lname = (String) users.getProperty("Name");
			  String lpassword = (String) users.getProperty("Password");
			  if((lname.equalsIgnoreCase(name))&&(lpassword.equalsIgnoreCase(password)))
				  isUserPresent=true;
		}
		
		/*
		
		
		Set<String> set=map.keySet();
		for(String str:set)
		{
			if(str.equalsIgnoreCase(name))
			{
				if(password.equals(map.get(str)))
				{
					isUserPresent=true;
					break;
				}
			}
		}*/
		return isUserPresent;
	}
}

package com.calculations;

import java.util.*;

public class BMIModel 
{
	static 	HashMap<String, String> map=new HashMap<String,String>();

	void addUsers(String name,String password)
	{
		map.put(name, password);
	}
	
	boolean checkUser(String name,String password)
	{
		boolean isUserPresent=false;
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
		}
		return isUserPresent;
	}
}

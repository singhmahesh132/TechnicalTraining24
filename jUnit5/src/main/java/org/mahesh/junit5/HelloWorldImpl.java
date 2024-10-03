package org.mahesh.junit5;

public class HelloWorldImpl implements HelloWorld 
{
	@Override
	public String hello(String name) 
	{
		if(name == null || name.isEmpty())
		{
			throw new IllegalArgumentException();
		}
		return "Hello "+name;
	}

}

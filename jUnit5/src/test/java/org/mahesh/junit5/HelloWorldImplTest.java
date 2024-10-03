package org.mahesh.junit5;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HelloWorldImplTest 
{
	private HelloWorld h;

	@BeforeEach
	public void setup()
	{
		System.out.println("SetUp Method");
		h=new HelloWorldImpl();
	}

	@Test
	public void helloWorldShouldReturnValidOutput() 
	{
		System.out.println("Hello Folks, Welcome to Testing");
		String result=h.hello("Junit");
		Assertions.assertNotNull(result);
		Assertions.assertEquals("Hello Junit", result);
		
	}

	@Test
	public void helloWorld_Should_Throw_Exception_Not_Null() 
	{
		System.out.println("HelloWorld_Should_Throw_Exception if Name is Null");
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
		h.hello(null);
		});
	}

	@Test
	public void helloWorld_Should_Throw_Exception_Not_Blank() 
	{
		System.out.println("HelloWorld_Should_Throw_Exception if Name is Blank or Empty");
		Assertions.assertThrows(IllegalArgumentException.class, ()->{
			h.hello("");
			});
	}

	@AfterEach
	public void teardown()
	{
		System.out.println("TearDown Method");
		h=null;
	}
}

package com.hyx.schema;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import junit.framework.TestCase;

public class PeopleTest extends TestCase {
	
	@Test
	public void testPeople() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");  
		People p = (People)ctx.getBean("id1");  
		System.out.println(p.getId());  
		System.out.println(p.getName());  
		System.out.println(p.getAge());
	}
}

package com.moji.disconf.tutorial1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		String[] locations = new String[]{"classpath:application_ac.xml"};
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(locations);
		DisconfDemoTask task = context.getBean("disconfDemoTask", DisconfDemoTask.class);
		task.run();
	}
}

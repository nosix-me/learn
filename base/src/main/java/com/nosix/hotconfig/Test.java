package com.nosix.hotconfig;


import java.util.concurrent.TimeUnit;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import em.nosix.tools.config.hotconfig.HotConfig;



public class Test {

//	public static void main(String[] args) {
//		String rootPath = Thread.currentThread().getContextClassLoader().getResource("").toString().replace("file:","");
//		File file = new File(rootPath+"test.properties");
//		new PropertiesConfiguration(file, new TestProperties(), 10);
//		
//	}
	@SuppressWarnings("resource")
	public static void main(String[] args) throws InterruptedException {
		String[] locations = new String[]{"classpath:application_ac.xml"};
		new ClassPathXmlApplicationContext(locations);
		try {
			HotConfig.init("com.nosix");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		while(true) {
			TestProperties.print();
			TimeUnit.SECONDS.sleep(1);
		}
	}
}

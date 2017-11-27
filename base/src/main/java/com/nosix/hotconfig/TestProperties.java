package com.nosix.hotconfig;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import em.nosix.tools.config.common.BaseHandler;
import em.nosix.tools.config.hotconfig.annotation.HConfig;


/**
 * Unit test for simple App.
 */
public class TestProperties extends BaseHandler {

	@HConfig(source="${com.moji.name}")
	private static Map<String,String> testMap = new HashMap<String, String>();
	
	@Override
	public void doEventHandler(Map<String, String> settings) {
		for( Entry<String, String> it : testMap.entrySet()) {
			System.out.println(it.getKey()+"#"+it.getValue());
		}
	}
	
	public static void print() {
		for( Entry<String, String> it : testMap.entrySet()) {
			System.out.println(it.getKey()+"#"+it.getValue());
		}
	}
}

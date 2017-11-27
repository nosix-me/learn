package com.nosix;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.xiaoleilu.hutool.io.FileUtil;

import Jama.Matrix;

public class Test {
	private static Map<String, String> cacheMap = new HashMap<String,String>();

	public static void main(String[] args) throws IOException {
		String json = FileUtil.readString(new File("/Users/nosix/Projects/workspace_new/learn/base/src/main/resources/test.json"), Charset.forName("utf8"));
		JsonParser parser = new JsonParser();
		JsonObject featureSettings = parser.parse(json).getAsJsonObject();
		JsonObject setting = featureSettings.get("resources_title").getAsJsonObject();
		int type = setting.get("type").getAsInt();;
		JsonArray datas = setting.get("data").getAsJsonArray();
		JsonElement statisticObject = setting.get("statistic");
		StringBuffer sb = new StringBuffer();
		for( int i= 370; i < 669; i++) {
			String value = "0.11";
//			if(type == 3) {
//				String comment = setting.get("comment").getAsString();
//				String tempKey = i+"_"+comment;
//				if(!cacheMap.containsKey(tempKey)) {
//					for(int j = 0; j < datas.size(); j++) { 
//						JsonObject data = datas.get(j).getAsJsonObject();
//						Iterator<Entry<String, JsonElement>> it = data.entrySet().iterator();
//						while(it.hasNext()) {
//							Entry<String, JsonElement> temp = it.next();
//							cacheMap.putIfAbsent(temp.getKey()+"_"+comment, temp.getValue().getAsString()+",");
//						}
//					}
//				}
//			}
			if(type ==4) {
				String comment = setting.get("comment").getAsString();
				String tempKey = i+"_"+comment;
				if(!cacheMap.containsKey(tempKey)) {
					for(int j = 0; j < datas.size(); j++) { 
						JsonObject data = datas.get(j).getAsJsonObject();
						Iterator<Entry<String, JsonElement>> it = data.entrySet().iterator();
						while(it.hasNext()) {
							Entry<String, JsonElement> temp = it.next();
							cacheMap.putIfAbsent(temp.getKey()+"_"+comment, temp.getValue().getAsString());
						}
					}
				}
				String append = cacheMap.get(tempKey);
				if(!StringUtils.isEmpty(append)) {
					sb.append(append+":"+value+",");
				}
			}
		}
		System.out.println(cacheMap);
	}
}


//private static String url = "http://t.appshike.com/itry_cooperate.groovy?idfa=39325DE2-11D4-4C64-9CF8-DC7DD45F7CC2&appid=434209233&mac=020000000000&source=434209233|2323";
//private static AtomicInteger age = new AtomicInteger();
//public static void main(String[] args) {
//	age.incrementAndGet();
//	if(url.contains("|")) {
//		url = url.replace("|","%7c");
//	}
//	System.out.println(url);
//}

//public static String evaluate(Double value, Long digit) {
//if(value == null) {
//	return "NULL";
//}
//String digitStr = generateFormat(digit);
//DecimalFormat df = new DecimalFormat(digitStr);
//return df.format(value);
//}
//
//private static String generateFormat(Long digit) {
//String digitStr = "0.";
//if(digit == null) {
//	digit = 5l;
//}
//for(int i = 0;i < digit; i++) {
//	digitStr +="0";
//}
//return digitStr;
//}
//public static String evaluate(String str, String delim, Long count){
//if(StringUtils.isEmpty(str)) {
//	return null;
//}
//if(!str.contains(delim) || count <= 0) {
//	return str;
//}
//int index = 0;
//while(count > 0 && (index = str.indexOf(delim, index+1)) != -1) {
//	count --;
//}
//return str.substring(0,index);
//}
//String key = "123213_232131_3_4_5";
//System.out.println(evaluate(key, "_", 4l));
//key = key.substring(0, key.lastIndexOf("_")) + "other";
//System.out.println(key);
//System.out.println(evaluate(10.023231231, 5l));
//byte[] jsonDatas = FileUtils.readFileToByteArray(new File("/Users/nosix/Projects/workspace_new/udf-ctr/src/resources/feature_settings.json"));
//JsonParser parser = new JsonParser();
//JsonObject featureSettings = parser.parse(new String(jsonDatas)).getAsJsonObject();
//System.out.println(featureSettings);

//HashMap<String, String> indexFeatures = new HashMap<String, String>();
//indexFeatures.put("14_207", "feeds");
//indexFeatures.put("13", "name");
//List<String> specialKeys = new ArrayList<String>();
//for(Entry<String, String> it : indexFeatures.entrySet()) {
//	String key = it.getKey();
//	if(key.contains("_")) {
//		specialKeys.add(key);
//
//	}
//}
//for(String key: specialKeys) {
//	String[] items = key.split("_");
//	Integer left = Integer.parseInt(items[0]);
//	Integer right = Integer.parseInt(items[1]);
//	for(int i = left; i <= right; i++) {
//		indexFeatures.put(i+"", indexFeatures.get(key));
//	}
//}
//System.out.println(indexFeatures);

//long unix = Long.parseLong("333.222");
//Calendar cal = Calendar.getInstance();
////处理星期
//System.out.println(cal.get(Calendar.DAY_OF_WEEK));
//while(true) {
//	Integer array[] = new Integer[1024];
//	try {
//		TimeUnit.SECONDS.sleep(1);
//	} catch (InterruptedException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//}
//Set<String> result = new HashSet<String>();
//result.add("1");
//Types one = Types.One;
//Types two = Types.Two;
//if(one == two) {
//	System.out.println("true");
//} else {
//	System.out.println("false");
//}
//Map<String,String> temp = new ConcurrentHashMap<String, String>();
//ExecutorService threadPool = Executors.newFixedThreadPool(10);
//threadPool.submit(new Runnable() {
//	
//	@Override
//	public void run() {
//		// TODO Auto-generated method stub
//		
//	}
//});

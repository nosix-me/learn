package com.moji.apollo;

import java.util.concurrent.TimeUnit;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigChangeListener;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.model.ConfigChange;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;

public class App {
	
    public static void main( String[] args ){
    	
    	Config config = ConfigService.getAppConfig(); //config instance is singleton for each namespace and is never null
    	String someKey = "name";
    	String someDefaultValue = "test";
    	String value = config.getProperty(someKey, someDefaultValue);
        System.out.println(value);
        config.addChangeListener(new ConfigChangeListener() {
            @Override
            public void onChange(ConfigChangeEvent changeEvent) {
                System.out.println("Changes for namespace " + changeEvent.getNamespace());
                for (String key : changeEvent.changedKeys()) {
                    ConfigChange change = changeEvent.getChange(key);
                    System.out.println(String.format("Found change - key: %s, oldValue: %s, newValue: %s, changeType: %s", change.getPropertyName(), change.getOldValue(), change.getNewValue(), change.getChangeType()));
                }
            }
        });
        
        String somePublicNamespace = "TEST1.NS-PUBLIC";
        Config confignew  = ConfigService.getConfig(somePublicNamespace);
        someKey = "age";
        someDefaultValue = "someDefaultValueForTheKey";
        value = confignew.getProperty(someKey, someDefaultValue);
        System.out.println(value);
        while(true) {
        	try {
				TimeUnit.SECONDS.sleep(1);
			} catch (Exception e) {}
        }
    }
}

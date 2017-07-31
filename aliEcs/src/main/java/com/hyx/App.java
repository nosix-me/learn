package com.hyx;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.ecs.model.v20140526.DescribeInstancesRequest;
import com.aliyuncs.ecs.model.v20140526.DescribeInstancesResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
    	DescribeInstancesRequest describe = new DescribeInstancesRequest();
    	IClientProfile profile = DefaultProfile.getProfile("cn-", "LTAIwjhV0J7N5tSB", "HjgCC8gRQTbkGH5juPtiaabDFn1Qog");
    	IAcsClient client = new DefaultAcsClient(profile);
    	try {
        	DescribeInstancesResponse response = client.getAcsResponse(describe);
        }catch (ServerException e) {
    		e.printStackTrace();
    	} 
    	catch (ClientException e) {
        	e.printStackTrace();
    	} 
    }
}

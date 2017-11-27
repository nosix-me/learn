package com.hyx.learn.main;
import org.apache.thrift.transport.TFramedTransport;  
import org.apache.thrift.transport.TSocket;  
import org.apache.thrift.transport.TTransport;

import com.hyx.learn.extension.AttachableBinaryProtocol;
import com.hyx.learn.service.DemoService;  

  
public class Client {  
    public static void main(String[] args) throws Exception{  
        TSocket socket = new TSocket("127.0.0.1", 9090);  
        socket.setTimeout(3000);  
        TTransport transport = new TFramedTransport(socket);  
        AttachableBinaryProtocol protocol = new AttachableBinaryProtocol(transport);
        transport.open();  
        System.out.println("Connected to Thrfit Server");  
          
        protocol.getAttachment().put("cost", "1000");
        DemoService.Client client = new DemoService.Client.Factory()  
                .getClient(protocol); 
        String result = client.sayHi("Jack");
        System.out.println(result);  
    }  
}  
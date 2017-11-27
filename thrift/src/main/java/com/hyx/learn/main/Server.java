package com.hyx.learn.main;
import org.apache.thrift.TProcessor;  
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadedSelectorServer;
import org.apache.thrift.transport.TNonblockingServerSocket;

import com.hyx.learn.extension.AttachableBinaryProtocol;
import com.hyx.learn.extension.TraceProcessor;
import com.hyx.learn.service.DemoService;
import com.hyx.learn.service.DemoService.Iface;
import com.hyx.learn.service.DemoServiceImpl;  
  
  
public class Server {  
    public static void main(String[] args){  
        TNonblockingServerSocket socket;  
        try {  
            socket = new TNonblockingServerSocket(9090);  
            TThreadedSelectorServer.Args options=new TThreadedSelectorServer.Args(socket);
            TProcessor processor = new DemoService.Processor<Iface>(new DemoServiceImpl());  
            options.processor(new TraceProcessor(processor, 9090));
            options.protocolFactory(new AttachableBinaryProtocol.Factory());  
            TServer server=new TThreadedSelectorServer(options);
            System.out.println("Thrift Server is running at 9090 port");  
            server.serve();          
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        }  
    }  
}  
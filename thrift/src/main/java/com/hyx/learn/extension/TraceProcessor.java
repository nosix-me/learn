package com.hyx.learn.extension;
import java.util.Map;

import org.apache.thrift.TException;  
import org.apache.thrift.TProcessor;  
import org.apache.thrift.protocol.TProtocol;  
  
public class TraceProcessor implements TProcessor {  
    private TProcessor realProcessor;  
      
    private String serviceId;  
      
    private String serviceName;  
      
    private int port;  
      
    public TraceProcessor(TProcessor realProcessor, int port) {  
        this(realProcessor, "", "", port);  
    }  
      
      
    public TraceProcessor(TProcessor realProcessor, String serviceName, int port) {  
        this(realProcessor, serviceName, serviceName, port);  
    }  
      
    public TraceProcessor(TProcessor realProcessor, String serviceId, String serviceName, int port) {  
        this.realProcessor = realProcessor;  
        this.serviceId = serviceId;   
        this.serviceName = serviceName;  
        this.port = port;  
    }  
  
    @Override  
    public boolean process(TProtocol in, TProtocol out) throws TException {  
        Map<String, String> attachment = null;  
          
        if(in instanceof AttachableBinaryProtocol){  
            AttachableBinaryProtocol inProtocal = (AttachableBinaryProtocol)in;  
            inProtocal.readMessageBegin();  
  
            // 先读MessageBegin来获得Attachment 
            boolean isAttachableRequest = false;  
            try {  
                isAttachableRequest = inProtocal.readFieldZero();  
            } catch (Exception e) {  
            }  
            // 重置TramedTransport内部的流,不影响Thrift框架的正常执行流程  
            inProtocal.resetTFramedTransport(in);  
              
            if(isAttachableRequest){  
                attachment = ((AttachableBinaryProtocol)in).getAttachment();  
                System.out.println(attachment.get("cost")); 
            }  
                          
        }  
          
        boolean result = realProcessor.process(in, out);  
          
          
        return result;  
    }  
  
}  
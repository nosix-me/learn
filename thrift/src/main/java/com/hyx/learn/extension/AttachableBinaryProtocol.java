package com.hyx.learn.extension;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TField;
import org.apache.thrift.protocol.TMap;
import org.apache.thrift.protocol.TMessage;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.protocol.TProtocolFactory;
import org.apache.thrift.protocol.TType;
import org.apache.thrift.transport.TMemoryInputTransport;
import org.apache.thrift.transport.TTransport;

public class AttachableBinaryProtocol extends TBinaryProtocol {

	
	private Map<String, String> attachment;
	
	public AttachableBinaryProtocol(TTransport trans) {
		super(trans);
		attachment = new HashMap<String, String>();
	}
	
	public AttachableBinaryProtocol(TTransport trans, boolean strictRead, boolean strictWrite) {
		super(trans);
		strictRead_ = strictRead;
		strictWrite_ = strictWrite;
		attachment = new HashMap<String, String>();
	}
	
	public static class Factory implements TProtocolFactory {

		private static final long serialVersionUID = 2759331782858971797L;
		protected boolean strictRead_ = false;
		protected boolean strictWrite_ = true;
		
		public Factory() {
			this(false, true);
		}
		
		public Factory(boolean strictRead, boolean strictWrite) {  
            strictRead_ = strictRead;  
            strictWrite_ = strictWrite;  
        }  
		
		@Override
		public TProtocol getProtocol(TTransport trans) {
			AttachableBinaryProtocol proto = new AttachableBinaryProtocol(trans, strictRead_, strictWrite_);
			return proto;
		}
	}
	
	public void writeMessageBegin(TMessage message) throws TException {
		super.writeMessageBegin(message);
		if(attachment.size() > 0) {
			writeFieldZero();
		}
	}

	private void writeFieldZero() throws TException {
		TField RTRACE_ATTACHMENT = new TField("rtraceAttachment", TType.MAP, (short)0);
		this.writeFieldBegin(RTRACE_ATTACHMENT);
		{
			this.writeMapBegin(new TMap(TType.STRING, TType.STRING, attachment.size()));
			for (Map.Entry<String, String> entry : attachment.entrySet()) {  
                this.writeString(entry.getKey());  
                this.writeString(entry.getValue());  
            }  
            this.writeMapEnd(); 
		}
	    this.writeFieldEnd(); 
	}
	
	public boolean readFieldZero() throws Exception {
		TField schemeField = this.readFieldBegin(); 
		
		if(schemeField.id ==0 && schemeField.type == org.apache.thrift.protocol.TType.MAP) {
			TMap _map = this.readMapBegin();
			attachment = new HashMap<String, String>(2 * _map.size);  
			for (int i = 0; i < _map.size; ++i) {  
                String key = this.readString();  
                String value = this.readString();  
                attachment.put(key, value);  
            }  
            this.readMapEnd();
		}
		this.readFieldEnd();  
        return attachment.size() > 0 ? true: false; 
	}
	
	public Map<String, String> getAttachment() {  
        return attachment;  
    }
	
	/* 
     * 重置TFramedTransport流，不影响Thrift原有流程 
     */  
    public void resetTFramedTransport(TProtocol in) {  
        try {  
            Field readBuffer_ = TFramedTransportFieldsCache.getInstance()  
                    .getTFramedTransportReadBuffer();  
            Field buf_ = TFramedTransportFieldsCache.getInstance()  
                    .getTMemoryInputTransportBuf();  
  
            if (readBuffer_ == null || buf_ == null) {  
                return;  
            }  
  
            TMemoryInputTransport stream = (TMemoryInputTransport) readBuffer_  
                    .get(in.getTransport());  
            byte[] buf = (byte[]) (buf_.get(stream));  
            stream.reset(buf, 0, buf.length);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
    
    private static class TFramedTransportFieldsCache {  
        private static TFramedTransportFieldsCache instance;  
        private final Field readBuffer_;  
        private final Field buf_;  
        private final String TFramedTransport_readBuffer_ = "readBuffer_";  
        private final String TMemoryInputTransport_buf_ = "buf_";  
  
        private TFramedTransportFieldsCache() throws Exception {  
            readBuffer_ = org.apache.thrift.transport.TFramedTransport.class  
                    .getDeclaredField(TFramedTransport_readBuffer_);  
            readBuffer_.setAccessible(true);  
            buf_ = org.apache.thrift.transport.TMemoryInputTransport.class  
                    .getDeclaredField(TMemoryInputTransport_buf_);  
            buf_.setAccessible(true);  
        }  
  
        public static TFramedTransportFieldsCache getInstance()  
                throws Exception {  
            if (instance == null) {  
                synchronized (TFramedTransportFieldsCache.class) {  
                    if (instance == null) {  
                        instance = new TFramedTransportFieldsCache();  
                    }  
                }  
            }  
            return instance;  
        }  
  
        public Field getTFramedTransportReadBuffer() {  
            return readBuffer_;  
        }  
  
        public Field getTMemoryInputTransportBuf() {  
            return buf_;  
        }  
    }
}

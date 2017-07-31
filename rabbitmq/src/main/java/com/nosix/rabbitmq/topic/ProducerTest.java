package com.nosix.rabbitmq.topic;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
 
public class ProducerTest {
    @SuppressWarnings("unchecked")
	public ProducerTest() throws Exception{
        
        Producer producer = new Producer("direct", "test.one");
         
        for (int i = 0; i < 100000; i++) {
            @SuppressWarnings("rawtypes")
			HashMap message = new HashMap();
            message.put("message number", i);
            producer.sendMessage(message);
            System.out.println("Message Number "+ i +" sent.");
        }
    }
     
    /**
     * @param args
     * @throws SQLException
     * @throws IOException
     */
    public static void main(String[] args) throws Exception{
      new ProducerTest();
    }
}
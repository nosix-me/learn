package com.nosix.rabbitmq.direct;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
 
public class ProducerTest {
	public ProducerTest() throws Exception{
        
        Producer producer = new Producer("direct", "test");
         
        for (int i = 0; i < 100000; i++) {
            producer.sendMessage(new String("message"));
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
package com.nosix.rabbitmq.direct;
import java.io.IOException;
import java.sql.SQLException;
 
public class Consumer {
    public Consumer() throws Exception{
         
        QueueConsumer consumer = new QueueConsumer("directQueue","test", "direct");
        Thread consumerThread = new Thread(consumer);
        consumerThread.start();
    }
     
    /**
     * @param args
     * @throws SQLException
     * @throws IOException
     */
    public static void main(String[] args) throws Exception{
      new Consumer();
    }
}
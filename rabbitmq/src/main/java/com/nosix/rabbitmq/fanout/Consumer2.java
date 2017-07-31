package com.nosix.rabbitmq.fanout;
import java.io.IOException;
import java.sql.SQLException;
 
public class Consumer2 {
    public Consumer2() throws Exception{
         
        QueueConsumer consumer = new QueueConsumer("queue1","queue1");
        Thread consumerThread = new Thread(consumer);
        consumerThread.start();
    }
     
    /**
     * @param args
     * @throws SQLException
     * @throws IOException
     */
    public static void main(String[] args) throws Exception{
      new Consumer2();
    }
}
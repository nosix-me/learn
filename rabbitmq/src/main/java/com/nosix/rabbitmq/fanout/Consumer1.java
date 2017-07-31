package com.nosix.rabbitmq.fanout;
import java.io.IOException;
import java.sql.SQLException;
 
public class Consumer1 {
    public Consumer1() throws Exception{
         
        QueueConsumer consumer = new QueueConsumer("queue2","queue2");
        Thread consumerThread = new Thread(consumer);
        consumerThread.start();
    }
     
    /**
     * @param args
     * @throws SQLException
     * @throws IOException
     */
    public static void main(String[] args) throws Exception{
      new Consumer1();
    }
}
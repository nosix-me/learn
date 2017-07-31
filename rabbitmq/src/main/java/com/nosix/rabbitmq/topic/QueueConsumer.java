package com.nosix.rabbitmq.topic;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;

import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;
 
 
/**
 * 读取队列的程序端，实现了Runnable接口。
 * @author syntx
 *
 */
public class QueueConsumer implements Runnable, Consumer{
     
	protected Channel channel;
    protected Connection connection;
    protected String endPointName;
	protected String routeKey;
	protected String exchange;
    public QueueConsumer(String endPointName,String routeKey,String exchange) throws IOException{
    	this.endPointName = endPointName;
        this.routeKey = routeKey;
        this.exchange = exchange;
        //Create a connection factory
        ConnectionFactory factory = new ConnectionFactory();
        
        //hostname of your rabbitmq server
        factory.setHost("localhost");
        
        //getting a connection
        connection = factory.newConnection();
        
        //creating a channel
        channel = connection.createChannel();
        
        channel.exchangeDeclare(exchange, "topic");
        
        //declaring a queue for this channel. If queue does not exist,
        //it will be created on the server.
        channel.queueDeclare(endPointName, false, false, false, null);
        
        channel.queueBind(endPointName, exchange, routeKey);       
    }
     
    public void run() {
        try {
            //start consuming messages. Auto acknowledge messages.
            channel.basicConsume(endPointName, true,this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    /**
     * Called when consumer is registered.
     */
    public void handleConsumeOk(String consumerTag) {
        System.out.println("Consumer "+consumerTag +" registered");    
    }
 
    /**
     * Called when new message is available.
     */
    public void handleDelivery(String consumerTag, Envelope env,
            BasicProperties props, byte[] body) throws IOException {
        @SuppressWarnings("rawtypes")
		Map map = (HashMap)SerializationUtils.deserialize(body);
        System.out.println("Message Number "+ map.get("message number") + " received.");
         
    }
 
    public void handleCancel(String consumerTag) {}
    public void handleCancelOk(String consumerTag) {}
    public void handleRecoverOk(String consumerTag) {}
    public void handleShutdownSignal(String consumerTag, ShutdownSignalException arg1) {}
}
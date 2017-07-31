package com.nosix.rabbitmq.direct;
import java.io.IOException;
import java.io.Serializable;

import org.apache.commons.lang.SerializationUtils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
 
 
/**
 * The producer endpoint that writes to the queue.
 * @author syntx
 *
 */
public class Producer{
     
	protected Channel channel;
    protected Connection connection;
	protected String exchange;
	protected String routingKey;
    public Producer(String exchange,String routingKey) throws IOException{
        this.exchange = exchange;
        this.routingKey = routingKey;
        //Create a connection factory
        ConnectionFactory factory = new ConnectionFactory();
        
        //hostname of your rabbitmq server
        factory.setHost("localhost");
        
        //getting a connection
        connection = factory.newConnection();
        
        //creating a channel
        channel = connection.createChannel();
        
        channel.exchangeDeclare(exchange, "direct");
    }
 
    public void sendMessage(Serializable object) throws IOException {
        channel.basicPublish(exchange, routingKey, null, SerializationUtils.serialize(object));
    }  
}
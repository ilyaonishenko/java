package com.rabbitsender.client;

import com.rabbitmq.client.*;
import jdk.nashorn.internal.codegen.CompilerConstants;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by woqpw on 23.05.15.
 */
public class Sender {
//    @Resource
//    RabbitAdmin rabbitAdmin;
    private static final String QUEUE_NAME = "Hello";
    private static final String BACKQUEUE_NAME = "BackHello";
    private static String relplyQueue;
    private static QueueingConsumer queueingConsumer;
    private static Channel channel;
    static final ExecutorService threadPool;
    static {
        threadPool = Executors.newCachedThreadPool();
    }
    public static String answer;
    public static void main(String[] args){
        final ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        try {
            Connection connection = connectionFactory.newConnection();
            channel = connection.createChannel();
            relplyQueue = channel.queueDeclare().getQueue();
            queueingConsumer = new QueueingConsumer(channel);
            channel.basicConsume(relplyQueue,true,queueingConsumer);
            /*channel.queueDeclare(QUEUE_NAME,false,false,false,null);
            String message = "Hello world!";
            channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
            /*channel.close();
            connection.close();
//            String answer = receive(connectionFactory);
//            System.out.println(answer + " answer is");
            /*Thread newThread = new Thread(()->{
                System.out.println("new thread");
                answer = receive(connectionFactory);
                System.out.println("answer is "+answer);
            });
            newThread.start();*/
//            while(true) {
                answer = call("hello world");
                System.out.println(answer);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*public static String receive(ConnectionFactory connectionFactory){
        String answer;
        try {
            Connection connection = connectionFactory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(BACKQUEUE_NAME,false,false,false,null);
            QueueingConsumer queueingConsumer = new QueueingConsumer(channel);
            channel.basicConsume(BACKQUEUE_NAME,true,queueingConsumer);
            while(true){
                QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();
                answer = new String(delivery.getBody());
                System.out.println("Received "+answer);
                int status = channel.queueDeclarePassive(BACKQUEUE_NAME).getMessageCount();
                System.out.println("it is "+status+" messages in queue");
                return answer;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }*/
    public static String call(String message){
        String response = null;
        String corrId = java.util.UUID.randomUUID().toString();
        AMQP.BasicProperties basicProperties = new AMQP.BasicProperties
                .Builder()
                .correlationId(corrId)
                .replyTo(relplyQueue)
                .build();
        try {
            channel.basicPublish("",QUEUE_NAME,basicProperties,message.getBytes());
            while (true){
                QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();
                if(delivery.getProperties().getCorrelationId().equals(corrId)){
                    response = new String(delivery.getBody());
                    return response;
                }

            }
//            return response;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
}

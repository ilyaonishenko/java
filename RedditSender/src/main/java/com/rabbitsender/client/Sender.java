package com.rabbitsender.client;

import com.rabbitmq.client.*;
import jdk.nashorn.internal.codegen.CompilerConstants;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by woqpw on 23.05.15.
 */
public class Sender {
//    @Resource
//    RabbitAdmin rabbitAdmin;
    private static final String QUEUE_NAME = "Hello";
    private static final String BACKQUEUE_NAME = "BackHello";
//    private static String relplyQueue;
//    private static QueueingConsumer queueingConsumer;
    private static Connection connection;
    private static Channel channel;
    public static String answer;
    public static void main(String[] args){
        final ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        try {
            connection = connectionFactory.newConnection();
            channel = connection.createChannel();
//            relplyQueue = channel.queueDeclare().getQueue();
//            queueingConsumer = new QueueingConsumer(channel);
//            channel.basicConsume(relplyQueue,true,queueingConsumer);
            channel.queueDeclare(QUEUE_NAME,false,false,false,null);
            String message = "Hello world!";
            channel.basicPublish("",QUEUE_NAME,null,message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
            channel.close();
            connection.close();
//            String answer = receive(connectionFactory);
//            System.out.println(answer + " answer is");
//            Thread newThread = new Thread(()->{
//                System.out.println("new thread");
//                answer = receive(connectionFactory);
//                System.out.println("answer is "+answer);
//            });
            /*ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
            exec.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    answer = receive(connectionFactory);
                    System.out.println("answer is "+answer);
                }
            }, 0, 1, TimeUnit.SECONDS);*/


            /*while(true){
                answer = receive(connectionFactory);
                System.out.println("i get "+answer);
            }*/

                connection = connectionFactory.newConnection();
                channel = connection.createChannel();
                channel.queueDeclare(BACKQUEUE_NAME,false,false,false,null);
                QueueingConsumer queueingConsumer = new QueueingConsumer(channel);
                channel.basicConsume(BACKQUEUE_NAME,true,queueingConsumer);
            /*while (true){
                QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();
                String message2 = new String(delivery.getBody());
                System.out.println("get message2 "+message2);
            }*/
            ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
            exec.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    answer = receive(connection,channel,queueingConsumer);
                    System.out.println("answer is "+answer);
                }
            }, 0, 1, TimeUnit.SECONDS);
            System.out.println("Hello world new time");
//            System.out.println("Hello");
//            while(true) {
//                answer = call("hello world");
//                System.out.println(answer);
//            int status = channel.queueDeclarePassive(relplyQueue).getMessageCount();
//            System.out.println("it is "+status+" messages in queue");
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String receive(Connection connection,Channel channel,QueueingConsumer queueingConsumer){
        String answer;
        while(true){
            try {
                QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();
                answer = new String(delivery.getBody());
                return answer;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    public static String receive(ConnectionFactory connectionFactory){
        String answer;
        try {
            connection = connectionFactory.newConnection();
            channel = connection.createChannel();
            channel.queueDeclare(BACKQUEUE_NAME,false,false,false,null);
            QueueingConsumer queueingConsumer = new QueueingConsumer(channel);
            channel.basicConsume(BACKQUEUE_NAME,true,queueingConsumer);
//            while(true){
            int status = channel.queueDeclarePassive(BACKQUEUE_NAME).getMessageCount();
            System.out.println("it is "+status+" messages in queue");
                QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();
                answer = new String(delivery.getBody());
                System.out.println("Received "+answer);
                return answer;
//            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
    /*public static String call(String message){
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
                    response += new String(delivery.getBody());
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
    }*/
}

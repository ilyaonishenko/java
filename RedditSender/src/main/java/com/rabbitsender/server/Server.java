package com.rabbitsender.server;

import com.rabbitmq.client.*;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.IOException;

/**
 * Created by woqpw on 23.05.15.
 */
public class Server {
    private final static String QUEUE_NAME = "Hello";
    private final static String BACKQUEUE_NAME = "BackHello";
    public static void main(String args[]){
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        try {
            Connection connection = connectionFactory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME,false,false,false,null);
//            channel.basicQos(1);
            System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
            QueueingConsumer queueingConsumer = new QueueingConsumer(channel);
            channel.basicConsume(QUEUE_NAME,true,queueingConsumer);
            System.out.println(" [x] Awaiting RPC requests");
            while (true){
                QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();
//                BasicProperties basicProperties = delivery.getProperties();
//                AMQP.BasicProperties basicProperties = delivery.getProperties();
//                AMQP.BasicProperties basicProperties1 = new AMQP.BasicProperties
//                        .Builder()
//                        .correlationId(basicProperties.getCorrelationId())
//                        .build();
                String message = new String(delivery.getBody());
                System.out.println(" [x] Received '" + message + "'");
                Thread.sleep(5000);
//                String response  = "some message from server for "+message;
//                System.out.println(response);
//                String[] responseArray = response.split(" ");
//                for (String s:responseArray){
//                    channel.basicPublish("", basicProperties.getReplyTo(), basicProperties1, s.getBytes());
//                    System.out.println(s+" is sended");
////                    int status = channel.queueDeclarePassive(basicProperties.getReplyTo()).getMessageCount();
////                    System.out.println("it is "+status+" messages in queue");
//                }
//                channel.basicAck(delivery.getEnvelope().getDeliveryTag(),false);
                System.out.println("Preparing to send message back");
                Connection connection1 = connectionFactory.newConnection();
                System.out.println("Connection ok");
                Channel channel1 = connection1.createChannel();
                System.out.println("Channel ok");
                channel1.queueDeclare(BACKQUEUE_NAME,false,false,false,null);
                System.out.println("Queue declared");
                message = "helloFormServer and the last message: "+message;
                int status;
                String[] array = message.split(" ");
                for (String a:array){
                    channel1.basicPublish("",BACKQUEUE_NAME, null, a.getBytes());
                    Thread.sleep(2000);
                    System.out.println(a + " is sended");
//                    status = channel1.queueDeclarePassive(BACKQUEUE_NAME).getMessageCount();
//                    System.out.println("it is "+status+" messages in queue");
                }
                System.out.println(" all ok");
                channel1.close();
                connection1.close();

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

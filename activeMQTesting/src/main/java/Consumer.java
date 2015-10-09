import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import javax.management.Query;

/**
 * Created by woqpw on 09.10.15.
 */
public class Consumer {
    public static void main(String[] args) throws Exception{
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("testQueue");
        MessageProducer messageProducer = session.createProducer(queue);
        TextMessage textMessage = session.createTextMessage("Hello, world");
        messageProducer.send(textMessage);
        connection.stop();
        System.exit(0);
    }
}

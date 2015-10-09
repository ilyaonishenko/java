import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by woqpw on 09.10.15.
 */
public class Producer {
    public static void main(String[] args) throws Exception {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection connection = factory.createConnection();
        connection.start();
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("testQueue");
        MessageConsumer messageConsumer = session.createConsumer(queue);
        int messages = 0;
        final int MESSAGES_TO_CONSUME = 30;
        do{
            TextMessage textMessage = (TextMessage)messageConsumer.receive();
            messages++;
            System.out.println("Message #" + messages + ": " + textMessage.getText());
        } while(messages<MESSAGES_TO_CONSUME);
        connection.stop();
        System.exit(0);
    }
}

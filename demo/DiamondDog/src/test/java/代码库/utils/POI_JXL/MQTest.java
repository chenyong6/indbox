package 代码库.utils.POI_JXL;
//import com.hikvision.nms.module.sync.util.PropertiesUtil;
//
//
//public class MQTest {
//	  public static void main(String[] args) throws JMSException {
//	        ConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER, ActiveMQConnection.DEFAULT_PASSWORD, "tcp://10.0.0.109:61616");
//	        Connection connection = factory.createConnection();
//	        connection.start();
//	        Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
//	        Destination destination = session.createQueue("TestQueue");
//	        MessageProducer producer = session.createProducer(destination);
//	        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
//	        ObjectMessage message = session.createObjectMessage("hello world...");
//	        producer.send(message);
//	        session.commit();
//	        System.out.println("sent...");
//	    }
//}

package com.flags.service.implementation;

import java.util.Properties;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;

import org.springframework.stereotype.Service;

import com.flags.service.PersonJMSService;
import com.person.vo.PersonVO;

/**
 * Created by Nitin C on 12/17/2015.
 */

@Service("IPersonJMSService")
public class IPersonJMSService implements PersonJMSService {

	@Override
	public String addPerson(PersonVO personVO) {

		// JMS Sender code to send message to JMS MOM /queue
		// Point JNDI running on server
		Properties props = new Properties();
		props.setProperty("java.naming.factory.initial",
				"org.jnp.interfaces.NamingContextFactory");
		props.setProperty("java.naming.factory.url.pkgs", "org.jboss.naming");
		// 1099 JNDI port of JBOSS
		props.setProperty("java.naming.provider.url", "localhost:1099");
		// here we are reaching to the JNDI

		// From the javax.jms.Connection Package
		ConnectionFactory cf = null;
		Connection connection = null;
		try {
			// using below context object we can talk with JNDI
			// From javax.naming Package
			Context context = new InitialContext(props);
			cf = (ConnectionFactory) context.lookup("/ConnectionFactory");
			connection = cf.createConnection();
			// From javax.jms package, Session.AUTO_ACKNOWLEDGE ?????
			Session session = connection.createSession(false,
					Session.AUTO_ACKNOWLEDGE);
			// javax.jms package
			// The name of the queue is configured(placed) in an xml in
			// <JBOSS_HOME>\server\default\deploy\hornetq
			// "/queue/orderMessage" is jndi name for the queue
			Queue queue = (Queue) context.lookup("/queue/personProcessing");
			// Here we are creating producer using session + Queue
			MessageProducer publisher = session.createProducer(queue);

			// wrapping my java object into JMS API which ObjectMessage
			ObjectMessage objectMessage = session.createObjectMessage();
			objectMessage.setObject(personVO);
			// sending Message to JMS queue using MessageProducer
			publisher.send(objectMessage);
			System.out.println(" $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$"
					+ " MESSAGE FROM PERSON JMS APP :\n "
					+ "Message" + objectMessage + " is SENT to JMS queue from publisher.send"
					+ "to Queue queue/orderMessage \n PersonVO: " + personVO);
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

		} catch (Exception exe) {
			exe.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		}
		return "Data is sent to MOM!!!!!!!!!!!!!!!!";
	}
}

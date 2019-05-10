package com.yevster.util;

import javax.jms.ConnectionFactory;

import org.apache.qpid.jms.JmsConnectionFactory;

import com.microsoft.azure.servicebus.primitives.ConnectionStringBuilder;

/**
 * Creates a new JMS Connection factory to Azure Service Bus, hiding away connection details
 * @author Yev Bronshteyn
 *
 */
public class ServiceBusConnectionFactory extends JmsConnectionFactory implements ConnectionFactory{
	public ServiceBusConnectionFactory(final String connectionString, final String clientId) {
		super();
		ConnectionStringBuilder csb = new ConnectionStringBuilder(connectionString);
		String remoteUri = "amqps://" + csb.getEndpoint().getHost() + "?amqp.idleTimeout=120000&amqp.traceFrames=true";
		this.setRemoteURI(remoteUri);
		this.setClientID(clientId);
		this.setUsername(csb.getSasKeyName());
		this.setPassword(csb.getSasKey());
	}
}

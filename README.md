#Azure Service Bus JMS Connection Factory

If you're trying to use [Azure Service Bus](https://docs.microsoft.com/en-us/azure/service-bus/) with JMS, this wrapper could be useful.

How to use in Spring/Spring Boot:

1. Add the dependency to your project's POM:

```xml
		<dependency>
			<groupId>com.yevster.util</groupId>
			<artifactId>servicebus.connectionfactory</artifactId>
			<version>0.0.2</version>
		</dependency>
```

2. Configure the bean

```java

...
import com.yevster.util.ServiceBusConnectionFactory;

@Configuration
public class ServiceBusConfiguration {

  @Value("${messaging.connectionString}")
  private String connectionString;

  @Value("${spring.application.name}")
  private String clientId;

  @Bean
  public JmsTemplate jmsTemplate() throws NamingException {
    return new JmsTemplate(new CachingConnectionFactory(new ServiceBusConnectionFactory(connectionString, clientId)));
  }

}
```

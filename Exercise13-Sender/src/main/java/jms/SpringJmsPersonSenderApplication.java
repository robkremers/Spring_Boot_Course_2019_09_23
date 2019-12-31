package jms;

import javax.jms.ConnectionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;



@SpringBootApplication
@PropertySource(value = "classpath:application.properties")
@EnableJms
public class SpringJmsPersonSenderApplication implements CommandLineRunner {
	
	@Autowired
	private JmsTemplate jmsTemplate;

	public static void main(String[] args) {
		
		SpringApplication.run(SpringJmsPersonSenderApplication.class, args);

	}
	
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Sending a JMS message.");
//		jmsTemplate.convertAndSend("testQueue",new Person("Frank", "Brown"));
		
		jmsTemplate.convertAndSend("calcQueue", "+7");
		jmsTemplate.convertAndSend("calcQueue", "+8");
		jmsTemplate.convertAndSend("calcQueue", "-5");
		jmsTemplate.convertAndSend("calcQueue", "*4");
		
	}

	@Bean
	public JmsTemplate jmsTemplate(final ConnectionFactory connectionFactory) {
		final JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory);
		jmsTemplate.setMessageConverter(jacksonJmsMessageConverter());
		return jmsTemplate;
	}

	@Bean // Serialize message content to json using TextMessage
	public MessageConverter jacksonJmsMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}
}

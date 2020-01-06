package kafka;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:application.properties")
public class Receiver {
	
	public Receiver() {
		super();
		System.out.println("Receiver ínstance created.");
	}
	
    @KafkaListener(topics = {"greetingtopic"})
    public void receive(@Payload Person person,
                        @Headers MessageHeaders headers) {
        System.out.println("received message = " + person.toString());
    }

}
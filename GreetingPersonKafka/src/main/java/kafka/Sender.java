package kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@PropertySource(value = "classpath:application.properties")
public class Sender {
    @Autowired
    private KafkaTemplate<String, Person> kafkaTemplate;
    
//    @Value("greetingtopic")
    private String topic = "greetingtopic";
    
    public Sender( ) {
    	super();
//    	@Value("greetingtopic")
//    	this.topic;
//    	System.out.println("topic = " + topic);
    	System.out.println("Sender instance created.");
    }
    
    public void send(Person person){
    	System.out.println("sending person = " + person.toString() + " to topic="+ topic);
    	kafkaTemplate.send("greetingtopic", person);
    }
}

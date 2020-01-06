package kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableKafka
@EnableScheduling
@PropertySource("classpath:application.properties")
public class KafkaProjectApplication implements CommandLineRunner {

    public static void main(String[] args) {
    	System.out.println("run method: topic = " + topic);
        SpringApplication.run(KafkaProjectApplication.class, args);
    }
    
    @Autowired
    private Sender sender;
    
    @Value("${app.topic.greetingtopic}")
    private static String topic;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("run method: topic = " + topic);
		Person person = new Person("Rob", "Kremers");
		sender.send(person);
	}

}
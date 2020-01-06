package kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableKafka
@EnableScheduling
public class TrafficSensorsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(TrafficSensorsApplication.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		
	}

}
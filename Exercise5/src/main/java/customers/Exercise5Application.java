package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Exercise5Application implements CommandLineRunner {
	
	@Autowired
	private ICustomerService customerService;

	public static void main(String[] args) {
		SpringApplication.run(Exercise5Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customerService.sayHello();
		customerService.addCustomer("Frank Brown", "fbrown@acme.com","mainstreet 5", "Chicago", "60613");
	}

}

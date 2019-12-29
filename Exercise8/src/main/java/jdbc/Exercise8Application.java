package jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Exercise8Application implements CommandLineRunner {
	
	private ICustomerService customerService;
	private ILogger logger;
	
	@Autowired
	public Exercise8Application(ICustomerService customerService, ILogger logger) {
		super();
		this.customerService = customerService;
		this.logger = logger;
	}

	public static void main(String[] args) {
		SpringApplication.run(Exercise8Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customerService.sayHello();
		customerService.addCustomer(1, "Frank Brown", "fbrown@acme.com","mainstreet 5", "Chicago", "60613");
		
		Customer customer = customerService.getCustomer(1);
		logger.log("Downloaded the customer with id 1: " + customer);
		
		customer.setName("John Brown");
		customerService.updateCustomer(customer);

		customer = customerService.getCustomer(1);
		logger.log("Downloaded the updated customer with id 1: " + customer);
		
		customerService.deleteCustomer(customer);
		logger.log("The customer with id 1 has been deleted.");
		
		
		
		
	}	

}

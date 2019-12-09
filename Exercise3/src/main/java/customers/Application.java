package customers;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		ICustomerService customerService = context.getBean("customerService", ICustomerService.class);

		customerService.sayHello();
		customerService.addCustomer("Frank Brown", "fbrown@acme.com","mainstreet 5", "Chicago", "60613");
		
		context.close();
	}
}


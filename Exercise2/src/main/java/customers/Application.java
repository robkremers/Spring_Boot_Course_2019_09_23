package customers;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
		ICustomerService customerService = context.getBean("customerService", ICustomerService.class);

		customerService.sayHello();
		customerService.addCustomer("Frank Brown", "fbrown@acme.com","mainstreet 5", "Chicago", "60613");
		
		context.close();
	}
}


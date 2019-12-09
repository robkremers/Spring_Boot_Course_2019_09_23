package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerService implements ICustomerService {
	private ICustomerDAO customerDAO;
	private IEmailSender emailSender;

	public void addCustomer(String name, String email, String street, String city, String zip) {
		Customer customer = new Customer(name, email);
		Address address = new Address(street, city, zip);
		customer.setAddress(address);
		customerDAO.save(customer);
		emailSender.sendEmail(email, "Welcome " + name + " as a new customer");
	}
	
	// First task: to show that everything works.
	public void sayHello() {
		System.out.println("Hello World!");
	}

	public ICustomerDAO getCustomerDAO() {
		return customerDAO;
	}

	@Autowired
	public void setCustomerDAO(ICustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	public IEmailSender getEmailSender() {
		return emailSender;
	}

	@Autowired
	public void setEmailSender(IEmailSender emailSender) {
		this.emailSender = emailSender;
	}
}

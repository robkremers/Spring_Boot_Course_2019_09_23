package jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
	private ICustomerDAO customerDAO;
	private IEmailSender emailSender;
	
	@Autowired
	public CustomerService(ICustomerDAO customerDAO, IEmailSender emailSender) {
		super();
		this.customerDAO = customerDAO;
		this.emailSender = emailSender;
	}

	public void addCustomer(int id, String name, String email, String street, String city, String zip) {
		Customer customer = new Customer(id, name, email);
		Address address = new Address(street, city, zip);
//		customer.setAddress(address);
		customerDAO.save(customer);
		emailSender.sendEmail(email, "Welcome " + name + " as a new customer");
	}
	
	public Customer getCustomer(int id) {
		return customerDAO.load(id);
	}
	
	public void updateCustomer(Customer customer) {
		customerDAO.update(customer);
	}
	
	public void deleteCustomer(Customer customer) {
		customerDAO.delete(customer);
	}
	
	// First task: to show that everything works.
	public void sayHello() {
		System.out.println("Hello World!");
	}

}

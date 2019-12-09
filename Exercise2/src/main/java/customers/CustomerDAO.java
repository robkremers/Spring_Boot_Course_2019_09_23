package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("customerDAO")
public class CustomerDAO implements ICustomerDAO{
	private ILogger logger;
	
	public CustomerDAO() {	
	}
	
	@Autowired
	public CustomerDAO(ILogger logger) {
		this.logger = logger;
	}
	
	public void save(Customer customer) {
		// simple sleep
		try {
			Thread.sleep(350);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("CustomerDAO: saving customer "+customer.getName());
		logger.log("Customer is saved in the DB: "+ customer.getName() );
	}

}

package jdbc;

import java.util.Collection;

public interface ICustomerDAO {
	void save(Customer customer);
	
	public void update(Customer customer);
	
	public Customer load(int customerNumber);
	
	public void delete(Customer customer);
	
	public Collection<Customer> getAllCustomers();
}

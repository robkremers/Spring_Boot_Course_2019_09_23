package jdbc;

public interface ICustomerService {
	public void sayHello();
	void addCustomer(int id, String name, String email, String street,String city, String zip);
	public Customer getCustomer(int id);
	public void updateCustomer(Customer customer);
	public void deleteCustomer(Customer customer);
}

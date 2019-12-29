package jdbc;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAO implements ICustomerDAO{
	
	private ILogger logger;
	private DataSource dataSource;

	public CustomerDAO() {	
	}
	
	@Autowired
	public CustomerDAO( ILogger logger
			          , DataSource dataSource
			          ) {
		this.logger = logger;
		this.dataSource = dataSource;
	}
	
	public void save(Customer customer) {
    	NamedParameterJdbcTemplate jdbcTempl = new NamedParameterJdbcTemplate(dataSource);
    	Map<String, Object> namedParameters = new HashMap<String, Object>();
    	namedParameters.put("id", new Integer(customer.getId()));
    	namedParameters.put("name", customer.getName());
    	namedParameters.put("email", customer.getEmail());
    	
    	int insertResult = jdbcTempl.update("INSERT INTO customer VALUES(:id,:name,:email)", namedParameters);
//		System.out.println("CustomerDAO: saving customer "+customer.getName());
		logger.log("Customer is saved in the DB: "+ customer.getName()
		          + " with insert result " + insertResult);
	}

	@Override
	public void update(Customer customer) {
    	NamedParameterJdbcTemplate jdbcTempl = new NamedParameterJdbcTemplate(dataSource);
       	Map<String, Object> namedParameters = new HashMap<String, Object>();
       	namedParameters.put("id", new Integer(customer.getId()));
    	namedParameters.put("name", customer.getName());
    	namedParameters.put("email", customer.getEmail());
   	
    	int updateResult = jdbcTempl.update("UPDATE customer SET email=:email, name = :name  WHERE id = :id",namedParameters);
    	logger.log("Customer is updated in the DB: "+ customer.getId() + ", " + customer.getName()
    	           + " with update result " + updateResult);
	}

	@Override
	public Customer load(int id) {
    	NamedParameterJdbcTemplate jdbcTempl = new NamedParameterJdbcTemplate(dataSource);
    	Map<String, Object> namedParameters = new HashMap<String, Object>();
    	namedParameters.put("id", id);
    	Customer customer = (Customer) jdbcTempl.queryForObject("SELECT * FROM customer WHERE id = :id ", namedParameters, 
        		(rs, rowNum) -> new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("email"))
        );
        return customer;
	}

	@Override
	public void delete(Customer customer) {
    	NamedParameterJdbcTemplate jdbcTempl = new NamedParameterJdbcTemplate(dataSource);
    	Map<String, Object> namedParameters = new HashMap<String, Object>();
    	namedParameters.put("id", new Integer(customer.getId()));

    	int deleteResult = jdbcTempl.update("DELETE FROM customer WHERE id = :id",namedParameters);
    	logger.log("Customer has been deleted from the DB: "+ customer.getId() + ", " + customer.getName()
    	           + " with result " + deleteResult);
	}

	@Override
	public Collection<Customer> getAllCustomers() {
    	NamedParameterJdbcTemplate jdbcTempl = new NamedParameterJdbcTemplate(dataSource);
        List<Customer> customerList = jdbcTempl.query("SELECT * FROM customer",
        		new HashMap<String, Customer>(), 
        		(rs, rowNum) -> new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("email")));
        return customerList;
	}

}

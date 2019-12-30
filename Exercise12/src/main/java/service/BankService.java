package service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import domain.Account;
import domain.Customer;
import domain.TraceRecord;
import repositories.AccountRepository;
import repositories.CustomerRepository;
import repositories.TraceRecordRepository;

@Service
public class BankService {
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private TraceRecordRepository traceRecordRepository;
	
    @Transactional(isolation=Isolation.DEFAULT, propagation=Propagation.REQUIRED)
	public void createCustomerAndAccount(int customerId, String customerName, String AccountNumber){
    	TraceRecord traceRecord = null;
    	try {
		Account account = new Account(AccountNumber);
		accountRepository.save(account);
		Customer customer = new Customer(customerId, customerName);
        customer.setAccount(account);
		customerRepository.save(customer);
		
		traceRecord = new TraceRecord("Successful created customer and account");
		traceRecordRepository.storeTraceRecord(traceRecord);
		
    	} catch(Exception e) {
    		traceRecord = new TraceRecord("Error: could not create customer and account");
//    		traceRecordRepository.storeTraceRecord(traceRecord);
    		traceRecordRepository.save(traceRecord);
    	}
	}

}

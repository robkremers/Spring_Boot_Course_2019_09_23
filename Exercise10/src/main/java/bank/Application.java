package bank;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import bank.domain.Account;
import bank.domain.AccountEntry;
import bank.domain.Customer;
import bank.service.IAccountService;

/**
 * a. Change the bank application in such a way that the Logger, CurrencyConverter,
 * AccountDAO and JMSSender are injected into the AccountService, rather than being
 * instantiated with new.
 * 
 * b. Now we want to extending the bank application to use AOP.
 * Use AOP to
 *	a) Log every call to any method in the bank.dao package (using the Logger).
 *	b) Use the Spring StopWatch functionality to measure the duration of all service level
 *	   methods (any method in the bank.service package) and output the results to the console.
 *	c) Log every JMS message that is sent (using the Logger)
 * 
 * @author robkr
 *
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

	private IAccountService accountService;
	
	@Autowired
	public Application(IAccountService accountService) {
		this.accountService = accountService;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// create 2 accounts;
		accountService.createAccount(1263862, "Frank Brown");
		accountService.createAccount(4253892, "John Doe");
		//use account 1;
		accountService.deposit(1263862, 240);
		accountService.deposit(1263862, 529);
		accountService.withdrawEuros(1263862, 230);
		//use account 2;
		accountService.deposit(4253892, 12450);
		accountService.depositEuros(4253892, 200);
		accountService.transferFunds(4253892, 1263862, 100, "payment of invoice 10232");
		// show balances
		
		Collection<Account> accountlist = accountService.getAllAccounts();
		Customer customer = null;
		for (Account account : accountlist) {
			customer = account.getCustomer();
			System.out.println("Statement for Account: " + account.getAccountnumber());
			System.out.println("Account Holder: " + customer.getName());
			System.out.println("-Date-------------------------"
							+ "-Description------------------"
							+ "-Amount-------------");
			for (AccountEntry entry : account.getEntryList()) {
				System.out.printf("%30s%30s%20.2f\n", entry.getDate()
						.toString(), entry.getDescription(), entry.getAmount());
			}
			System.out.println("----------------------------------------"
					+ "----------------------------------------");
			System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:",
					account.getBalance());
		}
		
	}

}



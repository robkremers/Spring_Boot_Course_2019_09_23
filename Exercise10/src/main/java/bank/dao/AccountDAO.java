package bank.dao;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bank.domain.Account;
import bank.repositories.AccountRepository;

@Repository
public class AccountDAO implements IAccountDAO {
	
	@Autowired
	private AccountRepository accountRepository;

	public void saveAccount(Account account) {
		accountRepository.save(account); // add the new
	}

	public void updateAccount(Account account) {
		accountRepository.save(account);
	}

	public Account loadAccount(long accountnumber) {
		Optional<Account> account = accountRepository.findById(accountnumber);
		if (account.isPresent()) {
			return account.get();
		} else {
			return null;
		}
	}

	public Collection<Account> getAccounts() {
		return accountRepository.findAll();
	}

}

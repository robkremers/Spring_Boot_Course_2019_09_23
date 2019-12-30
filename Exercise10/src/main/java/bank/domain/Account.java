package bank.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Account {
	
	@Id
	long accountnumber;
	
	/**
	 * An account can have many account entries.
	 * So the foreign key will be in table ACCOUNTENTRY.
	 */
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="accountid") // The foreign key will be present in the table ACCOUNTENTRY.
	Collection<AccountEntry> entryList = new ArrayList<AccountEntry>();
	
	/**
	 * A customer can have many accounts.
	 * So the foreign key will be in table ACCOUNT.
	 */
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="customerid")
	Customer customer;

	public Account() {}
	
	public Account (long accountnr){
		this.accountnumber = accountnr;
	}
	
	public long getAccountnumber() {
		return accountnumber;
	}
	
	public void setAccountnumber(long accountnumber) {
		this.accountnumber = accountnumber;
	}
	public double getBalance() {
		double balance=0;
		for (AccountEntry entry : entryList) {
			balance+=entry.getAmount();
		}
		return balance;
	}
	public void deposit(double amount){
		AccountEntry entry = new AccountEntry(new Date(), amount, "deposit", "", "");
		entryList.add(entry);
	}
	
	public void withdraw(double amount){
		AccountEntry entry = new AccountEntry(new Date(), -amount, "withdraw", "", "");
		entryList.add(entry);	
	}

	private void addEntry(AccountEntry entry){
		entryList.add(entry);
	}

	public void transferFunds(Account toAccount, double amount, String description){
		AccountEntry fromEntry = new AccountEntry(new Date(), -amount, description, ""+toAccount.getAccountnumber(), toAccount.getCustomer().getName());
		AccountEntry toEntry = new AccountEntry(new Date(), amount, description, ""+toAccount.getAccountnumber(), toAccount.getCustomer().getName());
		entryList.add(fromEntry);	
		toAccount.addEntry(toEntry);
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Collection<AccountEntry> getEntryList() {
		return entryList;
	}

}

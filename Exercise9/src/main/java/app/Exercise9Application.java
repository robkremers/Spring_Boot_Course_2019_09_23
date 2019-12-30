package app;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import domain.Book;
import domain.Customer;
import repositories.BookRepository;
import repositories.CustomerRepository;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain") 
public class Exercise9Application implements CommandLineRunner{
	
	@Autowired
	CustomerRepository customerrepository;
	
	@Autowired
	BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(Exercise9Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customerrepository.save(new Customer("Jack", "Bauer", "jack@acme.com"));
		customerrepository.save(new Customer("Chloe", "O'Brian", "chloe@acme.com"));
		customerrepository.save(new Customer("Kim", "Bauer", "kim@acme.com"));
		customerrepository.save(new Customer("David", "Palmer", "dpalmer@gmail.com"));
		customerrepository.save(new Customer("Michelle", "Dessler", "mich@hotmail.com"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : customerrepository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer by ID
		Optional<Customer> custOpt = customerrepository.findById(1L);
		Customer customer = custOpt.get();
		System.out.println("Customer found with findOne(1L):");
		System.out.println("--------------------------------");
		System.out.println(customer);
		System.out.println();

		// fetch customers by last name
		System.out.println("Customer found with findByLastName('Bauer'):");
		for (Customer cust : customerrepository.findByLastName("Bauer")) {
			System.out.println(cust);
		}

		// fetch customers by email
		System.out.println("--------------------------------------------");
		System.out.println("Customer found with findByEmail(\"dpalmer@gmail.com\"):");
		Optional<Customer> custopt = customerrepository.findByEmail("dpalmer@gmail.com");
		if (custopt.isPresent()) {
			Customer thecustomer = custopt.get();
			System.out.println(thecustomer);
		}

		// fetch customers by first and last name
		System.out.println("--------------------------------------------");
		System.out.println("Customer found with findByFirstNameAndLastName(\"Chloe\", \"O'Brian\"):");
		Customer cust = customerrepository.findByFirstNameAndLastName("Chloe", "O'Brian");
		System.out.println(cust);

		// fetch the first 2 customers 
		System.out.println("--------------------------------------------");
		System.out.println("Customer found with findFirst2By:");
		for (Customer cust2 : customerrepository.findFirst2By()) {
			System.out.println(cust2);
		}
		
		// fetch customers last name by first name
		System.out.println("--------------------------------------------");
		System.out.println("Customer found with findLastNameByFirstName('Chloe'):");
		String lastname = customerrepository.findLastNameByFirstName("Chloe");
		System.out.println(lastname);
		
		System.out.println("================== Books ==================");
		
		// Create 3 books, and save them in the database
		bookRepository.save( new Book("Title1", "ISBN1", "Author1", 15.3) );
		bookRepository.save( new Book("Title2", "ISBN2", "Author2", 25.5) );
		bookRepository.save( new Book("Title3", "ISBN3", "Author3", 10.7) );
		Book book4 = new Book("Title4", "ISBN4", "Author4", 10.7);
		bookRepository.save(book4);
		
		// Retrieve all books from the database and display them in the console
		System.out.println("Books found with findAll():");
		System.out.println("-------------------------------");		
		for ( Book book : bookRepository.findAll() ) {
			System.out.println(book);
		}
		
		// Update a book
		Optional<Book> bookOpt = bookRepository.findById(1L);
		Book bookFound = bookOpt.get();
		System.out.println("Book found with findOne(1L):");
		System.out.println("--------------------------------");
		System.out.println(bookFound);
		bookFound.setTitle("Title1 updated");
		bookRepository.save(bookFound);
		System.out.println();
		
		// Delete a book (not the book that was just updated)
		System.out.println("Deleting book:");
		System.out.println("--------------------------------");
		System.out.println(book4);
		bookRepository.delete(book4);
		System.out.println();
		
		// Retrieve all books from the database again and display them in the console
		System.out.println("Books found with findAll() after update and delete:");
		System.out.println("-------------------------------");		
		for ( Book book : bookRepository.findAll() ) {
			System.out.println(book);
		}
		System.out.println();
		
		// Find all books with a price larger than a given minimum price.
		System.out.println("Books found with minimum price 11.0:");
		System.out.println("-------------------------------");		
		for( Book book: bookRepository.findBooksWithPriceLargerThen(11.0)) {
			System.out.println(book);
		}
		System.out.println();
		
	}

}

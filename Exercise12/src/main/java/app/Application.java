package app;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import service.BankService;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain") 
@ComponentScan("service")
public class Application implements CommandLineRunner{
	
	@Autowired
	BankService bankService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		bankService.createCustomerAndAccount(12, "Jack Bauer", "1223");
		bankService.createCustomerAndAccount(14, "Frank Brown", "1248");
	}
}

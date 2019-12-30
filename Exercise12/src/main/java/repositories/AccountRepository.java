package repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import domain.Account;


public interface AccountRepository extends JpaRepository<Account, Long> {

}





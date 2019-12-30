package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import domain.Book;

/**
 * Tip:
 * Use ctrl + space when typing the method titles. This will show you the options.
 * 
 * @author robkr
 *
 */
public interface BookRepository extends JpaRepository<Book, Long> {
	
	List<Book> findByTitle(String title);
	List<Book> findByTitleStartsWith(String title);
	
	@Query("select b from Book b where b.price > :minimumPrice")
	List<Book> findBooksWithPriceLargerThen(@Param("minimumPrice") double minimumPrice);
	
	@Query("select b from Book b where b.price > :minimumPrice and b.author = :author")
	List<Book> findBooksWithPriceLargerThenAndAuthor(@Param("minimumPrice") double minimumPrice, @Param("author") String author);

}

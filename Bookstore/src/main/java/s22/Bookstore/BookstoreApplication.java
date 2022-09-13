package s22.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import s22.Bookstore.domain.Book;
import s22.Bookstore.domain.BookRepository;
import s22.Bookstore.domain.Category;
import s22.Bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookstoreDemo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			log.info("save a couple of books");			
			crepository.save(new Category("roskaa"));
			crepository.save(new Category("asiaa"));
			crepository.save(new Category("timanttii"));
			
			repository.save(new Book("John", "Johnson", "aaa", 123, 1234, crepository.findByName("timanttii").get(0)));
			repository.save(new Book("Katy", "Kateson", "aaa", 123, 1234, crepository.findByName("roskaa").get(0)));							
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}

}

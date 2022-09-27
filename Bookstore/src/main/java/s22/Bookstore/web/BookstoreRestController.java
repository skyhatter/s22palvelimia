package s22.Bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import s22.Bookstore.domain.Book;
import s22.Bookstore.domain.BookRepository;

	@RestController
	public class BookstoreRestController {
		
		@Autowired
		BookRepository bookRepository;
		
	    @RequestMapping(value={"/book", "/books"}, method = RequestMethod.GET)
	    public @ResponseBody List<Book> booklistRest() {	
	        return (List<Book>) bookRepository.findAll();
	    }
	    
		@PostMapping("books")
		Book addbook(@RequestBody Book addbook) {
			return bookRepository.save(addbook);
		}
		
		@PostMapping("books/{id}")
		Book editbook(@RequestBody Book editbook, @PathVariable Long id) {
			return bookRepository.save(editbook);
		}
		
		@DeleteMapping("/books/{id}")
		public Iterable<Book> deletebook(@PathVariable Long id) {
			bookRepository.deleteById(id);
			return bookRepository.findAll();
		}

	    @RequestMapping(value="/book/{id}", method = RequestMethod.GET)
	    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {	
	    	return bookRepository.findById(bookId);
	    }
	    
	}

package s22.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import s22.Bookstore.domain.Book;
import s22.Bookstore.domain.BookRepository;
import s22.Bookstore.domain.CategoryRepository;

@Controller
public class BookstoreController {
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository crepository;
	
	@RequestMapping(value={"/", "/booklist"})
	public String booklist(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	
    @RequestMapping(value = "/add")
    public String addBook(Model model){
    	model.addAttribute("book", new Book());
    	model.addAttribute("categories", crepository.findAll());
        return "addbook";
    }  
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        repository.save(book);
        return "redirect:booklist";
    } 
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
    	repository.deleteById(bookId);
        return "redirect:../booklist";
    } 
    
    @RequestMapping(value = "/edit/{id}")
    public String addBook(@PathVariable("id") Long bookId, Model model){
    	model.addAttribute("book", repository.findById(bookId));
    	model.addAttribute("categories", crepository.findAll());
        return "editbook";
    }
}

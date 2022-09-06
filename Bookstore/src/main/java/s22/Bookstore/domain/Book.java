package s22.Bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String title, author, isbn;
	private int bookyear;
	private double price;
	
	public Book() {
	}
	
	public Book(String title, String author, String isbn, int bookyear, double price) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.bookyear = bookyear;
		this.price = price;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public int getBookyear() {
		return bookyear;
	}

	public void setBookyear(int bookyear) {
		this.bookyear = bookyear;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + ", bookyear=" + bookyear
				+ ", price=" + price + "]";
	}
	
}

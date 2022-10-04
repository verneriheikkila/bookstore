package fi.SWD4TN020.bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String isbn, title, author, yearPublished;
	
    @ManyToOne
    @JsonIgnoreProperties ("students") 
    @JoinColumn(name = "categoryid")
    private Category category;

	public Book() {}
	
	public Book(String isbn, String title, String author, String yearPublished, Category category) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.yearPublished = yearPublished;
		this.category = category;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
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
	public String getYearPublished() {
		return yearPublished;
	}
	public void setYearPublished(String yearPublished) {
		this.yearPublished = yearPublished;
	}	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		if (this.category != null)
			return "Book [id=" + id + ", isbn=" + isbn + ", title=" + title + ", author=" + author+ ", yearPublished="+ yearPublished + " category =" + this.getCategory() + "]";		
		else
			return "Book [id=" + id + ", isbn=" + isbn + ", title=" + title + ", author=" + author+ ", yearPublished="+ yearPublished + " category =" + "]";
	}

	
}

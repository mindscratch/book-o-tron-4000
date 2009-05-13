package bookotron.data.hbm;

import javax.persistence.*;
import javax.persistence.GenerationType;



@Entity
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String title;
	
	@Column(nullable=false)
	private String author;
	
	@Column(nullable=false)
	private String isbn;
	
	
	public Long getId() {
		return id;
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
	
	
	@Override
	public String toString() {
		return "Book: [\n" +
				"\tId: " +getId()+ "\n" +
				"\tTitle: " +getTitle()+ "\n" +
				"\tAuthor: " +getAuthor()+ "\n" +
				"\tIsbn: " +getIsbn()+ "\n" +
				"]";
	}
	
}

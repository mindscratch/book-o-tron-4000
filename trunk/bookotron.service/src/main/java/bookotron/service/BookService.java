package bookotron.service;

import bookotron.data.model.entity.impl.content.text.book.BookTextContent;

public interface BookService {

	public BookTextContent getBook(Long id);
	
	public BookTextContent createBook(Long id, BookTextContent book);
	
	public BookTextContent updateBook(Long id, BookTextContent book);
	
	public Boolean deleteBook(Long id);
	
}

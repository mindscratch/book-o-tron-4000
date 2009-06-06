package bookotron.service.impl;

import org.springframework.stereotype.Service;

import bookotron.data.model.entity.impl.content.text.book.BookTextContent;
import bookotron.service.BookService;

@Service("bookService")
public class BookServiceImpl implements BookService {

	@Override
	public BookTextContent createBook(Long id, BookTextContent book) {
		book.setId(id);
		return book;
	}

	@Override
	public Boolean deleteBook(Long id) {
		return true;
	}

	@Override
	public BookTextContent getBook(Long id) {
		BookTextContent book = new BookTextContent();
		book.setId(id);
		return book;
	}

	@Override
	public BookTextContent updateBook(Long id, BookTextContent book) {
		book.setId(id);
		return book;
	}

}

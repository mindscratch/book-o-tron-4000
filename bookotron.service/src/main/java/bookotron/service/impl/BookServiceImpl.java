package bookotron.service.impl;

import org.springframework.stereotype.Service;

import bookotron.data.model.entity.impl.content.text.book.BookTextContent;
import bookotron.data.model.entity.impl.content.text.pdf.PdfTextContent;
import bookotron.service.BookService;

@Service("bookService")
public class BookServiceImpl implements BookService {

	
	@Override
	public BookTextContent getTextBook(Long id) {
		BookTextContent book = new BookTextContent();
		book.setId(id);
		return book;
	}
	
	
	@Override
	public PdfTextContent getPdfBook(Long id) {
		PdfTextContent book = new PdfTextContent();
		book.setId(id);
		return book;
	}
	

	@Override
	public BookTextContent updateTextBook(Long id, BookTextContent book) {
		book.setId(id);
		return book;
	}
	
	@Override
	public PdfTextContent updatePdfBook(Long id, PdfTextContent book) {
		book.setId(id);
		return book;
	}
	
	
	@Override
	public BookTextContent createTextBook(BookTextContent book) {
		book.setId(1);
		return book;
	}
	

	@Override
	public PdfTextContent createPdfBook(PdfTextContent book) {
		book.setId(1);
		return book;
	}

	
	@Override
	public Boolean deleteTextBook(Long id) {
		return true;
	}
	
	
	@Override
	public Boolean deletePdfBook(Long id) {
		return true;
	}

	

	

}

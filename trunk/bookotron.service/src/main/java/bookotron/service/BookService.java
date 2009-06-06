package bookotron.service;

import bookotron.data.model.entity.impl.content.text.book.BookTextContent;
import bookotron.data.model.entity.impl.content.text.pdf.PdfTextContent;

public interface BookService {

	public BookTextContent getTextBook(Long id);
	
	public PdfTextContent getPdfBook(Long id);
	
	public BookTextContent createTextBook(BookTextContent book);
	
	public PdfTextContent createPdfBook(PdfTextContent book);
	
	public BookTextContent updateTextBook(Long id, BookTextContent book);
	
	public PdfTextContent updatePdfBook(Long id, PdfTextContent book);
	
	public Boolean deleteTextBook(Long id);
	
	public Boolean deletePdfBook(Long id);
	
}

package bookotron.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import bookotron.data.dao.IBaseDao;
import bookotron.data.model.entity.impl.content.text.book.BookTextContent;
import bookotron.data.model.entity.impl.content.text.pdf.PdfTextContent;
import bookotron.service.BookService;

@Service("bookService")
public class BookServiceImpl implements BookService {

    private IBaseDao<BookTextContent> textBookDao;
	private IBaseDao<PdfTextContent> pdfBookDao;

	
	@Autowired
	public BookServiceImpl(@Qualifier("bookTextDao")IBaseDao<BookTextContent> textBookDao, @Qualifier("bookPdfDao")IBaseDao<PdfTextContent> pdfBookDao) {
		this.textBookDao = textBookDao;
		this.pdfBookDao = pdfBookDao;
	}
	
	@Override
	public BookTextContent getTextBook(Long id) {
		return textBookDao.find(id);
	}
	
	
	@Override
	public PdfTextContent getPdfBook(Long id) {
		return pdfBookDao.find(id);
	}
	

	@Override
	public BookTextContent updateTextBook(Long id, BookTextContent book) {
		book.setId(id);
		BookTextContent updatedBook = textBookDao.update(book);
		return updatedBook;
	}
	
	
	@Override
	public PdfTextContent updatePdfBook(Long id, PdfTextContent book) {
		book.setId(id);
		PdfTextContent updatedBook = pdfBookDao.update(book);
		return updatedBook;
	}
	
	
	@Override
	public BookTextContent createTextBook(BookTextContent book) {
		BookTextContent createdBook = textBookDao.insert(book);
		return createdBook;
	}
	

	@Override
	public PdfTextContent createPdfBook(PdfTextContent book) {
		PdfTextContent createdBook = pdfBookDao.insert(book);
		return createdBook;
	}

	
	@Override
	public Boolean deleteTextBook(Long id) {
		BookTextContent bookToDelete = textBookDao.find(id);
		textBookDao.remove(bookToDelete);
		return Boolean.TRUE;
	}
	
	
	@Override
	public Boolean deletePdfBook(Long id) {
		PdfTextContent bookToDelete = pdfBookDao.find(id);
		pdfBookDao.remove(bookToDelete);
		return Boolean.TRUE;
	}

	@Override
	public Boolean checkOutPdfBook(Long bookId, Long userId) {
		// TODO Auto-generated method stub
		return Boolean.TRUE;
	}

	@Override
	public Boolean checkOutTextBook(Long bookId, Long userId) {
		// TODO Auto-generated method stub
		return Boolean.TRUE;
	}

	

	

}

package bookotron.data.dao;

import bookotron.data.hbm.Book;

public interface BookDao {

	public Book getBookById(Long id);
}

package bookotron.data.dao.impl;

import org.springframework.stereotype.Repository;

import bookotron.data.dao.BookDao;
import bookotron.data.hbm.Book;

@Repository("bookDao")
public class BookDaoImpl implements BookDao {

	@Override
	public Book getBookById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}

package bookotron.data.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bookotron.data.dao.BookDao;
import bookotron.data.hbm.Book;

@Transactional
@Repository("bookDao")
public class BookDaoImpl implements BookDao {

	private SessionFactory sessionFactory;
	
	@Autowired
	BookDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public Book getBookById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return (Book)session.load(Book.class, id);
	}

	@Override
	public Book saveOrUpdate(Book book) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(book);
		return book;
	}
	
	

}

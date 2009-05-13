package bookotron.data;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.AbstractDependencyInjectionSpringContextTests;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import bookotron.data.dao.BookDao;
import bookotron.data.hbm.Book;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:bookotron-data.xml"})
public class SpringConfigurationTest extends AbstractDependencyInjectionSpringContextTests {

	@Autowired
	BookDao bookDao;
	
	@Test
	public void testBookSaveAndRetrieve() {
		Book book = new Book();
		book.setAuthor("Name");
		book.setTitle("title");
		book.setIsbn("1234");
		bookDao.saveOrUpdate(book);
		assertTrue(book.getId() > 0);
		Book newBook = bookDao.getBookById(book.getId());
		assertNotNull(newBook);
		assertTrue(newBook.getId() == book.getId());
	}
}

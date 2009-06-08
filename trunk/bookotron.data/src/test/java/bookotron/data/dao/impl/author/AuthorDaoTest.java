package bookotron.data.dao.impl.author;

import bookotron.data.model.entity.impl.author.Author;
import bookotron.data.dao.IBaseDao;
import bookotron.data.dao.impl.AbstractDaoTest;
import bookotron.model.entity.author.IAuthor;
import bookotron.model.exception.EntityNotFoundException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public class AuthorDaoTest extends AbstractDaoTest {

    private static final Log log = LogFactory.getLog(AuthorDaoTest.class);

    @Autowired
    @Qualifier("authorDao")
    private IBaseDao<IAuthor> dao;

    @Test
    public void testInsert() {
        final IAuthor author = new Author();
        author.setFirstName("John");
        author.setLastName("Doe");

        log.debug("Persisting: " + author);

        final IAuthor insertedAuthor = dao.insert(author);
        assertNotNull(insertedAuthor);

        final IAuthor persistedAuthor = dao.find(insertedAuthor.getId());
        assertTrue(insertedAuthor.equals(persistedAuthor));
    }

    @Test
    public void testUpdate() {
        // get an author to update
        IAuthor author = dao.find(1);
        assertNotNull("Expected to retrieve author with ID=1", author);

        // change a property
        author.setLastName("ZingZang");

        // update the author
        author = dao.update(author);

        // verify the change
        assertEquals("ZingZang", author.getLastName());

        // just to make sure, get it from the DB
        author = dao.find(author.getId());
        assertEquals("ZingZang", author.getLastName());
    }

    @Test
    public void testFindAll() {
        List<IAuthor> authors = dao.findAll();

        log.debug("Retrieved authors...");
        if (authors != null && authors.size() > 0) {
            for (IAuthor author : authors) {
                log.debug("Found Author: " + author);
            }
        }

        assertEquals(1, authors.size());
    }

    @Test
    public void testRemove() {
        IAuthor author = dao.find(1);
        assertNotNull("Expected to retrieve author with ID=1", author);

        log.debug("Removing: " + author);
        dao.remove(author);

        author = dao.find(author.getId());
        assertTrue("Expected author, id=" + author.getId() + ", to have been deleted", author.isDeleted());
    }

    @Test
    public void testFind() {
        IAuthor author = dao.find(1);
        assertNotNull("Expected to retrieve author with ID=1", author);


    }

    @Test(expected = EntityNotFoundException.class)
    public void testFindNonExistantAuthor() {
        final long id = 98765;
        final IAuthor author = dao.find(id);
        assertNull("Expected author to not exist with id=" + id + ", however an author was found: " + author, author);
    }
}

package bookotron.data.dao.impl;

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.dbunit.operation.DatabaseOperation;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import bookotron.data.dao.IBaseDao;
import bookotron.data.model.entity.impl.author.Author;
import bookotron.model.entity.author.IAuthor;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.util.List;

public class AuthorDaoTest extends AbstractDaoTest<IAuthor> {
    @Test
    public void testSave() {
        final IAuthor author = new Author();
        author.setFirstName("John");
        author.setLastName("Doe");

        final IAuthor insertedAuthor = dao.insert(author);
        assertNotNull(insertedAuthor);

        final IAuthor persistedAuthor = dao.find(insertedAuthor.getId());
        assertTrue(insertedAuthor.equals(persistedAuthor));
    }

    @Test
    public void testFindAll() {
        List<IAuthor> authors = dao.findAll();
        assertEquals(1, authors.size());
    }
}
